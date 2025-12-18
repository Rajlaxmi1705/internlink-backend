package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.model.Internship;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.InternshipRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin
public class InternshipController {

    private final InternshipRepository internshipRepo;
    private final ApplicationRepository applicationRepo;

    public InternshipController(InternshipRepository internshipRepo,
                                ApplicationRepository applicationRepo) {
        this.internshipRepo = internshipRepo;
        this.applicationRepo = applicationRepo;
    }

    // ✅ 1. GET ALL INTERNSHIPS
    @GetMapping
    public List<Internship> getAll() {
        return internshipRepo.findAll();
    }

    // ✅ 2. GET INTERNSHIP BY ID (FOR DETAILS PAGE)
    @GetMapping("/{id}")
    public Internship getById(@PathVariable Long id) {
        return internshipRepo.findById(id).orElse(null);
    }

    // ✅ 3. APPLY FOR INTERNSHIP
    @PostMapping("/{id}/apply")
    public String applyInternship(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Double sscMarks,
            @RequestParam Double hscMarks,
            @RequestParam String college,
            @RequestParam MultipartFile resume
    ) throws Exception {

        Internship internship = internshipRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship not found"));

        // ✅ FIXED UPLOAD DIRECTORY (outside tomcat)
        String uploadDir = "C:/internlink/uploads/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs(); // create folder if not exists
        }

        String fileName = System.currentTimeMillis() + "_" + resume.getOriginalFilename();
        File dest = new File(uploadDir + fileName);
        resume.transferTo(dest);

        Application app = new Application();
        app.setName(name);
        app.setEmail(email);
        app.setSscMarks(sscMarks);
        app.setHscMarks(hscMarks);
        app.setCollege(college);
        app.setResumePath(dest.getAbsolutePath());
        app.setInternship(internship);

        applicationRepo.save(app);

        return "Application submitted successfully";
    }
}

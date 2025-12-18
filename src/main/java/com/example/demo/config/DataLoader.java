package com.example.demo.config;

import com.example.demo.model.Internship;
import com.example.demo.repository.InternshipRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadInternships(InternshipRepository repo) {
        return args -> {

            if (repo.count() == 0) {

                repo.save(new Internship(
                        "Java Developer Intern",
                        "TCS",
                        "Work on backend applications using Java, Spring Boot and MySQL.",
                        "6 Months",
                        "₹10,000 / month",
                        "Pune"
                ));

                repo.save(new Internship(
                        "Frontend Developer Intern",
                        "Accenture",
                        "Develop responsive UI using HTML, CSS, JavaScript and React.",
                        "3 Months",
                        "₹8,000 / month",
                        "Remote"
                ));

                repo.save(new Internship(
                        "Backend Developer Intern",
                        "Infosys",
                        "Build REST APIs using Spring Boot, Hibernate and MySQL.",
                        "6 Months",
                        "₹12,000 / month",
                        "Bangalore"
                ));

                repo.save(new Internship(
                        "Full Stack Developer Intern",
                        "Wipro",
                        "End-to-end web development using React, Spring Boot and MySQL.",
                        "6 Months",
                        "₹15,000 / month",
                        "Hyderabad"
                ));

                repo.save(new Internship(
                        "Data Analyst Intern",
                        "Capgemini",
                        "Analyze datasets, create dashboards using Excel and Power BI.",
                        "4 Months",
                        "₹9,000 / month",
                        "Mumbai"
                ));

                repo.save(new Internship(
                        "Data Science Intern",
                        "IBM",
                        "Work with Python, Pandas, Machine Learning models and data analysis.",
                        "6 Months",
                        "₹18,000 / month",
                        "Remote"
                ));

                repo.save(new Internship(
                        "AI & ML Intern",
                        "Microsoft",
                        "Develop machine learning models and AI-based applications.",
                        "6 Months",
                        "₹20,000 / month",
                        "Bangalore"
                ));

                repo.save(new Internship(
                        "Cloud Computing Intern",
                        "Amazon AWS",
                        "Learn cloud infrastructure, EC2, S3, IAM and DevOps basics.",
                        "3 Months",
                        "₹14,000 / month",
                        "Remote"
                ));

                repo.save(new Internship(
                        "Cyber Security Intern",
                        "Cisco",
                        "Work on network security, penetration testing and risk analysis.",
                        "6 Months",
                        "₹16,000 / month",
                        "Delhi"
                ));

                repo.save(new Internship(
                        "Mobile App Developer Intern",
                        "Google",
                        "Develop Android apps using Java/Kotlin and Firebase.",
                        "6 Months",
                        "₹20,000 / month",
                        "Bangalore"
                ));
            }
        };
    }
}

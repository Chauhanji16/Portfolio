package com.skillab.portfolio.controller;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.skillab.portfolio.model.Skill;

import org.springframework.ui.Model;

@Controller 
public class HomeController {
@GetMapping("/")
public String home(Model model){
    model.addAttribute("name","Sahil Singh");
    model.addAttribute("title","java Backand developer");
    model.addAttribute("tagline","I build web application with java and spring boot -" + 
        "and I'm looking for my first role as a backand developer ."
    );
    
// ---- About Section ----
model.addAttribute(
    "about",
    "I'm a final-year BCA  student at SHEAT College of Engineering, "
        + "Varanasi. I like building things that actually run, and I've "
        + "spent the last year learning Java and Spring Boot properly."
);

model.addAttribute("location", "Varanasi, India");
model.addAttribute("email", "devansh161515101singh@gmial.com");
model.addAttribute("github", "https://github.com/Chauhanji16");
model.addAttribute("linkedin", "https://linkedin.com/in/sahilsingh16");
model.addAttribute("resumeUrl", "https://drive.google.com/");
  // Step 1: Create a list of skills
        List<Skill> skills = new ArrayList<>();

        // Frontend skills
        skills.add(new Skill("HTML", "Frontend"));
        skills.add(new Skill("CSS", "Frontend"));
        skills.add(new Skill("JavaScript", "Frontend"));
        skills.add(new Skill("Thymeleaf", "Frontend"));

        // Backend skills
        skills.add(new Skill("Java", "Backend"));
        skills.add(new Skill("Spring Boot", "Backend"));
        skills.add(new Skill("Spring MVC", "Backend"));
        skills.add(new Skill("Spring Data JPA", "Backend"));
        skills.add(new Skill("REST APIs", "Backend"));
        skills.add(new Skill("PostgreSQL", "Backend"));

        // Tools
        skills.add(new Skill("Git & GitHub", "Tools"));
        skills.add(new Skill("IntelliJ IDEA", "Tools"));
        skills.add(new Skill("Maven", "Tools"));
        skills.add(new Skill("Postman", "Tools"));

        // Step 2: Group skills by category
        Map<String, List<Skill>> skillsByCategory =
                new LinkedHashMap<>();

        for (Skill skill : skills) {

            skillsByCategory.putIfAbsent(
                    skill.getCategory(),
                    new ArrayList<>()
            );

            skillsByCategory.get(skill.getCategory()).add(skill);
        }

        // Step 3: Send grouped skills to HTML
        model.addAttribute("skillsByCategory", skillsByCategory);


     return "index";
}
    
}

package com.dhana.OnlineLearning.controller;

import com.dhana.OnlineLearning.model.Enrollment;
import com.dhana.OnlineLearning.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollment")
@CrossOrigin("*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/enroll")
    public String enroll(@RequestParam Long userId, @RequestParam Long courseId) {
        Enrollment enrollment = enrollmentService.enrollUserToCourse(userId, courseId);
        return "Enrollment successful for user " + userId + " to course " + courseId;
    }
}

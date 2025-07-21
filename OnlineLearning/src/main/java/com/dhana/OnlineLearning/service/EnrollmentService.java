package com.dhana.OnlineLearning.service;

import com.dhana.OnlineLearning.model.Course;
import com.dhana.OnlineLearning.model.Enrollment;
import com.dhana.OnlineLearning.model.User;
import com.dhana.OnlineLearning.repository.CourseRepository;
import com.dhana.OnlineLearning.repository.EnrollmentRepository;
import com.dhana.OnlineLearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CourseRepository courseRepo;

    public Enrollment enrollUserToCourse(Long userId, Long courseId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDateTime.now());

        return enrollmentRepo.save(enrollment);
    }
}

package com.dhana.OnlineLearning.controller;

import com.dhana.OnlineLearning.model.Course;
import com.dhana.OnlineLearning.model.User;
import com.dhana.OnlineLearning.repository.CourseRepository;
import com.dhana.OnlineLearning.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.security.*;
import java.util.*;
import com.dhana.OnlineLearning.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Courses")
public class CourseController {

    @Autowired
    private CourseService courseService;
    private UserRepository userRepository;
    private CourseRepository courseRepository;

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse (@RequestBody Course course){
        Course saved = courseService.createCourse(course);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long Id) {
        Course course = courseService.getCourseById(Id);
        return ResponseEntity.ok(course);
    }

    //Update course
    @PutMapping("/{Id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long Id, @RequestBody Course updatedCourse) {
        Course course = courseService.updateCourse(Id, updatedCourse);
        return ResponseEntity.ok(course);
    }
    // Delete course
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long Id) {
        courseService.deleteCourse(Id);
        return ResponseEntity.ok("Course deleted successfully");
    }
    @PostMapping("/enroll/{courseId}")
    public ResponseEntity<String> enrollCourse(@PathVariable Long courseId, Principal principal) {
        String email = principal.getName(); // Extracts email from JWT token
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("Course not found"));

        user.getEnrolledCourses().add(course);
        userRepository.save(user);

        return ResponseEntity.ok("Successfully enrolled in course: " + course.getTitle());
    }

}


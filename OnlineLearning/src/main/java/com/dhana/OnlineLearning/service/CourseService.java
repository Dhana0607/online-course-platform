package com.dhana.OnlineLearning.service;

import com.dhana.OnlineLearning.model.Course;
import com.dhana.OnlineLearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    //save a new course
    public Course createCourse (Course course){
        return courseRepository.save(course);
    }
    //Get all Courses
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    //get a course by id
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }
    //update an existing course
    public Course updateCourse(long Id, Course updatedCourse){
        return courseRepository.findById(Id)
                .map(course -> {
                    course.setTitle(updatedCourse.getTitle());
                    course.setDescription(updatedCourse.getDescription());
                    course.setInstructorName(updatedCourse.getInstructorName());
                    return courseRepository.save(course);
                })
                .orElseThrow(() -> new RuntimeException("Course Not Found with Id "+ Id));
    }

    public void deleteCourse(long Id){
        courseRepository.deleteById(Id);
    }
}

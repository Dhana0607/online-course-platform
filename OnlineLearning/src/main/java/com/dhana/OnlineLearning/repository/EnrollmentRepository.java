package com.dhana.OnlineLearning.repository;

import com.dhana.OnlineLearning.model.Course;
import com.dhana.OnlineLearning.model.Enrollment;
import com.dhana.OnlineLearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository  <Enrollment, Long>{

   /* List<Enrollment> findByUser(User user);
    boolean existsByUserAndCourse(User user, Course course);*/
}

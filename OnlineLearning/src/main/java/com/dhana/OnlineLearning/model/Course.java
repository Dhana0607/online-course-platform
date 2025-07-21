package com.dhana.OnlineLearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import java.util.*;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String description;
    private String InstructorName;
    private double price;
    private String category;

    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<User> enrolledUsers = new HashSet<>();
}
package com.dhana.OnlineLearning.repository;

import com.dhana.OnlineLearning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository <User, Long> {
}

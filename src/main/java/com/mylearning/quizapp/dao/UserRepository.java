package com.mylearning.quizapp.dao;

import com.mylearning.quizapp.entity.Question;
import com.mylearning.quizapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

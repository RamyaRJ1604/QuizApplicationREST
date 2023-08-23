package com.mylearning.quizapp.dao;

import com.mylearning.quizapp.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    Result findByStudentId(int id);
}

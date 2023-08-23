package com.mylearning.quizapp.service;

import com.mylearning.quizapp.dao.AnswerRepository;
import com.mylearning.quizapp.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    
    public List<Answer> findAll() {
        List<Answer> answers = answerRepository.findAll();
        return answers;
    }
    
    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }


    public void deleteById(int id) {
        answerRepository.deleteById(id);
    }


    public Answer findById(int id) {
        Optional<Answer> result = answerRepository.findById(id);
        Answer tempAnswer = null;
        if(result.isPresent()){
            tempAnswer = result.get();
        }
        else{
            throw new RuntimeException("Did not find answer with id: " + id);
        }
        return tempAnswer;
    }
}

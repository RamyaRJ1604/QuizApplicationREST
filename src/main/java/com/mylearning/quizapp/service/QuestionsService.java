package com.mylearning.quizapp.service;

import com.mylearning.quizapp.dao.QuestionRepository;
import com.mylearning.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    //private QuestionDAO questionDAO;
    private QuestionRepository questionRepository;

    @Autowired
    public QuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public Question save(Question theQuestion) {
        return questionRepository.save(theQuestion);
    }

    @Transactional
    public void deleteById(int theId) {
        questionRepository.deleteById(theId);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(int theId) {
        Optional<Question> result = questionRepository.findById(theId);
        Question tempQuestion = null;
        if(result.isPresent()){
            tempQuestion = result.get();
        }
        else{
            throw new RuntimeException("Did not find Question with id: " + theId);
        }
        return tempQuestion;
    }
}

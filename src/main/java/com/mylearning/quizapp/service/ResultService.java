package com.mylearning.quizapp.service;

import com.mylearning.quizapp.dao.ResultRepository;
import com.mylearning.quizapp.entity.Answer;
import com.mylearning.quizapp.entity.Response;
import com.mylearning.quizapp.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService{

    private ResultRepository resultRepository;

    private AnswerService answerService;
    private ResponseService responseService;

    @Autowired
    public ResultService(ResultRepository resultRepository, AnswerService answerService, ResponseService responseService) {
        this.resultRepository = resultRepository;
        this.answerService = answerService;
        this.responseService = responseService;
    }

    public int calculateScores() {
        List<Response> responseList = responseService.findAll();
        List<Answer> answerList = answerService.findAll();
        int score = 0;
        for(int i=0; i<responseList.size(); i++){
            if(responseList.get(i).getSelectedOption().equals(answerList.get(i).getAnswerData())){
                score++;
            }
        }
        return score;
    }

    public int studentIdFromResponse(){
        List<Response> responseList = responseService.findAll();
        return responseList.get(0).getStudentId();
    }

    public Result save(Result result) {
        return resultRepository.save(result);
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    public Result findResultByStudentId(int id) {
        return resultRepository.findByStudentId(id);
    }

    public void deleteResultById(int id){
        resultRepository.deleteById(id);
    }


}

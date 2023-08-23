package com.mylearning.quizapp.service;

import com.mylearning.quizapp.dao.ResponseRepository;
import com.mylearning.quizapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService{


    ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response save(Response response) {
        return responseRepository.save(response);
    }

    public List<Response> findAll() {
        return responseRepository.findAll();
    }

    public void deleteById(int id) {
        responseRepository.deleteById(id);
    }

    public Response findById(int id) {
        Optional<Response> responses = responseRepository.findById(id);
        Response tempResponse = null;
        if(responses.isPresent()){
            tempResponse = responses.get();
        }
        else{
            throw new RuntimeException("Did not find Response with id -" + id);
        }
        return tempResponse;
    }
}

package com.mylearning.quizapp.service;

import com.mylearning.quizapp.dao.UserRepository;
import com.mylearning.quizapp.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        Optional<User> result = userRepository.findById(id);
        User tempUser = null;
        if(result.isPresent()){
            tempUser = result.get();
        }
        else{
            throw new RuntimeException("Did not find user with id - " + id);
        }
        return tempUser;
    }

    public User save(User user) {
        User dbUser = userRepository.save(user);
        return dbUser;
    }


    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}

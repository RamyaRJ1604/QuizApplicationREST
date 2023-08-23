package com.mylearning.quizapp.rest;

import com.mylearning.quizapp.entity.Answer;
import com.mylearning.quizapp.entity.Question;
import com.mylearning.quizapp.entity.Response;
import com.mylearning.quizapp.entity.Result;
import com.mylearning.quizapp.entity.User;
import com.mylearning.quizapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizRestController {

    private QuestionsService questionsService;
    private AnswerService answerService;
    private ResponseService responseService;
    private ResultService resultService;

    private UserService userService;

    @Autowired
    public QuizRestController(QuestionsService questionsService, AnswerService answerService, ResponseService responseService, ResultService resultService, UserService userService) {
        this.answerService = answerService;
        this.questionsService = questionsService;
        this.responseService = responseService;
        this.resultService = resultService;
        this.userService = userService;
    }

    // ===================================== QUESTIONS =====================================

    @GetMapping("/questions")
    public List<Question> findAllQuestions() {
        return questionsService.findAll();
    }

    @GetMapping("/questions/{questionId}")
    public Question findQuestionById(@PathVariable int questionId) {
        Question theQuestion = questionsService.findById(questionId);
        if (theQuestion == null) {
            throw new QuestionNotFoundException("Question id not found: " + questionId);
        }
        return theQuestion;
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question theQuestion){
        theQuestion.setId(0);
        Question dbQuestion = questionsService.save(theQuestion);
        return dbQuestion;
    }

    @DeleteMapping("/questions/{questionId}")
    public String deleteQuestionById(@PathVariable int questionId){
        questionsService.deleteById(questionId);
        return "Question with id deleted - " + questionId;
    }

    @PutMapping("/questions")
    public Question updateQuestion(@RequestBody Question theQuestion){
        Question dbQuestion = questionsService.save(theQuestion);
        return dbQuestion;
    }

    // ===================================== ANSWERS =====================================

    @GetMapping("/answers")
    public List<Answer> findAllAnswers(){
        return answerService.findAll();
    }


    @GetMapping("/answers/{answerId}")
    public Answer findAnswerById(@PathVariable int answerId){
        return answerService.findById(answerId);
    }

    @PostMapping("/answers")
    public Answer addAnswer(@RequestBody Answer theAnswer){
        theAnswer.setAnswerId(0);
        Answer dbAnswer = answerService.save(theAnswer);
        return theAnswer;
    }

    @DeleteMapping("/answers/{answerId}")
    public String deleteAnswer(@PathVariable int answerId){
        answerService.deleteById(answerId);
        return "Answer with id deleted - " + answerId;
    }

    @PutMapping("/answers")
    public Answer updateAnswer(@RequestBody Answer theAnswer){
        Answer dbAnswer = answerService.save(theAnswer);
        return dbAnswer;
    }

    // ===================================== RESPONSES =====================================
    @GetMapping("/responses")
    public List<Response> findAllResponses(){
        return responseService.findAll();
    }

    @GetMapping("/responses/{responseId}")
    public Response findResponseById(@PathVariable int responseId){
        return responseService.findById(responseId);
    }

    @PostMapping("/responses")
    public Response addResponse(@RequestBody Response response){
        response.setResponseId(0);
        Response dbResponse = responseService.save(response);
        return dbResponse;
    }

    @PutMapping("/responses")
    public Response updateResponse(@RequestBody Response response){
        Response dbResponse = responseService.save(response);
        return dbResponse;
    }

    @DeleteMapping("/responses/{responseId}")
    public String deleteResponse(@PathVariable int responseId){
        responseService.deleteById(responseId);
        return "Response with id deleted - " + responseId;
    }

    // ===================================== RESULTS =====================================

    @GetMapping("/results")
    public List<Result> findAllResults(){
        return resultService.findAll();
    }

    @GetMapping("/results/{studentId}")
    public Result findByStudentId(@PathVariable int studentId){
        return resultService.findResultByStudentId(studentId);
    }

    @PostMapping("/results")
    public void postResults(){
        int calculatedScore = resultService.calculateScores();
        int studentId = resultService.studentIdFromResponse();
        Result result = new Result(studentId, calculatedScore);
        try {
            resultService.save(result);
        }
        catch (Exception e){
            throw new RuntimeException("Test already taken by Student with id - " + studentId);
        }
    }
    @PutMapping("/results")
    public Result updateResult(Result result){
        Result dbResult = resultService.save(result);
        return dbResult;
    }

    @DeleteMapping("/results/{resultId}")
    public String deleteResult(@PathVariable int id){
        resultService.deleteResultById(id);
        return "Deleted result with id - " + id;
    }

    // ===================================== USERS =====================================

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }
    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable int userId){
        System.out.println(userService.findAll());
        return userService.findById(userId);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        user.setUserId(0);
        User dbUser = userService.save(user);
        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        User dbUser = userService.save(user);
        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUserById(@PathVariable int userId){
        userService.deleteById(userId);
        return "Deleted user with id - " + userId;
    }

}

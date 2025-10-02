package com.harsh.quizapp.controller;

import com.harsh.quizapp.model.Question;
import com.harsh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

}

package com.harsh.quizapp.controller;

import com.harsh.quizapp.model.Question;
import com.harsh.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

        @DeleteMapping("delete/{id}")
        public String deleteQuestionById(@PathVariable Integer id) {
            questionService.deleteQuestion(id);
            return "Question deleted successfully";
        }

        @PutMapping("update/{id}")
        public String updateQuestion(@PathVariable Integer id, @RequestBody Question updatedQuestion) {
            updatedQuestion.setId(id);
            questionService.addQuestion(updatedQuestion);
            return "Question updated successfully";
        }

}

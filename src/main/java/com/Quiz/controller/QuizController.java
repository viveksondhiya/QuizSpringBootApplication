package com.Quiz.controller;

import com.Quiz.entities.Quiz;
import com.Quiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    public QuizService quizService;

    //For creating a new quiz
    @PostMapping("/createQuiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        try {
            Quiz createdQuiz = quizService.createQuiz(quiz);
            quizService.scheduleQuizResultRetrieval(createdQuiz);  // Schedule quiz result retrieval
            return ResponseEntity.status(HttpStatus.CREATED).body(createdQuiz);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //for checking the active quiz
    @GetMapping("/active")
    public ResponseEntity<Quiz> getActiveQuiz() {
        try {
            Quiz activeQuiz = quizService.getActiveQuiz();
            if (activeQuiz != null) {
                return ResponseEntity.ok(activeQuiz);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //Get ans of the quiz by id
    @GetMapping("/{id}/result")
    public ResponseEntity<String> getQuizResult(@PathVariable("id") Long id) {
        try {
            Quiz quiz = quizService.getQuizById(id);
            if (quiz != null) {
                if (quiz.getStatus().equals("finished")) {
                    int rightAnswer = quiz.getRightAnswer();
                    String result = "The right answer is option " + (rightAnswer);
                    return ResponseEntity.ok(result);
                }
                return ResponseEntity.badRequest().body("Quiz result not available yet");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //get all quiz
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        try {
            List<Quiz> quizzes = quizService.getAllQuizzes();
            return ResponseEntity.ok(quizzes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

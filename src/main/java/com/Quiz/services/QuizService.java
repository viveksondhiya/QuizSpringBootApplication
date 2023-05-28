package com.Quiz.services;

import com.Quiz.dao.QuizRepository;
import com.Quiz.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class QuizService {
    @Autowired
    public QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (currentDateTime.isBefore(quiz.getStartDate())) {
            quiz.setStatus("inactive");
        } else if (currentDateTime.isAfter(quiz.getEndDate())) {
            quiz.setStatus("finished");
        } else {
            quiz.setStatus("active");
        }

        return quizRepository.save(quiz);
    }
    public Quiz getActiveQuiz() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Quiz> activeQuizzes = quizRepository.findByStartDateBeforeAndEndDateAfter(currentDateTime, currentDateTime);
        if (!activeQuizzes.isEmpty()) {
            Quiz activeQuiz = activeQuizzes.get(0);
            // Update the status if necessary
            if (currentDateTime.isBefore(activeQuiz.getStartDate())) {
                activeQuiz.setStatus("inactive");
            } else if (currentDateTime.isAfter(activeQuiz.getEndDate())) {
                activeQuiz.setStatus("finished");
            } else {
                activeQuiz.setStatus("active");
            }

            return quizRepository.save(activeQuiz); // Update the quiz status in the database
        }
        return null;
    }
    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    public void scheduleQuizResultRetrieval(Quiz quiz) {
        LocalDateTime endTime = quiz.getEndDate().plusMinutes(5);
        Duration delay = Duration.between(LocalDateTime.now(), endTime);

        if (delay.isNegative()) {
            // The specified quiz has already passed the retrieval time
            return;
        }

        TimerTask retrieveQuizResultTask = new TimerTask() {
            @Override
            public void run() {
                // Retrieve the quiz result
                int rightAnswer = quiz.getRightAnswer();
                String result = "The right answer is option " + (rightAnswer);
                System.out.println(result);
            }
        };

        Timer timer = new Timer();
        timer.schedule(retrieveQuizResultTask, delay.toMillis());
    }

}

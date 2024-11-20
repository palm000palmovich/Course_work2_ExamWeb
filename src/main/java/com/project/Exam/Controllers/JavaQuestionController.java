package com.project.Exam.Controllers;

import com.project.Exam.Questions;
import com.project.Exam.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping(path = "/add")
    public String addQues(@RequestParam("question") String question,
                          @RequestParam("answer") String answer){
        return questionsService.addQuestion(question, answer);
    }

    @GetMapping(path = "/remove")
    public String removeQue(@RequestParam("question") String question,
                            @RequestParam("answer") String answer){
        return questionsService.removeQuestion(question, answer);
    }


    @GetMapping
    public List<Questions> allQuestions(){return questionsService.getAllQuestions();}
}

package com.project.Exam.Controllers;

import com.project.Exam.Services.QuestionService;
import com.project.Exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @Autowired
    private QuestionService questionService;

    //Вывод всех вопросов
    @GetMapping
    public List<Question> getAll(){
        return questionService.getAllQuestions();
    }

    //Добавление
    @GetMapping(path = "/add")
    public String addQues(@RequestParam("question") String question,
                          @RequestParam("answer") String answer){
        return questionService.addQuestion(question, answer);
    }

    //Удаление
    @GetMapping(path = "/remove")
    public String removeQue(@RequestParam("question") String question,
                            @RequestParam("answer") String answer){

        return questionService.removeQuestion(question, answer);
    }
}

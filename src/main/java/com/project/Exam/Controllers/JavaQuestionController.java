package com.project.Exam.Controllers;

import com.project.Exam.Questions;
import com.project.Exam.Services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @Autowired
    private QuestionsService queSer;

    //Добавление
    @PostMapping(path = "/add")
    public String addQues(@RequestBody Questions question){
        return queSer.addQuestion(question);
    }

    //Удаление
    @PostMapping(path = "/remove")
    public String removeQue(@RequestBody Questions question){
        return queSer.removeQuestion(question);
    }


    //Вывод всех вопросов
    @GetMapping
    public List<Questions> getAll(){
        return queSer.getAllQuestions();
    }

}

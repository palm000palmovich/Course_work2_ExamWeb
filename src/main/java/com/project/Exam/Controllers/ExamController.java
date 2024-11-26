package com.project.Exam.Controllers;

import com.project.Exam.Services.ExaminerService;
import com.project.Exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;
@RestController
@RequestMapping(path = "/exam/get")
public class ExamController {
    @Autowired
    ExaminerService examinerService;

    //Вывод рандомного списка вопросов
    @GetMapping(path = "/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount){
        return examinerService.getRandomQuestion(amount);
    }
}

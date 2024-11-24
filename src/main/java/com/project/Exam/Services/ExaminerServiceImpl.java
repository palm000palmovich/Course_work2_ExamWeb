package com.project.Exam.Services;

import com.project.Exam.Exceptions.BadRequestException;
import com.project.Exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    QuestionService questionService;
    Set<Question> setOfRandomQuestions;


    //Возврат рандомных вопросов
    @Override
    public Collection<Question> getRandomQuestion(int amount){
        List<Question> listOfQues = questionService.getAllQuestions(); //Мок для getAllQuestions()
        if (setOfRandomQuestions == null){
            setOfRandomQuestions = new HashSet<>();
        }

        if (amount <= listOfQues.size()){
            setOfRandomQuestions.clear();
            while (setOfRandomQuestions.size() < amount){
                setOfRandomQuestions.add(questionService.getRandom());} //Здесь мок
            return setOfRandomQuestions;
        }
        throw new BadRequestException("Указанное число больше длины списка!");
    }

}

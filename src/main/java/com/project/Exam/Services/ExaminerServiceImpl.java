package com.project.Exam.Services;

import com.project.Exam.Exceptions.BadRequestException;
import com.project.Exam.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    QuestionsService queSer;  //Здесь мок
    Set<Questions> setOfRandomQuestions;


    //Возврат рандомных вопросов
    @Override
    public Set<Questions> getRandomQuestion(int amount){
        List<Questions> listOfQues = queSer.getAllQuestions(); //Мок для getAllQuestions()
        if (setOfRandomQuestions == null){
            setOfRandomQuestions = new HashSet<>();
        }

        if (amount <= listOfQues.size()){
            setOfRandomQuestions.clear();
            while (setOfRandomQuestions.size() < amount){
                setOfRandomQuestions.add(queSer.getRandom());}
            return setOfRandomQuestions;
        }
        throw new BadRequestException("Указанное число больше длины списка!");
    }

}

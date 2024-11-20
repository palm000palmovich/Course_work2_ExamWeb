package com.project.Exam.Services;

import com.project.Exam.Questions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class JavaQuestionsService implements QuestionsService {
    List<Questions> javaQuestionsList = new ArrayList<>();

    //Добавить вопрос
    @Override
    public String addQuestion(String question, String answer){
        Questions question1 = new Questions(question, answer);

        if (javaQuestionsList == null){
            javaQuestionsList = new ArrayList<>();
        }

        for (int i = 0; i < javaQuestionsList.size(); i++) {
            if (javaQuestionsList.get(i).getQuestion().equals(question)
            && javaQuestionsList.get(i).getAnswer().equals(answer)){
                return "Этот вопрос уже есть в списке!";
            }
        }
        javaQuestionsList.add(question1);
        return "Вопрос успешно добавлен!";
    }

    @Override
    public String addQuestion(Questions question){
        for (int i = 0; i < javaQuestionsList.size(); i++){
            if (javaQuestionsList.get(i).)
        }
    }

    //Удаление вопроса
    @Override
    public String removeQuestion(String question, String answer){

        for (int i = 0; i < javaQuestionsList.size(); i++) {
            if (javaQuestionsList.get(i).getQuestion().equals(question)
                    && javaQuestionsList.get(i).getAnswer().equals(answer)){
                Questions question1 = javaQuestionsList.get(i);
                javaQuestionsList.remove(question1);
                return "Вопрос успешно удален!";
            }
        }
        return "Такого вопроса в списке нет! Добавим?";
    }

    //Получить все вопросы
    @Override
    public List<Questions> getAllQuestions(){
        return new ArrayList<>(javaQuestionsList);
    }
}

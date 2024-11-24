package com.project.Exam.Services;

import com.project.Exam.Exceptions.CollectionIsEmptyException;
import com.project.Exam.Questions;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service

public class JavaQuestionsService implements QuestionsService {
    List<Questions> javaQuestionsList = new ArrayList<>();

    //Добавить вопрос
    @Override
    public String addQuestion(Questions question){
        for (int i = 0; i < javaQuestionsList.size(); i++){
            if (javaQuestionsList.get(i).getQuestion().equals(question.getQuestion())
            && javaQuestionsList.get(i).getAnswer().equals(question.getAnswer())){
                return "Этот вопрос уже есть в списке!";
            }
        }
        javaQuestionsList.add(question);
        return "Вопрос успешно добавлен!";
    }

    //Получить все вопросы
    @Override
    public List<Questions> getAllQuestions(){

        return new ArrayList<>(javaQuestionsList);
    }

    //Удаление вопроса
    @Override
    public String removeQuestion(Questions quest){

        for (int i = 0; i < javaQuestionsList.size(); i++) {
            if (javaQuestionsList.get(i).getQuestion().equals(quest.getQuestion())
                    && javaQuestionsList.get(i).getAnswer().equals(quest.getAnswer())){
                quest = javaQuestionsList.get(i);
                javaQuestionsList.remove(quest);
                return "Вопрос успешно удален!";
            }
        }
        return "Такого вопроса в списке нет! Добавим?";
    }


    //Рандомный вопрос из списка
    @Override
    public Questions getRandom(){
        if (javaQuestionsList.size() != 0){
            int randomIndex = (int) (Math.random() * (javaQuestionsList.size()));
            return javaQuestionsList.get(randomIndex);
        }
        throw new CollectionIsEmptyException("Список вопросов пуст!");
    }

}

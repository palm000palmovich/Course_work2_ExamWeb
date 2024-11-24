package com.project.Exam.Services;

import com.project.Exam.Exceptions.CollectionIsEmptyException;
import com.project.Exam.model.Question;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service

public class JavaQuestionService implements QuestionService {
    List<Question> javaQuestionsList = new ArrayList<>();

    //Добавить вопрос
    @Override
    public String addQuestion(String question1, String answer1){
        Question question = new Question(question1, answer1);
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
    public List<Question> getAllQuestions(){

        return new ArrayList<>(javaQuestionsList);
    }

    //Удаление вопроса
    @Override
    public String removeQuestion(String question1, String answer1){
        Question quest = new Question(question1, answer1);
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
    public Question getRandom(){
        List<Question> list = getAllQuestions();
        if (list.size() == 0){
            throw new CollectionIsEmptyException("Список вопросов пуст!");
        }
        int randomIndex = (int) (Math.random() * (list.size()));
        return javaQuestionsList.get(randomIndex);
    }

    ////////DANGER///////DANGER/////DANGER////DANGER///////DANGER/////DANGER////DANGER///////DANGER/////DANGER////DANGER
    //Очищение всего списка вопросов(Только если судно прям реально идет ко дну)
    public void clearQuestionList(){
        javaQuestionsList.clear();
    }
    ////////DANGER///////DANGER/////DANGER////DANGER///////DANGER/////DANGER////DANGER///////DANGER/////DANGER////DANGER
}

package com.project.Exam.Services;

import com.project.Exam.model.Question;

import java.util.List;

public interface QuestionService {
    //Добавить вопрос
    String addQuestion(String question1, String answer1);

    //Получить все вопросы
    List<Question> getAllQuestions();

    //Удаление вопроса
    String removeQuestion(String question1, String answer1);

    //Рандомный вопрос из списка
    Question getRandom();
}

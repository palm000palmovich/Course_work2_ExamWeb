package com.project.Exam.Services;

import com.project.Exam.Questions;

import java.util.List;

public interface QuestionsService {
    //Добавить вопрос
    String addQuestion(Questions question);

    //Удаление вопроса
    String removeQuestion(Questions quest);

    //Получить все вопросы
    List<Questions> getAllQuestions();
    //Рандомный вопрос из списка
    Questions getRandom();
}

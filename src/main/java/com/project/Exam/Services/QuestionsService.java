package com.project.Exam.Services;

import com.project.Exam.Questions;

import java.util.List;

public interface QuestionsService {
    //Добавить вопрос
    String addQuestion(String question, String answer);

    //Удаление вопроса
    String removeQuestion(String question, String answer);

    //Получить все вопросы
    List<Questions> getAllQuestions();
}

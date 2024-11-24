package com.project.Exam.Services;

import com.project.Exam.model.Question;

import java.util.Collection;

public interface ExaminerService {
    //Возврат рандомных вопросов
    Collection<Question> getRandomQuestion(int amount);
}

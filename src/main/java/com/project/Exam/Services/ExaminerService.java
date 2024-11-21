package com.project.Exam.Services;

import com.project.Exam.Questions;

import java.util.Set;

public interface ExaminerService {
    //Возврат рандомных вопросов
    Set<Questions> getRandomQuestion(int amount);
}

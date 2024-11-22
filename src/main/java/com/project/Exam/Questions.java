package com.project.Exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Questions {
    private String question;
    private String answer;
    public Questions(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    //Геттер и сеттеры

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @SpringBootApplication
    public static class ExamApplication {

        public static void main(String[] args) {
            SpringApplication.run(ExamApplication.class, args);
        }

    }
}

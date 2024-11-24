import com.project.Exam.Questions;
import com.project.Exam.Services.JavaQuestionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private JavaQuestionsService javaQues;
    private Questions question1;
    private Questions question2;

    @BeforeEach
    public void setUp(){
        this.javaQues = new JavaQuestionsService();
        this.question1 = new Questions("Ты кто?", "Я-МЫ");
        this.question2 = new Questions("А кто мы?", "Сам хз, так в сценарии написано...");

        javaQues.addQuestion(question1);
        javaQues.addQuestion(question2);
    }

    @Test
    public void getAllQuestions(){
        List<Questions> expected = javaQues.getAllQuestions();

        List<Questions> actual = new ArrayList<>();
        actual.add(question1);
        actual.add(question2);

        assertEquals(expected, actual);
    }

    @Test
    public void getAllQuestionsIsNotNull(){
        List<Questions> expected = javaQues.getAllQuestions();
        assertNotNull(expected);
    }

    @Test
    public void getRandomTest(){
        Questions queToCheck = javaQues.getRandom();

        Boolean flag = javaQues.getAllQuestions().contains(queToCheck);

        assertNotNull(queToCheck);
        assertTrue(flag);
    }

    @Test
    public void removeQuestionTest(){
        List<Questions> actual = new ArrayList<>();
        actual.add(question1);

        javaQues.removeQuestion(question2);
        List<Questions> expected = javaQues.getAllQuestions();


        assertEquals(actual,expected);
    }

}

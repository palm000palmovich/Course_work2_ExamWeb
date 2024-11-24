
import com.project.Exam.Exceptions.CollectionIsEmptyException;
import com.project.Exam.Services.JavaQuestionService;
import com.project.Exam.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {
    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String question3;
    private String answer3;

    private JavaQuestionService javaQues;

    @BeforeEach
    public void setUp(){
        this.javaQues = new JavaQuestionService();
        question1 = "Ты кто?"; answer1 = "Я-МЫ";
        question2 = "А кто мы?"; answer2 = "Сам хз, так в сценарии написано...";
        question3 = "Ну и что же мы сейчас делаем вообще?"; answer3 = "Пишем тесты для нашего сервиса...";

        javaQues.addQuestion(question1, answer1);
        javaQues.addQuestion(question2, answer2);
    }

    @Test
    public void getAllQuestions(){
        List<Question> expected = javaQues.getAllQuestions();

        List<Question> actual = new ArrayList<>();
        actual.add(new Question(question1, answer1));
        actual.add(new Question(question2, answer2));

        assertEquals(expected.get(0).getQuestion(), actual.get(0).getQuestion());
        assertEquals(expected.get(0).getAnswer(), actual.get(0).getAnswer());

        assertEquals(expected.get(1).getQuestion(), actual.get(1).getQuestion());
        assertEquals(expected.get(1).getAnswer(), actual.get(1).getAnswer());
    }

    @Test
    public void getAllQuestionsIsNotNull(){
        List<Question> expected = javaQues.getAllQuestions();
        assertNotNull(expected);
    }

    @Test
    public void getRandomTest(){
        Question queToCheck = javaQues.getRandom();

        Boolean flag = javaQues.getAllQuestions().contains(queToCheck);

        assertNotNull(queToCheck);
        assertTrue(flag);
    }

    @Test()
    public void getRandomThrowsExceptionTest(){

        javaQues.clearQuestionList();

        CollectionIsEmptyException thrown = assertThrows(CollectionIsEmptyException.class,
                () -> javaQues.getRandom());

    }


    @Test
    public void removeQuestionTest(){
        javaQues.removeQuestion(question2, answer2);
        List<Question> expected = javaQues.getAllQuestions();

        List<Question> actual = new ArrayList<>();
        actual.add(new Question(question1, answer1));


        assertEquals(actual.get(0).getQuestion(),expected.get(0).getQuestion());
        assertEquals(actual.get(0).getAnswer(),expected.get(0).getAnswer());
    }

    @Test
    public void addQuestionTest(){
        javaQues.addQuestion(question3, answer3);
        List<Question> expected = javaQues.getAllQuestions();

        List<Question> actual = new ArrayList<>();
        actual.add(new Question(question1, answer1));
        actual.add(new Question(question2, answer2));
        actual.add(new Question(question3, answer3));

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getQuestion(),expected.get(i).getQuestion());
        }
    }

}

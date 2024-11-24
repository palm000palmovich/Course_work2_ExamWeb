
import com.project.Exam.Exceptions.BadRequestException;
import com.project.Exam.Exceptions.CollectionIsEmptyException;
import com.project.Exam.Services.ExaminerServiceImpl;
import com.project.Exam.Services.JavaQuestionService;
import com.project.Exam.Services.QuestionService;
import com.project.Exam.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Mock
    QuestionService questionService;

    private String question1;
    private String answer1;
    private String question2;
    private String answer2;
    private String question3;
    private String answer3;


    @BeforeEach
    public void setUp(){
        question1 = "Ты кто?"; answer1 = "Я-МЫ";
        question2 = "А кто мы?"; answer2 = "Сам хз, так в сценарии написано...";
        question3 = "Ну и что же мы сейчас делаем вообще?"; answer3 = "Пишем тесты для нашего сервиса...";

    }
    @Test
    public void getRandomQuestionTest(){
        List<Question> list = new ArrayList<>();
        list.add(new Question(question1, answer1));
        list.add(new Question(question2, answer2));

        Mockito.when(questionService.getRandom()).thenReturn(new Question(question1, answer1),
                                                             new Question(question2, answer2));
        Mockito.when(questionService.getAllQuestions()).thenReturn(list);


        Collection<Question> expected = examinerService.getRandomQuestion(2);
        Collection<Question> actual = new HashSet<>();
        actual.add(new Question(question1, answer1));
        actual.add(new Question(question2, answer2));


        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void badRequestExceptionTest(){

        BadRequestException thrown = assertThrows(BadRequestException.class,
                () -> examinerService.getRandomQuestion(3));
    }

}

import com.project.Exam.Questions;
import com.project.Exam.Services.ExaminerServiceImpl;
import com.project.Exam.Services.JavaQuestionsService;
import com.project.Exam.Services.QuestionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Mock
    QuestionsService queSer;

    private Questions question1;
    private Questions question2;
    private Questions question3;

    @BeforeEach
    public void setUp(){
        this.question1 = new Questions("Давай я назову тебя Андрей?", "Сомневаюсь, что это вопрос по джаве...");
        this.question2 = new Questions("Как понять, что в головах у святых?", "Это сложно, я просто делаю свой пых-пых.");
        this.question3 = new Questions("Давай я буду слон, а ты  посудная лавочка?", "Давай я лучше буду Андреем...");

        queSer.addQuestion(question1);
        queSer.addQuestion(question2);
        queSer.addQuestion(question3);
    }
    @Test
    public void getRandomQuestionTest(){
        List<Questions> list = new ArrayList<>();
        list.add(question1);
        list.add(question2);
        list.add(question3);

        Mockito.when(queSer.getRandom()).thenReturn(question1,question2);
        Mockito.when(queSer.getAllQuestions()).thenReturn(list);


        Set<Questions> expected = examinerService.getRandomQuestion(2);
        Set<Questions> actual = new HashSet<>();
        actual.add(question1);
        actual.add(question2);

        assertEquals(expected, actual);
    }
}

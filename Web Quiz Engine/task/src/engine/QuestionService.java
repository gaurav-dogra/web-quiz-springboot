package engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class QuestionService {
    private final Map<Integer, Question> questions = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public Response[] getAll() {
        return questions.keySet()
                .stream()
                .map(x -> new Response(x, questions.get(x)))
                .toArray(Response[]::new);

    }

    public ResponseEntity<Response> getById(int id) {
        Question question = questions.get(id);
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response(id, question), HttpStatus.OK);
    }

    public ResponseEntity<Answer> checkAnswer(int id, int[] answer) {
        Question question = questions.get(id);

        if (question == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        int[] savedAnswers = question.getAnswers();

        System.out.println("answer = " + Arrays.toString(answer));
        System.out.println("savedAnswers = " + Arrays.toString(savedAnswers));
        if (savedAnswers == null) {
            savedAnswers = new int[0];
        }

        if (answer == null) {
            answer = new int[0];
        }

        Arrays.sort(savedAnswers);
        Arrays.sort(answer);
        if (Arrays.equals(answer, savedAnswers)) {
            return new ResponseEntity<>(Answer.CORRECT_ANSWER, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Answer.WRONG_ANSWER, HttpStatus.OK);
        }

    }

    public Response add(Question question) {
        int id = idGenerator.getAndIncrement();
        questions.put(id, question);
        return new Response(id, question);
    }
}

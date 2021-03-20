package engine;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class QuizController {

    private final Map<Integer, Question> questions = new HashMap<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    @GetMapping("/api/quizzes")
    public Response[] getAll() {
        return questions.keySet()
                .stream()
                .map(x -> new Response(x, questions.get(x)))
                .toArray(Response[]::new);
    }

    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<Response> getById(@PathVariable int id) {
        Question question = questions.get(id);
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Response(id, question), HttpStatus.OK);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ResponseEntity<Answer> checkAnswer(@PathVariable int id, @RequestParam int answer) {
        System.out.println("id = " + id);
        System.out.println("answer = " + answer);
        Question question = questions.get(id);
        System.out.println("question = " + question);
        if (question == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (question.isCorrect(answer)) {
            return new ResponseEntity<>(Answer.CORRECT_ANSWER, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Answer.WRONG_ANSWER, HttpStatus.OK);
        }
    }

    @PostMapping(path = "api/quizzes")
    public Response addQuestion(@RequestBody Question question) {
        System.out.println(question);
        int id = idGenerator.getAndIncrement();
        questions.put(id, question);
        return new Response(id, question);
    }
}
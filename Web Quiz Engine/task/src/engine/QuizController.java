package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@Validated
public class QuizController {
    private final QuestionService questionService;

    @Autowired
    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/quizzes")
    public Response[] getAll() {
        return questionService.getAll();
    }

    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<Response> getById(@PathVariable int id) {
        return questionService.getById(id);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public ResponseEntity<Answer> checkAnswer(@PathVariable int id, @RequestBody InputAnswer answer) {
        return questionService.checkAnswer(id, answer.getAnswer());
    }

    @PostMapping(path = "api/quizzes")
    public Response addQuestion(@Valid @RequestBody Question question) {
        return questionService.add(question);
    }
}
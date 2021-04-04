package engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuizController {

    private final QuestionService qService;

    @Autowired
    public QuizController(QuestionService qService) {
        this.qService = qService;
    }

    @GetMapping("/api/quizzes")
    public List<QuestionWithoutAnswer> getAll() {
        System.out.println("QuizController.getAll");
        return qService.getAll();
    }

    @GetMapping("/api/quizzes/{id}")
    public QuestionWithoutAnswer getById(@PathVariable long id) {
        System.out.println("QuizController.getById");
        return qService.getById(id);
    }

    @PostMapping("/api/quizzes/{id}/solve")
    public Answer checkAnswer(@PathVariable long id, @RequestBody Map.Entry<String, List<Integer>> answer) {
        System.out.println("QuizController.checkAnswer");
        return qService.checkAnswer(id, answer.getValue());
    }

    @PostMapping(path = "api/quizzes")
    public QuestionWithoutAnswer addQuestion(@RequestBody Question question) {
        System.out.println("QuizController.addQuestion");
        return qService.add(question);
    }
}
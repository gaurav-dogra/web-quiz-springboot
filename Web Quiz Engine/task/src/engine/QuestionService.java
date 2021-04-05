package engine;

import engine.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository qRepository;

    @Autowired
    public QuestionService(QuestionRepository qRepository) {
        this.qRepository = qRepository;
    }

    public List<QuestionWithoutAnswer> getAll() {
        List<Question> dbCopies = qRepository.findAll();
        List<QuestionWithoutAnswer> returnList = new ArrayList<>();
        for (Question q : dbCopies) {
            System.out.println("-----------------------------------------");
            System.out.println(q);
            returnList.add(new QuestionWithoutAnswer(q));
        }
        return returnList;
    }

    public QuestionWithoutAnswer getById(Long id) {
        Question dbCopy = getFromDb(id);
        return new QuestionWithoutAnswer(dbCopy);
    }

    private Question getFromDb(Long id) {
        return qRepository.findById(id)
                .orElseThrow(new NotFoundException());
    }

    public Answer checkAnswer(Long id, List<Integer> answers) {
        Question dbCopy = getFromDb(id);
        List<Integer> dbAnswers = dbCopy.getAnswer();
        if (dbAnswers == null) {
            dbAnswers = Collections.emptyList();
        }
        if (answers == null) {
            answers = Collections.emptyList();
        }
        HashSet<Integer> dbAnswersSet = new HashSet<>(dbAnswers);
        HashSet<Integer> answersSet = new HashSet<>(answers);

        if (answersSet.equals(dbAnswersSet)) {
            return Answer.CORRECT_ANSWER;
        } else {
            return Answer.WRONG_ANSWER;
        }
    }

    public QuestionWithoutAnswer add(Question question) {
        System.out.println("=====================================");
        System.out.println(question);
        Question dbCopy = qRepository.saveAndFlush(question);
        return new QuestionWithoutAnswer(dbCopy);
    }

    public void deleteQuestion(long id) {
        qRepository.findById(id)
                .orElseThrow(new NotFoundException());
        qRepository.deleteById(id);
    }
}

package engine;

import java.util.Collections;
import java.util.List;

public class QuestionWithoutAnswer {
    private Long id;
    private String title;
    private String text;
    private List<String> options;

    public QuestionWithoutAnswer(Long id, String title, String text, List<String> options) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public QuestionWithoutAnswer() {
    }

    public QuestionWithoutAnswer(Question q) {
        this.id = q.getId();
        this.title = q.getTitle();
        this.text = q.getText();
        if (q.getOptions() == null) {
            this.options = Collections.emptyList();
        } else {
            this.options = q.getOptions();
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }
}

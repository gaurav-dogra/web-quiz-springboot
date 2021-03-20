package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private String title;
    private String text;
    private String[] options;
    private int answer;

    public Question(String title, String text, String[] options, int answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

    public Question() {}

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options.clone();
    }

    @JsonIgnore
    public int getAnswer(int option) {
        return answer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    @JsonProperty
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public boolean isCorrect(int answer) {
        return this.answer == answer;
    }

    @Override
    public String toString() {
        return title + ": " + answer;
    }
}
package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Validated
public class Question {
    @NotEmpty(message = "title can not be empty")
    private String title;
    @NotEmpty(message = "text can not be empty")
    private String text;
    @NotNull(message = "Options must not be null")
    @Size(min = 2, message = "Options can not be less than two")
    private String[] options;
    private int[] answer;

    public Question(@NotEmpty(message = "title can not be empty") String title,
                    @NotEmpty(message = "text can not be empty") String text,
                    @NotNull(message = "Options must not be null")
                    @Size(min = 2, message = "Options can not be less than two")
                            String[] options,
                    int[] answer) {
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
        return options;
    }

    @JsonIgnore
    public int[] getAnswers() {
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
    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

//    public boolean isCorrect(int answer) {
//        return this.answer == answer;
//    }


    @Override
    public String toString() {
        return title + ": " + text + ": " +
                Arrays.toString(options) +
                ": " + Arrays.toString(answer);
    }
}
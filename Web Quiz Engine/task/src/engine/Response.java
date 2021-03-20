package engine;

public class Response {
    private int id;
    private String title;
    private String text;
    private String[] options;

    public Response(int id, Question question) {
        this.id = id;
        this.title = question.getTitle();
        this.text = question.getText();
        this.options = question.getOptions();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}

package engine;

public class Answer {
    public static final Answer CORRECT_ANSWER =
            new Answer(true, "Congratulations, you're right!");
    public static final Answer WRONG_ANSWER =
            new Answer(false, "Wrong answer! Please, try again.");

    private final boolean success;
    private final String feedback;

    public Answer(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFeedback() {
        return feedback;
    }
}
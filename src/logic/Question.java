package logic;

public interface Question {
    String getQuestion();
    String[] getAnswers();
    boolean isCorrect(int i);
}

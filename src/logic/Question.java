package logic;

public interface Question {
    String getQuestion();
    String[] getAnswers();
    boolean isAnswerCorrect(int i);
}

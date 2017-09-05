package data;

import logic.Question;

public class DummyQuestion implements Question {
    @Override
    public String getQuestion() {
        return "This is a dummy question";
    }

    @Override
    public String[] getAnswers() {
        return new String[]{"option 0", "option 1", "option 2", "option 3"};
    }

    @Override
    public boolean isAnswerCorrect(int i) {
        return true;
    }
}

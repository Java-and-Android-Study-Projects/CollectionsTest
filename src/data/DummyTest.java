package data;

import logic.Question;
import logic.Questionnaire;

public class DummyTest implements Questionnaire {
    @Override
    public Question[] getQuestions() {
        Question[] questions = new Question[10];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new DummyQuestion();
        }

        return questions;
    }
}

package data;

import logic.Question;
import logic.Questionnaire;

public class DummyTest extends Questionnaire {
    @Override
    public Question[] getQuestions() {
        Question[] questions = new Question[10];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new DummyQuestion();
        }

        return questions;
    }
}

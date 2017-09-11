package data.Lists;

import logic.Question;
import logic.Questionnaire;

public class QuestionBuilder implements Questionnaire {
    @Override
    public Question[] getQuestions() {
        QuestionsAnswers question = new QuestionsAnswers();
        Question[] questions = new Question[10];
        for (int i = 0; i < questions.length; i++) {
            questions[i] = new QuestionList(i);
        }
        return questions;
    }
}

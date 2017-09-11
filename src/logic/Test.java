package logic;

import data.DummyTest;
import data.Lists.QuestionBuilder;
import gui.TestWindow;

public class Test implements AnswerListener{
    public static final String[] TEST_NAMES = {"Maps", "Sets", "Lists"};

    private int score, maxPossibleScore;
    private Question[] questions;
    private boolean isInTest;
    private int index;
    private TestWindow testWindow;


    public static void main(String[] args) {
        Test test = new Test();
        test.testWindow = new TestWindow(test, TEST_NAMES);

    }

    @Override
    public void reactOnAnswer(int answerIndex) {
        System.out.println(answerIndex);
        if (!isInTest) {
            //if we are not in the test yet
            switch (answerIndex) {
                //choose what test to run
                // TODO: 9/5/17 add real tests
                case 0:
                    questions = (new DummyTest()).getQuestions();
                    break;
                case 1:
                    questions = (new DummyTest()).getQuestions();
                    break;
                case 2:
                    questions = (new QuestionBuilder()).getQuestions();
                    break;
                default:
                    showNextQuestion();
            }
            maxPossibleScore = questions.length;
            showNextQuestion();

            isInTest = true;
        } else {
            if (questions[index].isAnswerCorrect(answerIndex))
                score++;

            index++;
            showNextQuestion();
        }

    }

    private void showNextQuestion() {
        if (index < questions.length) {
            testWindow.showNextQuestion(questions, index);
        } else {
            testWindow.showResult(score, maxPossibleScore);
        }
    }

}

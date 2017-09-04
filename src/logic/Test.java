package logic;

import data.DummyTest;
import gui.ChooseTestWindow;
import gui.TestWindow;

public class Test implements AnswerListener{
    public static final String[] TEST_NAMES = {"Maps", "Sets", "Lists"};

    private int score, maxPossibleScore;
    private Question[] questions;
    private boolean isInTest;
    private int index;


    public static void main(String[] args) {
        Test test = new Test();
        ChooseTestWindow chooseTestWindow = new ChooseTestWindow(test, TEST_NAMES);

    }

    @Override
    public void reactOnAnswer(int answerIndex) {
        System.out.println(answerIndex);
        if (!isInTest) {
            switch (answerIndex) {
                case 0:
                    questions = (new DummyTest()).getQuestions();
                    break;
            }
            showNextQuestion();

            isInTest = true;
        } else {
            index++;
            showNextQuestion();
        }

    }

    private void showNextQuestion() {
        if (index < questions.length) {
            new TestWindow(this, questions[index]);
        } else {
            System.out.println("finish");
        }
    }

}
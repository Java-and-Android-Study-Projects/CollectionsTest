package gui;

import logic.AnswerListener;
import logic.Question;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {
    private AnswerListener answerListener;
    private JPanel mainPanel;

    public TestWindow(AnswerListener answerListener, String[] testNames) {
        this.answerListener = answerListener;

        setTitle ( "Choose Test" );
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setBounds ( 300 ,     300 ,     400 ,     400 );

        mainPanel = new JPanel(new GridLayout(0, 1));
        ButtonBuilder.addButtons(mainPanel, testNames, answerListener);

        add(mainPanel, BorderLayout.CENTER);
        setVisible (true);
    }

    public void showNextQuestion(Question[] questions, int index) {
        mainPanel.removeAll();

        setTitle ( "Question #" + (index + 1) + " out of " + questions.length);
        mainPanel.setLayout(new BorderLayout());

        JTextArea questionTextArea = new JTextArea(questions[index].getQuestion());
        questionTextArea.setEditable(false);

        JPanel answersPanel = new JPanel(new GridLayout(0, 1));
        ButtonBuilder.addButtons(answersPanel, questions[index].getAnswers(), answerListener);

        mainPanel.add(questionTextArea, BorderLayout.CENTER);
        mainPanel.add(answersPanel, BorderLayout.SOUTH);

        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showResult(int score, int maxPossibleScore) {
        mainPanel.removeAll();
        setTitle("Result");

        JTextArea resultTextArea = new JTextArea("Your score is " + score + " out of " + maxPossibleScore);
        resultTextArea.setEditable(false);

        mainPanel.add(resultTextArea, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}

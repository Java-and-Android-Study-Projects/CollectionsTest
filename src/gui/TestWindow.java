package gui;

import logic.AnswerListener;
import logic.Question;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {
    private AnswerListener answerListener;
    private JPanel mainPanel;

    private JTextField timerTextField;
    private Thread timerThread;
    private Timer timer;

    public TestWindow(AnswerListener answerListener, String[] testNames) {
        timer = new Timer(this);
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

        //frame
        setTitle ( "Question #" + (index + 1) + " out of " + questions.length);
        mainPanel.setLayout(new BorderLayout());

        //timer
        timerTextField = new JTextField();
        timerTextField.setEditable(false);
        timerTextField.setHorizontalAlignment(JTextField.RIGHT);
        timerTextField.setText(timer.getTimeSpent());
        if (index == 0) {
            //if it's the first question, start timer
            timerThread = new Thread(timer);
            timerThread.start();
        }

        //question
        JTextArea questionTextArea = new JTextArea(questions[index].getQuestion());
        questionTextArea.setEditable(false);

        //answers
        JPanel answersPanel = new JPanel(new GridLayout(0, 1));
        ButtonBuilder.addButtons(answersPanel, questions[index].getAnswers(), answerListener);

        //add elements
        mainPanel.add(timerTextField, BorderLayout.NORTH);
        mainPanel.add(questionTextArea, BorderLayout.CENTER);
        mainPanel.add(answersPanel, BorderLayout.SOUTH);

        //draw everything
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void showResult(int score, int maxPossibleScore) {
        timer.stop();
        mainPanel.removeAll();
        setTitle("Result");

        JTextArea resultTextArea = new JTextArea(
                "Your score is " + score + " out of " + maxPossibleScore + "\n" +
                "Time spent: " + timer.getTimeSpent()
        );
        resultTextArea.setEditable(false);

        mainPanel.add(resultTextArea, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void updateTimer() {
        timerTextField.setText(timer.getTimeSpent());
        revalidate();
        repaint();
    }
}

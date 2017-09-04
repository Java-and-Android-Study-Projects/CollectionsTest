package gui;

import logic.AnswerListener;
import logic.Question;

import javax.swing.*;
import java.awt.*;

public class TestWindow extends JFrame {
    public TestWindow (AnswerListener answerListener, Question question) {

        setTitle ( "Test" );
        setDefaultCloseOperation ( WindowConstants. EXIT_ON_CLOSE);
        setBounds ( 300 ,     300 ,     400 ,     400 );

        setLayout(new GridLayout(0, 1));

        JTextArea questionText = new JTextArea(question.getQuestion());
        add(questionText);
        ButtonBuilder.addButtons(this, question.getAnswers(), answerListener);

        setVisible (true);
    }
}

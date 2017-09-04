package gui;

import logic.AnswerListener;
import logic.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseTestWindow extends JFrame {

    public ChooseTestWindow(AnswerListener answerListener, String[] testNames) {

        setTitle ( "Choose Test" );
        setDefaultCloseOperation ( WindowConstants. EXIT_ON_CLOSE);
        setBounds ( 300 ,     300 ,     400 ,     400 );

        setLayout(new GridLayout(0, 1));

        ButtonBuilder.addButtons(this, testNames, answerListener);

        setVisible (true);
    }
}

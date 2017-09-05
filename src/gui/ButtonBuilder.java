package gui;

import logic.AnswerListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonBuilder {
    public static void addButtons(JPanel panel, String[] names, AnswerListener answerListener) {
        for (int i = 0; i < names.length; i++) {
            final int index = i;
            JButton button = new JButton(names[index]);

            //fixme: this monstrosity should be changed to something else
            button.addActionListener((ActionEvent e) -> answerListener.reactOnAnswer(index));
            panel.add(button);
        }
    }
}

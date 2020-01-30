package coo.questionnaire.gui;

import coo.questionnaire.Answer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

/**
 * A class for the group answer.
 *
 * @param <T>
 */
public abstract class GroupAnswerPanel<T> extends AnswerPanel {

    /**
     * Contain a list of values of the different answer.
     */
    protected Collection<T> theValues;

    private ButtonGroup group;
    private String answerText;

    /**
     * Create a new group answer panel.
     *
     * @param answer a list of the answer
     */
    public GroupAnswerPanel(Answer<?> answer) {
        super(answer);
        this.initTheValues();
    }

    /**
     * Init the different options of the answer.
     */
    protected abstract void initTheValues();

    public JPanel getPanel() {
        JPanel result = new JPanel();
        result.setLayout(new GridLayout(2, 1));
        this.group = new ButtonGroup();
        Iterator<T> var3 = this.theValues.iterator();

        while (var3.hasNext()) {
            T t = var3.next();
            JRadioButton button = new JRadioButton(t.toString());
            button.addActionListener(new GroupAnswerPanel.ButtonListener());
            this.group.add(button);
            result.add(button);
        }

        return result;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    class ButtonListener implements ActionListener {
        ButtonListener() {
        }

        public void actionPerformed(ActionEvent e) {
            GroupAnswerPanel.this.answerText = e.getActionCommand();
        }
    }
}
package coo.questionnaire.gui;

import coo.questionnaire.Answer;

import javax.swing.*;

/**
 * Class for display and manage a panel for an answer.
 */
public abstract class AnswerPanel {

    protected Answer<?> answer;

    /**
     * Create a new answer panel.
     *
     * @param answer the answer to create a panel
     */
    public AnswerPanel(Answer<?> answer) {
        this.answer = answer;
    }

    /**
     * Give the panel of the answer.
     *
     * @return the panel of the answer
     */
    public abstract JPanel getPanel();

    /**
     * Give the text of the answer.
     *
     * @return the text of the answer
     */
    public abstract String getAnswerText();
}
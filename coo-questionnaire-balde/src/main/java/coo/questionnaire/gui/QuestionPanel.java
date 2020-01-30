package coo.questionnaire.gui;

import coo.questionnaire.Question;

import javax.swing.*;
import java.awt.*;

/**
 * Class for provide a panel for the questions.
 */
public class QuestionPanel extends JPanel {

    /**
     * The text of the question.
     */
    protected JLabel text;

    /**
     * The panel of the answer of the question.
     */
    protected AnswerPanel inputAnswerPanel;

    /**
     * the question who need a panel.
     */
    protected Question question;

    /**
     * Create a new question panel.
     *
     * @param question the question who need panel
     */
    public QuestionPanel(Question question) {
        this.question = question;
        this.text = new JLabel("  " + question.getQuestionText() + " : ");
        this.setLayout(new GridLayout(1, 2));
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.text.setAlignmentY(0.5F);
        this.add(this.text);
        AnswerPanel inputAnswerPanel = this.createInputAnswerPanel();
        inputAnswerPanel.getPanel().setAlignmentY(0.5F);
        this.add(inputAnswerPanel.getPanel());
    }

    private AnswerPanel createInputAnswerPanel() {
        return this.question.getTheGoodAnswer().createMyAnswerPanel();
    }

    /**
     * Set the value of the answer of the question.
     */
    public void setAnswer() {
        this.question.setUserAnswer(this.inputAnswerPanel.getAnswerText());
    }
}

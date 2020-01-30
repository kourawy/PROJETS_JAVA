package coo.questionnaire.gui;

import coo.questionnaire.NumericalAnswer;

import javax.swing.*;
import java.awt.*;

/**
 * A class for the panel of the numerical answer.
 */
public class NumericalAnswerPanel extends AnswerPanel {

    private JSpinner spinner;

    /**
     * Create a new panel.
     *
     * @param answer the answer who need a panel
     */
    public NumericalAnswerPanel(NumericalAnswer answer) {
        super(answer);
    }

    public JPanel getPanel() {
        JPanel result = new JPanel();
        this.spinner = new JSpinner();
        this.spinner.setPreferredSize(new Dimension(100, 50));
        this.spinner.setAlignmentY(0.5F);
        result.add(this.spinner);
        return result;
    }

    @Override
    public String getAnswerText() {
        return this.spinner.getValue().toString();
    }
}

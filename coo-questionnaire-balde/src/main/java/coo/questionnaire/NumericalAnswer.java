package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;
import coo.questionnaire.gui.NumericalAnswerPanel;

/**
 * A number type answer.
 */
public class NumericalAnswer extends Answer<Integer> {

    /**
     * Create a new numerical answer.
     *
     * @param theGoodAnswer the good answer for the question as a int
     */
    public NumericalAnswer(Integer theGoodAnswer) {
        super(theGoodAnswer);
    }

    /**
     * Create a new numerical answer.
     *
     * @param answerText the good answer for the question as a string
     */
    public NumericalAnswer(String answerText) {
        this(Integer.parseInt(answerText));
    }

    public boolean accept(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }

    public String instruction() {
        return "nombre";
    }

    @Override
    public AnswerPanel createMyAnswerPanel() {
        return new NumericalAnswerPanel(this);
    }
}

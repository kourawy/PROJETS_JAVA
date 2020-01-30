package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;
import coo.questionnaire.gui.TextAnswerPanel;

/**
 * Answer herited class for a text answer.
 */
public class TextAnswer extends Answer<String> {

    public TextAnswer(String theGoodAnswer) {
        super(theGoodAnswer);
    }

    public boolean accept(String s) {
        return true;
    }

    public String instruction() {
        return "text";
    }

    public AnswerPanel createMyAnswerPanel() {
        return new TextAnswerPanel(this);
    }

}

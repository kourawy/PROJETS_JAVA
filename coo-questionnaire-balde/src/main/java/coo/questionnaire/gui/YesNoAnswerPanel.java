package coo.questionnaire.gui;

import coo.questionnaire.YesNo;
import coo.questionnaire.YesNoAnswer;

import java.util.Arrays;

/**
 * Class for create a panel for the yes or no answers.
 */
public class YesNoAnswerPanel extends GroupAnswerPanel<YesNo> {

    /**
     * Create a new panel for a yes or no answer.
     *
     * @param question the question who need a panel
     */
    public YesNoAnswerPanel(YesNoAnswer question) {
        super(question);
    }

    protected void initTheValues() {
        this.theValues = Arrays.asList(YesNo.values());
    }
}

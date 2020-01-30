package coo.questionnaire.gui;

import coo.questionnaire.MultipleChoiceAnswer;

/**
 * Class for multiple answer in the gui.
 */
public class MultipleChoiceAnswerPanel extends GroupAnswerPanel<String> {

    /**
     * Create a new multiple choice answer panel.
     *
     * @param answer the answer who nedd a panel
     */
    public MultipleChoiceAnswerPanel(MultipleChoiceAnswer answer) {
        super(answer);
    }

    protected void initTheValues() {
        this.theValues = ((MultipleChoiceAnswer) this.answer).getThePropositions();
    }
}

package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;
import coo.questionnaire.gui.YesNoAnswerPanel;

/**
 * Answer for the questions with yes or no answer.
 */
public class YesNoAnswer extends Answer<YesNo> {

    /**
     * Create a new answer.
     *
     * @param theGoodAnswer the good answer for the question
     */
    public YesNoAnswer(YesNo theGoodAnswer) {
        super(theGoodAnswer);
    }

    /**
     * Create a new answer.
     *
     * @param answerText the good answer for the question
     */
    public YesNoAnswer(String answerText) {
        this(YesNo.valueOf(answerText));
    }

    public String instruction() {
        String instruction = "";
        YesNo[] var5;
        int var4 = (var5 = YesNo.values()).length;

        for (int var3 = 0; var3 < var4; ++var3) {
            YesNo value = var5[var3];
            instruction = instruction + " " + value.name();
        }

        return instruction;
    }

    @Override
    public AnswerPanel createMyAnswerPanel() {
        return new YesNoAnswerPanel(this);
    }

    public boolean accept(String s) {
        try {
            YesNo.valueOf(s);
            return true;
        } catch (IllegalArgumentException var3) {
            return false;
        }
    }
}

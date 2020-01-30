package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;
import coo.questionnaire.gui.MultipleChoiceAnswerPanel;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Answer for multiple choice question.
 */
public class MultipleChoiceAnswer extends TextAnswer {

    /**
     * The separator between multiple answers.
     */
    public static final String MULTIPLE_CHOICE_SEPARATOR = "\\|";
    private List<String> thePropositions;

    /**
     * Create a new answer.
     *
     * @param theGoodAnswer     the text for the good answer
     * @param otherPropositions other propositions of answer
     */
    public MultipleChoiceAnswer(String theGoodAnswer, List<String> otherPropositions) {
        super(theGoodAnswer);
        this.init(theGoodAnswer, otherPropositions);
    }

    /**
     * Create a new answer.
     *
     * @param answerText the text of the answer
     */
    public MultipleChoiceAnswer(String answerText) {
        super((String) null);
        LinkedList<String> choices = new LinkedList();
        Scanner sc = (new Scanner(answerText)).useDelimiter(Pattern.compile("\\s\\|\\s"));
        String goodAnswer = sc.next().trim();

        while (sc.hasNext()) {
            choices.add(sc.next().trim());
        }

        sc.close();
        this.value = goodAnswer;
        this.init(goodAnswer, choices);
    }

    private void init(String theRightAnswer, List<String> otherPropositions) {
        this.thePropositions = otherPropositions;
        this.thePropositions.add(theRightAnswer);
        Collections.shuffle(this.thePropositions);
    }

    public String instruction() {
        StringBuffer instruction = new StringBuffer("");
        Iterator var3 = this.thePropositions.iterator();

        while (var3.hasNext()) {
            String s = (String) var3.next();
            instruction.append(s);
            instruction.append(",");
        }

        return instruction.toString();
    }

    public boolean accept(String s) {
        return this.thePropositions.contains(s);
    }

    public List<String> getThePropositions() {
        return this.thePropositions;
    }

    public AnswerPanel createMyAnswerPanel() {
        return new MultipleChoiceAnswerPanel(this);
    }

}

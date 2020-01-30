package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;
import coo.questionnaire.gui.TextAnswerPanel;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * A multiple answer for a question.
 */
public class MultiAnswer extends Answer<List<String>> {

    public static final String MULTI_ANSWER_SEPARATOR = ";";

    /**
     * Check if the answer is correct or not.
     *
     * @param text the text giving by the user
     * @return true if the answer is correct, false otherwise
     */
    public boolean isCorrect(String text) {
        return ((List) this.value).contains(text);
    }

    /**
     * Create a new multi answer.
     *
     * @param theGoodAnswer a list of good answers of the question
     */
    public MultiAnswer(List<String> theGoodAnswer) {
        super(theGoodAnswer);
    }

    /**
     * Create a new multi answer.
     *
     * @param answerText the text of the good answer of the question
     */
    public MultiAnswer(String answerText) {
        super((List<String>) null);
        List<String> answers = new LinkedList();
        Scanner sc = (new Scanner(answerText)).useDelimiter("\\s;\\s");

        while (sc.hasNext()) {
            answers.add(sc.next().trim());
        }

        sc.close();
        this.value = answers;
    }

    /**
     * Method check is the answer is accepted or not.
     *
     * @param s the answer to test
     * @return true if the answer is accepted, false otherwise
     */
    public boolean accept(String s) {
        return true;
    }

    /**
     * Return the instructions for the question.
     *
     * @return the text that indicate how to answer the question
     */
    public String instruction() {
        return "text - plusieurs reponses possibles";
    }

    /**
     * Create a new panel for this answer.
     *
     * @return the TextAnswerPanel created
     */
    public AnswerPanel createMyAnswerPanel() {
        return new TextAnswerPanel(this);
    }

}

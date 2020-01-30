package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;

/**
 * Class for set the answer for a qestion.
 *
 * @param <T> the type of the answer
 */
public abstract class Answer<T> {
    protected T value;

    /**
     * Create a new answer with the good one in parameter.
     *
     * @param theGoodAnswer the ood answer for the question
     */
    public Answer(T theGoodAnswer) {
        this.value = theGoodAnswer;
    }

    /**
     * Get the value of the answer.
     *
     * @return the value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Method who say if the answer give by the user was accepted by for this question.
     *
     * @param answer the answer give by the user
     * @return true if the answer is in a good format, false otherwise
     */
    public abstract boolean accept(String answer);

    /**
     * Display the instructions for a question like the kind of answer expected.
     *
     * @return the instruction to give to the user
     */
    public abstract String instruction();

    /**
     * Say if the answer is correct or not.
     *
     * @param text the text giving by the user
     * @return true if the answer is correct, false otherwise
     */
    public boolean isCorrect(String text) {
        return this.value.toString().equals(text);
    }

    public String toString() {
        return this.value.toString();
    }

    /**
     * Create a panel for the gui version of the app.     * @return a new answer panel for the answer
     */
    public abstract AnswerPanel createMyAnswerPanel();
}
package coo.questionnaire;

/**
 * Class for initialise and manage a question.
 */
public class Question {

    protected String text;
    protected String theUserTextAnswer;
    protected final Answer<?> theGoodAnswer;
    protected int nbPoints;

    /**
     * Create a new question.
     *
     * @param t   the text of the question
     * @param a   the answer of the question
     * @param nbP the amount of points that give the question
     */
    public Question(String t, Answer<?> a, int nbP) {
        this.text = t;
        this.theGoodAnswer = a;
        this.nbPoints = nbP;
    }

    /**
     * Return the number of points that gives the question.
     *
     * @return the number of points
     */
    public int getNbOfPoints() {
        return this.nbPoints;
    }

    /**
     * Return the text of the question.
     *
     * @return the text of the question
     */
    public String getQuestionText() {
        return this.text;
    }

    /**
     * Method who say if the answer give by the user was accepted by for this question.
     *
     * @param userAnswer the answer give by the user
     * @return true if the answer is in a good format, false otherwise
     */
    public boolean isAcceptable(String userAnswer) {
        return this.theGoodAnswer.accept(userAnswer);
    }

    /**
     * Say if the answer is correct or not.
     *
     * @return true if the answer is correct, false otherwise
     */
    public boolean isUserAnswerCorrect() {
        return this.theGoodAnswer.isCorrect(this.theUserTextAnswer);
    }

    /**
     * Modify the user answer text.
     *
     * @param userAnswerText the new user answer text
     */
    public void setUserAnswer(String userAnswerText) {
        this.theUserTextAnswer = userAnswerText;
    }

    /**
     * Get the good answer of the question.
     *
     * @return the good answer of the question
     */
    public Answer<?> getTheGoodAnswer() {
        return this.theGoodAnswer;
    }

    /**
     * Get the answer provide by the user.
     *
     * @return the answer give by the user
     */
    public String getTheUserAnswer() {
        return this.theUserTextAnswer;
    }

}

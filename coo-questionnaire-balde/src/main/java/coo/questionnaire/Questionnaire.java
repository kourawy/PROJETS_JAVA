package coo.questionnaire;

import coo.questionnaire.gui.AnswerPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class create a new questionnaire.
 */
public class Questionnaire {

    /**
     * The list of the question in the questionnaire.
     */
    protected List<Question> questions = new ArrayList();

    /**
     * The amount of points that have an user.
     */
    protected int nbPoints;

    /**
     * Create a new questionnaire.
     */
    public Questionnaire() {

    }

    /**
     * Print all the questions in the terminal and ask answers.
     */
    public void askAll() {
        this.nbPoints = 0;
        Iterator it = this.questions.iterator();

        while (it.hasNext()) {
            Question quest = (Question) it.next();
            System.out.println("-----------------------------------------");
            System.out.println(quest.getQuestionText());
            boolean valid = false;
            String answer = null;

            while (!valid) {
                try {
                    System.out.println("Quelle est votre réponse [" + quest.getTheGoodAnswer().instruction() + "] ? ");
                    answer = Input.readLine();
                    valid = quest.isAcceptable(answer);
                } catch (IOException var6) {
                    answer = "";
                    valid = false;
                }
            }

            quest.setUserAnswer(answer);
            if (quest.isUserAnswerCorrect()) {
                System.out.println("correct, (" + quest.getNbOfPoints() + " point(s))");
                this.nbPoints += quest.getNbOfPoints();
            } else {
                System.out.println("incorrect, la bonne reponse etait " + quest.getTheGoodAnswer());
            }
        }

        System.out.println("Vous avez obtenu " + this.nbPoints + " point(s)");
    }

    /**
     * Print all the questions in the gui and ask all answers.
     *
     * @param panel the panel in wich are created the panels of the questions
     * @return the number of points an user have in the end of the questionnaire
     */
    public int askAllGui(JPanel panel) {
        this.nbPoints = 0;
        Iterator it = this.questions.iterator();

        while (it.hasNext()) {
            Question quest = (Question) it.next();
            JLabel label = new JLabel(quest.getQuestionText());
            panel.add(label);

            boolean valid = false;
            String answer = null;

            AnswerPanel answerPanel = quest.theGoodAnswer.createMyAnswerPanel();
            panel.add(answerPanel.getPanel());

            answer = answerPanel.getAnswerText();

            if (quest.theGoodAnswer.isCorrect(answer)) {
                nbPoints += quest.getNbOfPoints();
            }
        }

        return nbPoints;
    }

    /**
     * Add a uestion to the questionnaire.
     *
     * @param questionToAdd the question to add in the questionnaire
     */
    public void addQuestion(Question questionToAdd) {
        this.questions.add(questionToAdd);
    }
}
package coo.questionnaire;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class will produce answer when needed.
 */
public class AnswerFactory {

    /**
     * Singleton attribute: the only instance of the factory allowed.
     */
    public static final AnswerFactory FACTORY = new AnswerFactory();

    /**
     * Create a new answer whith the good type.
     *
     * @param answer the string of the answer
     * @return the answer of the good type
     */
    public Answer<?> buildAnswer(String answer) {
        if (new NumericalAnswer(1).accept(answer)) {
            return new NumericalAnswer(new Integer(answer));
        } else if (new YesNoAnswer(YesNo.values()[0]).accept(answer)) {
            return new YesNoAnswer(YesNo.valueOf(answer));
        } else if (answer.indexOf(59) != -1) {
            return this.buildMultiAnswer(answer);
        } else {
            return (Answer) (answer.indexOf(124) != -1 ? this.buildMultipleChoice(answer) : new TextAnswer(answer));
        }
    }

    private MultipleChoiceAnswer buildMultipleChoice(String answer) {
        LinkedList<String> choices = new LinkedList();
        Scanner sc = (new Scanner(answer)).useDelimiter(Pattern.compile("\\|"));
        String rightAnswer = sc.next().trim();

        while (sc.hasNext()) {
            choices.add(sc.next().trim());
        }

        sc.close();
        return new MultipleChoiceAnswer(rightAnswer, choices);
    }

    private MultiAnswer buildMultiAnswer(String answer) {
        List<String> answers = new LinkedList();
        Scanner sc = (new Scanner(answer)).useDelimiter("\\s;\\s");

        while (sc.hasNext()) {
            answers.add(sc.next().trim());
        }

        sc.close();
        return new MultiAnswer(answers);
    }

}

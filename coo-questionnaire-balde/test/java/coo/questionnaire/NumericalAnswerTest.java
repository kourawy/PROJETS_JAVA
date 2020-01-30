package coo.questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumericalAnswerTest extends AnswerTest {


	@Override
	public Answer getAnswer() {
		// TODO Auto-generated method stub
		return new NumericalAnswer(5);
	}

	@Override
	public String getCorrectAnswer() {
		// TODO Auto-generated method stub
		return "1234\n";
	}

	@Override
	public String getInCorrectAnswer() {
		// TODO Auto-generated method stub
		return "fuck\n";
	}

}

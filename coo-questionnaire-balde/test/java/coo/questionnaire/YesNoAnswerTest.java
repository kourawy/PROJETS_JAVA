package coo.questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

public class YesNoAnswerTest extends AnswerTest {

	@Override
	public Answer getAnswer() {
		// TODO Auto-generated method stub
		return new TextAnswer("oui");
	}

	@Override
	public String getCorrectAnswer() {
		// TODO Auto-generated method stub
		return "oui\n";
	}

	@Override
	public String getInCorrectAnswer() {
		// TODO Auto-generated method stub
		return "123\n";
	}

	

}

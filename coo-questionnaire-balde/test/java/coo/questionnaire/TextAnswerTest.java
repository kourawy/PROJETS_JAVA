package coo.questionnaire;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextAnswerTest extends AnswerTest {

	@Override
	public Answer getAnswer() {
		// TODO Auto-generated method stub
		return new TextAnswer("kebir");
	}

	@Override
	public String getCorrectAnswer() {
		// TODO Auto-generated method stub
		return "kebir\n";
	}

	@Override
	public String getInCorrectAnswer() {
		// TODO Auto-generated method stub
		return "123\n";
	}

	

}

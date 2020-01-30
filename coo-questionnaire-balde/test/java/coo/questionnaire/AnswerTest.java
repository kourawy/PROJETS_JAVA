package coo.questionnaire;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AnswerTest {
	private Answer answer ;
	public abstract Answer getAnswer() ;
	public abstract String getCorrectAnswer();
	public abstract String getInCorrectAnswer();
	
	public void mockAnswer(String input){
		InputStream mock = new ByteArrayInputStream(input.getBytes());
		Input.INPUT.setIn(mock);
	}
	
	@Before
	public  void init()  {
		answer = this.getAnswer();
	}

	@After
	public void testAnswer() {
		Input.INPUT.setIntoStringIn();
	}

	
	@Test
	public void testAnswerCorrect() throws IOException {
		mockAnswer(getCorrectAnswer());
		assertTrue(getAnswer().accept(Input.INPUT.readLine()));
	}
	
	@Test
	public void testNoAnswerCorrect() throws IOException {
		mockAnswer(getInCorrectAnswer());
		assertFalse(getAnswer().accept(Input.INPUT.readLine()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}

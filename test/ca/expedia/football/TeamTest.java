package ca.expedia.football;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTest {

	@Test(expected=IllegalStateException.class)
	public void testConstructorNameIsNull() {
		new Team(null);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testConstructorNameIsBlank() {
		new Team("");
	}
	
	@Test
	public void testConstructorNameIsOK() {
		Team t = new Team("Montreal Impact");
		assertEquals("Montreal Impact", t.getName());
	}
	
	@Test
	public void testScoresheet() {
		Team t = new Team("Montreal Impact");
		assertEquals("Montreal Impact", t.getName());
		
		assertEquals("Montreal Impact 0", t.getScoresheet());
	}	
}

package ca.expedia.football;

import org.junit.Test;

public class MatchTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testGoalWithTeamNull() {
		Match m = new Match("Club America", "montreal Impact");
		m.goooooooooooooooaaaal(1, null, "Romero");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGoalWithTeamBlank() {
		Match m = new Match("Club America", "montreal Impact");
		m.goooooooooooooooaaaal(1, "", "Romero");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGoalWithPlayerNull() {
		Match m = new Match("Club America", "montreal Impact");
		m.goooooooooooooooaaaal(1, "Montreal Impact", null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGoalWithPlayerBlank() {
		Match m = new Match("Club America", "montreal Impact");
		m.goooooooooooooooaaaal(1, "Montreal Impact", "");
	}
	
	@Test
	public void testGetScoresheet() {
		
	}
}

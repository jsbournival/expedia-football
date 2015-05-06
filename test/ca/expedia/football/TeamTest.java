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
	
	@Test
	public void testAddGoalWithMultiplePlayerSameMinute() {
		
		Team t = new Team("Club America");
		t.addGoal(1, "Benedetto");
		t.addGoal(2, "Benedetto");
		t.addGoal(3, "Quintero");
		t.addGoal(4, "Quintero");
		
		assertEquals("Club America 4 (Benedetto 1' 2', Quintero 3' 4')", t.getScoresheet());		
	}

	@Test
	public void testAddGoalWithSamePlayer() {
		
		Team t = new Team("Montreal Impact");
		t.addGoal(1, "Romero");
		t.addGoal(2, "Romero");
		
		assertEquals("Montreal Impact 2 (Romero 1' 2')", t.getScoresheet());		
	}

	@Test
	public void testAddGoalWithSamePlayerUnsortedMinutes() {
		
		Team t = new Team("Montreal Impact");
		t.addGoal(2, "Romero");
		t.addGoal(1, "Romero");
		
		assertEquals("Montreal Impact 2 (Romero 1' 2')", t.getScoresheet());		
	}

	@Test
	public void testAddGoalWithSamePlayerMultipleGoalInSameMinute() {
		Team t = new Team("Montreal Impact");
		t.addGoal(1, "Romero");
		t.addGoal(1, "Romero");
		
		assertEquals("Montreal Impact 2 (Romero 1' 1')", t.getScoresheet());
	}	
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddGoalWithMinuteOver90() {
		Team t = new Team("Montreal Impact");
		t.addGoal(92, "Romero");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddGoalWithNegativeMinute() {
		Team t = new Team("Montreal Impact");
		t.addGoal(-1, "Romero");
	}	

	@Test(expected=IllegalArgumentException.class)
	public void testAddGoalWithZeroMinute() {
		Team t = new Team("Montreal Impact");
		t.addGoal(0, "Romero");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddGoalWithPlayerNull() {
		Team t = new Team("Montreal Impact");
		t.addGoal(1, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAddGoalWithPlayerBlank() {
		Team t = new Team("Montreal Impact");
		t.addGoal(1, "");
	}		
}

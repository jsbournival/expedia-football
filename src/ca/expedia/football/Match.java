package ca.expedia.football;


/**
 * Implements a football match
 * @author jsbournival
 */
public class Match {
	
	private Team homeTeam, awayTeam = null;
	
	public Match(String homeTeamName, String awayTeamName) {
		
		homeTeam = new Team(homeTeamName);
		awayTeam = new Team(awayTeamName);
	}
	
	/**
	 * Registers a goal scored
	 * @param minute the time the goal was scored
	 * @param team the name of the team who scored 
	 * @param player the name of the player who scored
	 */
	public void goooooooooooooooaaaal(int minute, String team, String player) {		
		
		if (team.equals(homeTeam.getName())) {
			homeTeam.addGoal(minute, player);
		} else if(team.equals(awayTeam.getName())) {
			awayTeam.addGoal(minute, player);
		} else {
			throw new IllegalArgumentException(team + " is not playing in this match");
		}
	}
	
	/**
	 * @return the actual match score
	 */
	public String getScore() {
		return homeTeam.getScoresheet() + " vs. " + awayTeam.getScoresheet();
	}
}

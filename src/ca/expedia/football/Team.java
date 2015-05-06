package ca.expedia.football;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implements a team, playing in a football match
 * @author jsbournival
 */
public class Team {
	
	private String teamName = null;
	
	// TODO: refactor the data structure of the goals to support multiple goals by the same player
	private SortedMap<Integer, String> scoresheet = new TreeMap<Integer, String>();
	
	public Team(String teamName) {
		if (teamName == null || teamName.equalsIgnoreCase(""))
			throw new IllegalStateException("Team name cannot be null");
		
		setName(teamName);
	}

	public String getName() {
		return teamName;
	}
	
	private void setName(String name) {
		this.teamName = name;
	}	

	/**
	 * Registers a goal for this team
	 * @param minute the time the goal was scored
	 * @param player the name of the payer who scored the goal
	 */
	public void addGoal(int minute, String player) {
		if (minute > 90 || minute <= 0)
			throw new IllegalArgumentException("goals have to be scored in regulation time. sorry.");
		
		scoresheet.put(minute, player);
	}
	
	/**
	 * @return this team's scoresheet
	 */
	public String getScoresheet() {
		StringBuilder score = new StringBuilder(getName());
		score.append(" " + scoresheet.size());
		
		if (scoresheet.size() > 0) {
			score.append(" (");
			for(Map.Entry<Integer,String> goal : scoresheet.entrySet()) {
				score.append(goal.getValue() + " " + goal.getKey() + "', ");
			}
			score.delete(score.length()-2,score.length());
			score.append(")");
		}
		
		return score.toString();
	}
}

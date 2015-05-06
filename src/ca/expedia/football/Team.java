package ca.expedia.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements a team, playing in a football match
 * @author jsbournival
 */
public class Team {
	
	private String teamName = null;
	
	private Map<String, List<Integer>> scoresheet = new LinkedHashMap<String, List<Integer>>();
	
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
		
		if (player == null || player.equalsIgnoreCase(""))
			throw new IllegalArgumentException("player is null or blank.");
		
		if (!scoresheet.containsKey(player)) {
			List<Integer> l = new ArrayList<Integer>();
			l.add(minute);
			scoresheet.put(player, l);
		} else {
			scoresheet.get(player).add(minute);
		}		
	}
	
	/**
	 * @return this team's scoresheet
	 */
	public String getScoresheet() {
		
		int numberOfGoals = 0;
				
		StringBuilder score = new StringBuilder();
		if (scoresheet.size() > 0) {
			score.append(" (");
			for(Map.Entry<String,List<Integer>> goal : scoresheet.entrySet()) {
				score.append(goal.getKey());
				numberOfGoals += goal.getValue().size();
				
				Collections.sort(goal.getValue());
				for (Integer i : goal.getValue()) {
					score.append(" " + i + "'");
				}
				score.append(", ");
			}
			score.delete(score.length()-2,score.length());
			score.append(")");
		}
		
		return getName() + " " + numberOfGoals + score.toString();
	}
}

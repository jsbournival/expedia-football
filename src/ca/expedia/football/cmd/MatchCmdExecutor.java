package ca.expedia.football.cmd;

import ca.expedia.football.Scoreboard;

/**
 * Manages the chain of commands
 * @author jsbournival
 */
public class MatchCmdExecutor {
	
	private MatchCmd startOfChain = null;
	private Scoreboard scoreboard = null;
	
	public MatchCmdExecutor(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
		
		// building chain of commands
		startOfChain = new PrintScoreCmd(new StartMatchCmd(new EndMatchCmd(new ScoreGoalCmd(null))));
	}
	
	/**
	 * Point of entry for commands
	 * @param cmd the command to execute
	 */
	public void handleCmd(String cmd) {
		startOfChain.handleCmd(scoreboard, cmd);
	}
}

package ca.expedia.football.cmd;

import ca.expedia.football.Scoreboard;

/**
 * Implementation of a Print Score command
 * @author jsbournival
 */
public class PrintScoreCmd extends BaseMatchCmd {
	
	public PrintScoreCmd(MatchCmd next) {
		super(next);
	}

	/**
	 * @see MatchCmd#handleCmd(Scoreboard, String)
	 */	
	@Override
	public void handleCmd(Scoreboard scoreboard, String cmd) {

		if (cmd.equalsIgnoreCase("print")) {
			System.out.println(scoreboard.getMatch().getScore());
		} else {
			getNext().handleCmd(scoreboard, cmd);
		}
	}
}

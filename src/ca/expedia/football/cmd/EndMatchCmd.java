package ca.expedia.football.cmd;

import ca.expedia.football.Scoreboard;

/**
 * Implementation of a End Match command
 * @author jsbournival
 */
public class EndMatchCmd extends BaseMatchCmd {

	public EndMatchCmd(MatchCmd next) {
		super(next);
	}

	/**
	 * @see MatchCmd#handleCmd(Scoreboard, String)
	 */
	@Override
	public void handleCmd(Scoreboard scoreboard, String cmd) {

		if (cmd.equals("End")) {
			scoreboard.display("Match ended. final score: " + scoreboard.getMatch().getScore());
			scoreboard.endMatch();
		} else {
			getNext().handleCmd(scoreboard, cmd);
		}
	}
}

package ca.expedia.football.cmd;

import ca.expedia.football.Scoreboard;

/**
 * Base match command class implementing the chain of responsibility link between commands
 * @author jsbournival
 */
public abstract class BaseMatchCmd implements MatchCmd {

	public BaseMatchCmd(MatchCmd next) {
		this.next = next;
	}
	
	private MatchCmd next;
	public MatchCmd getNext() {
		if (next == null) {
			throw new IllegalArgumentException();
		}
		
		return next;
	}
	
	/**
	 * @see MatchCmd#handleCmd(Scoreboard, String)
	 */
	public abstract void handleCmd(Scoreboard scoreboard, String cmd);
}
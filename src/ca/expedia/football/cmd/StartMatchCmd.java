package ca.expedia.football.cmd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.expedia.football.Scoreboard;

/**
 * Implementation of a Start Match command
 * @author jsbournival
 */
public class StartMatchCmd extends BaseMatchCmd {

	public StartMatchCmd(MatchCmd next) {
		super(next);
	}

	/**
	 * @see MatchCmd#handleCmd(Scoreboard, String)
	 */
	@Override
	public void handleCmd(Scoreboard scoreboard, String cmd) {
				
		Pattern p = Pattern.compile("Start: ('.*'|\\w+) vs\\. ('.*'|\\w+)");
		Matcher m = p.matcher(cmd);
		
		if (m.matches()) {
			String homeTeamName = m.group(1).replaceAll("^'|'$", "");
			String awayTeamName = m.group(2).replaceAll("^'|'$", "");
			
			scoreboard.startMatch(homeTeamName, awayTeamName);
			scoreboard.display("Match has started! The crowd goes nuts!");
		} else {
			getNext().handleCmd(scoreboard, cmd);
		}
	}
}

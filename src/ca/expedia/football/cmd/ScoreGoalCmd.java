package ca.expedia.football.cmd;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.expedia.football.Scoreboard;

/**
 * Implementation of a Goal Scored command
 * @author jsbournival
 */
public class ScoreGoalCmd extends BaseMatchCmd {

	private String[] comments = {"Que Golazo!", "Too easy!", "Nice Volley!", "OMG, Bicycle!!", "Set-Piece perfection!"};
	
	public ScoreGoalCmd(MatchCmd next) {
		super(next);
	}

	/**
	 * @see MatchCmd#handleCmd(Scoreboard, String)
	 */
	@Override
	public void handleCmd(Scoreboard scoreboard, String cmd) {		
		
		Pattern p = Pattern.compile("([0-9]+) ('.*'|\\w+) ('.*'|\\w+)");
		Matcher m = p.matcher(cmd);
		
		if (m.matches()) {
			
			String team = m.group(2).replaceAll("^'|'$", "");
			String player = m.group(3).replaceAll("^'|'$", "");
			
			scoreboard.getMatch().goooooooooooooooaaaal(new Integer(m.group(1)), team, player);
			scoreboard.display("GOOOOOOOOOOOAAAALL! " + comments[(int)new Date().getTime() % 5]);
		} else {
			getNext().handleCmd(scoreboard, cmd);
		}		
	}
}

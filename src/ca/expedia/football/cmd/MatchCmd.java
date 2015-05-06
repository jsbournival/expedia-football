package ca.expedia.football.cmd;

import ca.expedia.football.Scoreboard;

public interface MatchCmd {

	public void handleCmd(Scoreboard scoreboard, String cmd);
}

package ca.expedia.football;

import java.io.Console;

import ca.expedia.football.cmd.MatchCmdExecutor;

public class Scoreboard {
	
	private Match match = null;
	
	public void startMatch(String homeTeamName, String awayTeamName) {
		if (isGameInProgress()) {
			throw new IllegalArgumentException("A game is already under way");
		}
		
		match = new Match(homeTeamName, awayTeamName); 
	}
	
	public void endMatch() {
		match = null; 
	}	
	
	public boolean isGameInProgress() {
		return match != null;
	}
	
	public Match getMatch() throws NoMatchStartedException {
		if (match == null) {
			throw new NoMatchStartedException();
		}
		
		return match;
	}
	
	public void display(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {
	
		Scoreboard scoreboard = new Scoreboard();
		MatchCmdExecutor executor = new MatchCmdExecutor(scoreboard); 
	
		scoreboard.display("\nWELCOME TO EXPEDIA FOOTBALL SCOREBOARD (c) 2015");
		scoreboard.display("-----------------------------------------------\n");
		
		while (true) {
			try {
				Console c = System.console();
				if (c == null) {
					System.exit(1);
				}
				
				String cmd = c.readLine("> ");
				if (cmd.equalsIgnoreCase("")) continue;
				
				executor.handleCmd(cmd);
				
			} catch(IllegalArgumentException e) {
				String msg = scoreboard.isGameInProgress() ? "please type 'print' for game details" : "please start a game through typing \"Start: '<Name of Home Team>' vs. '<Name of Away Team>'\"";
				scoreboard.display("input error - " + msg);
			} catch (NoMatchStartedException e) {
				scoreboard.display("No game currently in progress");
			}
		}
	}
}

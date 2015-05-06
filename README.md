# expedia-football

## USAGE

### compile
```
$project_root> mkdir bin
$project_root> javac -d bin $(find ./src/* | grep .java)
```
### run

The Scoreboard class is executable.  Simply run it by entering:
```
$project_root> java -cp bin/ ca.expedia.football.Scoreboard
```
CTRL+C to exit the program

——

You should be presented a prompt, allowing commands to be entered.  Here are the 4 supported commands.

**To start a game:**

Start: ‘home_team_name’ vs. ‘away_team_name’

*ex.* 
```Start: ‘Club America’ vs. ‘Montreal Impact’```

**To print the score of the game under way:**
	
```print ```

**To enter a goal scored:**

*Minute_of_the_goal* ‘team_name’ ‘player_who_scored’
	
*ex.* 
```8 ‘Montreal Impact’ Romero```

**To end a game, simply:**
	
```End ```

### *NOTES*

* The project have been developed with Java 7
* The project includes Eclipse project and classpath files
* No external dependencies have been used, except Eclipse’s internal JUnit4 libraries

——

## DESIGN DECISIONS

*A class diagram visually explaining the design lies at the project root directory.*

Although they could’ve been one class, I separated the Scoreboard class from the Match class.  In my understanding, the Scoreboard class sole purpose was display and witness the game, and has nothing to do with the intricacies of the (abstract) football being played on the pitch.

I thought about wrapping the Match class in a Runnable thread which could have taken care of the time, but that wasn’t part of the assignment: time of goals is entered manually.

I used a Chain of Responsibility pattern to organize the different commands implementation.
——

## MISC

* I added indicators upon successful start, end, and goal commands. I thought providing positive feedback added to the usability of the system.

* When the same player scores multiple goals, I took the liberty to arrange its scoresheet a bit like they do on matchday reports.  ex: West Germany 3 (Haller 2' 21', Muller 12')

* Included are some JUnit4 unit tests.

* Project is also available at Github: https://github.com/jsbournival/expedia-football



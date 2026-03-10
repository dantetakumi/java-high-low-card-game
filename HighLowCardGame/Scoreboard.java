/**
 * Scoreboard.java
 * Partners: (none)
 *
 * Stores and prints the current scores and streak for the game.
 * This keeps scoring logic separate from the Game class.
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class Scoreboard
{
    private int playerScore;    //LO1 Concept Explanation
    private int computerScore;  //LO1 Concept Explanation
    private int streak;         //LO1 Concept Explanation
    
    /**
     * Constructs a Scoreboard with all values starting at 0.
     */
    public Scoreboard()
    {
        playerScore = 0;
        computerScore = 0;
        streak = 0;
    }

    /**
     * Resets the player's streak to 0.
     */
    public void resetStreak()
    {
        streak = 0;
    }

    /**
     * Adds a point to the player score and increases streak.
     */
    public void addPlayerPoint()
    {
        playerScore++;
        streak++;
    }

    /**
     * Adds a point to the computer score.
     */
    public void addComputerPoint()
    {
        computerScore++;
    }

    /**
     * Returns the player's score.
     *
     * @return playerScore
     */
    public int getPlayerScore()
    {
        return playerScore;
    }

    /**
     * Returns the computer's score.
     *
     * @return computerScore
     */
    public int getComputerScore()
    {
        return computerScore;
    }

    /**
     * Returns the player's streak.
     *
     * @return streak
     */
    public int getStreak()
    {
        return streak;
    }

    /**
     * Prints the scoreboard to the console.
     */
    public void print()
    {
        System.out.println("\n--- SCOREBOARD ---");
        System.out.println("Player Score:   " + playerScore);
        System.out.println("Computer Score: " + computerScore);
        System.out.println("Streak:         " + streak);
        System.out.println("------------------\n");
    }
}
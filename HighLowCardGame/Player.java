/**
 * Player.java
 * Partners: (none)
 *
 * Superclass for all players (human/computer) in the game.
 * Provides shared data (like name) and a method that subclasses override
 * to provide guesses (polymorphism).
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class Player
{
    private String name; 

    /**
     * Constructs a Player with a name
     * 
     * @param the player's display name
     */
    public Player(String name)
    {
        this.name = name;
    }

    /**
     * Returns the player's name
     * 
     * @return player name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets a guess from the player.
     * Subclasses override this method to behave differently 
     * 
     * @param currentCard the current card shown to the player
     * @param input a Scanner (used by HumanPlayer; ComputerPlayer ignores it)
     * @return "H", "L", or "Q"
     */
    public String getGuess(Card currentCard, java.util.Scanner input)
    {
        // Default behavior (shouldn't be used in gameplay directly)
        return "Q";
    }
}
import java.util.Scanner;

/**
 * HumanPlayer.java
 * Partners: (none)
 *
 * A Player that reads guesses from the keyboard using Scanner.
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class HumanPlayer extends Player
{
    /**
     * Constructs a HumanPlayer using the Player constructor
     * 
     * @param name the player's name
     */
    public HumanPlayer(String name)
    {
        super(name);
    }

    /**
     * Reads a guess from the user
     * 
     * @param currentCard the current card being shown
     * @param input Scanner to read keyboard input
     * @return the player's guess ("H", "L", or "Q")
     */
    @Override
    public String getGuess(Card currentCard, Scanner input)
    {
        System.out.print("\nEnter your guess (H/L/Q): ");
        String guess = input.nextLine().toUpperCase();      // LO 6 Concept EX
        return guess;
    }
}
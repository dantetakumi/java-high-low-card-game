import java.util.Random;
import java.util.Scanner;

/**
 * ComputerPlayer.java
 * Partners: (none)
 *
 * A Player that generates guesses automatically (H or L).
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class ComputerPlayer extends Player
{
    private Random rng = new Random(); 

    /**
     * Constructs a ComputerPlayer using the Player constructor
     * 
     * @param name the computer player's name
     */
    public ComputerPlayer(String name)
    {
        super(name);
    }

    /**
     * Generates a automated computer guess
     * 
     * @param currentCard the current card shown (not used in this simple strategy)
     * @param input Scanner (ignored for the computer)
     * @return "H" or "L"
     */
    @Override
    public String getGuess(Card currentCard, Scanner input)
    {
        int r = rng.nextInt(2); 
        if (r == 0) return "H"; 
        return "L";
    }
}
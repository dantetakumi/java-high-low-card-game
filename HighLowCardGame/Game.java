import java.util.Scanner;

/**
 * Game.java
 * Partners: (none)
 *
 * Controls the overall flow of High-Low Showdown:
 * - sets up the deck and players
 * - runs the main game loop
 * - checks guesses and updates the scoreboard
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class Game
{
    private Deck deck;              
    private Player human;           
    private Player computer;        
    private Scoreboard scoreboard;  
    private Scanner input;          

    /**
     * Constructs the game and initializes needed objects.
     */
    public Game()
    {
        input = new Scanner(System.in);     
        deck = new Deck();                  
        deck.shuffle();                            // LO2
        human = new HumanPlayer("Player");         // LO9
        computer = new ComputerPlayer("Computer"); // LO9
        scoreboard = new Scoreboard();      
    }

    /**
     * Runs the full game until the player quits or the deck runs out.
     */
    public void play()
    {
        // Draw starting card
        Card current = deck.drawCard(); // LO2

        // Title / instructions
        System.out.println("\n=============================");
        System.out.println("      HIGH–LOW SHOWDOWN");
        System.out.println("=============================\n");
        System.out.println("Rules: Guess if the next card will be Higher or Lower.");
        System.out.println("Type H, L, or Q to quit.\n");

        // Main gameplay loop
        while (deck.hasNext()) // LO5 Concept EX (While)
        {
            System.out.println("Current card: ");
            System.out.println(" -->   " + current);
            // LO9 polymorphism: human is a Player reference calling HumanPlayer override
            String playerGuess = human.getGuess(current, input); 
            
            // Quit choice
            if (playerGuess.equals("Q")) // LO7 Concept EX
            {
                System.out.println("\nYou quit the game.");
                break;
            }

            // Input validation
            if (!playerGuess.equals("H") && !playerGuess.equals("L")) // LO7
            {
                System.out.println("Invalid input. Please enter H, L, or Q.\n");
                continue;
            }

            // Computer guess (polymorphism)
            String computerGuess = computer.getGuess(current, input); // LO9

            // Draw next card
            Card next = deck.drawCard(); // LO2
            System.out.println("\nNext card:    ");
            System.out.println(" -->   " + next);

            // Evaluate player result
            boolean playerCorrect = isCorrect(playerGuess, current, next); 
            if (playerCorrect)      //LO 7 Concept EX
            {
                scoreboard.addPlayerPoint(); 
                System.out.println("\nCORRECT!!! (+1)");
            }
            else
            {
                scoreboard.resetStreak(); 
                System.out.println("WRONG / TIE!!!");
            }

            // Evaluate computer result
            boolean computerCorrect = isCorrect(computerGuess, current, next);
            if (computerCorrect)
            {
                scoreboard.addComputerPoint();
            }

            System.out.println("Computer guessed: " + computerGuess +
                               (computerCorrect ? " (correct)" : " (wrong/tie)"));

            current = next;
            scoreboard.print(); // LO2
        }

        if (!deck.hasNext())
        {
            System.out.println("No more cards left in the deck!");
        }

        System.out.println("\nFINAL RESULTS");
        System.out.println("Player Score:   " + scoreboard.getPlayerScore());
        System.out.println("Computer Score: " + scoreboard.getComputerScore());
        System.out.println("Thanks for playing!");

        input.close();
    }

    /**
     * Determines whether a guess is correct by comparing the next card
     * to the current card.
     *
     * @param guess the guess ("H" or "L")
     * @param current the current card
     * @param next the next card
     * @return true if the guess is correct, false otherwise
     */
    private boolean isCorrect(String guess, Card current, Card next)   //LO3 Concept Explanation
    {
        int c = current.getValue(); // LO2
        int n = next.getValue();    // LO2

        if (guess.equals("H"))      //LO7: chained if/else if/else controls which comparison happens
        {
            return n > c;
        }
        else // guess == "L"
        {
            return n < c;
        }
    }
}
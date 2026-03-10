import java.util.Random;

/**
 * Deck.java
 * Partners: (none)
 *
 * Manages a standard 52-card deck using a single-dimensional array.
 * Supports building the deck, shuffling, and drawing cards one at a time.
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class Deck {
    // Array to store all cards in the deck
    private Card[] cards;          // LO4 Concept EX 
    
    // Keeps track of the next card to be drawn
    private int topIndex;
    
    // Random object used for shuffling the deck
    private Random rng = new Random();
    
    /**
     * Default constructor
     * Constructs a new Deck, builds a full deck of cards, and shuffles it
     */
    public Deck() {
        buildDeck(); // creates the 52 card deck
        shuffle(); // randomizes the order
    }
    
    /**
     * Builds a standard 52 card deck by combining ranks and suits
     */
    private void buildDeck() {
        // Suits in a standard deck
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        
        // Ranks in a standard deck
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        
        // Numertic values used for comparisons in the game
        int[] values   = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        
        // Creates an array for all 52 cards
        cards = new Card[52];
        int index = 0;
        
        // Nested loops create every combination of suit and rank
        // LO5 Concept EX (FOR)
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                
                // Create a new Card and store it in the array
                cards[index] = new Card(ranks[r], suits[s], values[r]);
                index++;
            }
        }
        // Reset the index to the top of the deck
        topIndex = 0;
    }

    /**
     * Shuffles the deck using a standard shuffle algorithm
     */
    public void shuffle() {
        
        // Loop backwards through the array
        for (int i = cards.length - 1; i > 0; i--) {
            
            // Generates a random index
            int j = rng.nextInt(i + 1);
            
            // Swap cards at positions i and j
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        // Reset drawing position after shuffle
        topIndex = 0;
    }
    
    /**
     * Checks whether there are sitll cards left in the deck
     * 
     * @return true if there are cards remaining, false otherwise
     */
    public boolean hasNext() {
        return topIndex < cards.length;
    }
    
    /**
     * Draws the next card from the deck
     * 
     * @return the next Card, or null if the deck is empty 
     */
    public Card drawCard() {
        
        // If no cards remain, return null
        if (!hasNext()) return null;
        
        // Get the current card and move the index forward
        Card c = cards[topIndex];
        topIndex++;
        return c;
    }
}
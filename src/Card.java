
/**
 * Card.java
 * Partners: (none)
 *
 * Represents a single playing card with a rank, suit, and numeric value
 * used for comparisons in the High-Low game.
 *
 * @author Dante Burrellmedley
 * @version 12/19/25
 */
public class Card {
    // INSTANCE VARIABLES
    private String rank; // rank of card
    private String suit; // suit of card
    private int value; // Numerica value used for comparing cards
    
    //CONSTRUCTOR
    /**
     * Constructs a Card with a given rank, suit, and value
     * 
     * @param rank the rank of the card
     * @param suit the suit of the card
     * @param value the numeric value used for comparisons
     */
    public Card(String rank, String suit, int value) {
        // Initialize instance variables
        this.rank = rank;
        this.suit = suit;
        this.value = value;
    }

    // ACCESSOR
    /**
     * Returns the numeric value of the card for comparison
     * 
     * @return the card's value
     */
    public int getValue() {
        return value;
    }
    
    //OTHER METHOD:
    /**
     * Returns a readable String representation of the card
     * 
     * @return a String describing the card
     */
    public String toString() {
        return rank + " of " + suit + " (value " + value + ")";
    }
}
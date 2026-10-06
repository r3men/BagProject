import java.util.*;

/**
 * Child of the GenericCoin class, inheriting variables like sideUp and basic methods such as toss() & getSideUp(), but it also implements coin values and types with the addition of methods to go along with them.
 */

public class Coin extends GenericCoin {

    private double value;
    private String type;

    /**
     * Assumes a coin simulating a penny if no parameters are given.
     */
    public Coin() {
        value = 0.01;
        type = "Penny";
    }

    /**
     * Initialize a coin given two parameters.
     * @param v The value of the coin (0.05, 0.10, etc) as a double.
     * @param t The type of coin (Penny, Nickel, etc) as a String.
     */
    public Coin(double v, String t) {
        value = v;
        type = t;
    }

    /**
     * Retrieves the current value of a coin.
     * @return The current value of a given coin.
     */
    public double getValue() {
        return value;
    }

    /**
     * Retrieves the current type of a coin.
     * @return The current type of a given coin.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for users to change the value of a given coin.
     * @param v The new value that the user would like to change the old value to.
     */
    public void setValue(double v) {
        value = v;
    }

    /**
     * Setter for users to change the type of a given coin.
     * @param t The new type of coin that the user would like to change the old type to.
     */
    public void setType(String t) {
        type = t;
    }

    /**
     * Constructs a formatted string representation of the coin.
     * @return A formatted string containing the type, value, and current side up of a given coin.
     */
    public String toString() {
        return type + " | $" + String.format("%.2f", value) + " | " + getSideUp(); // use string.format for better readability for testing dollar coin value
    }

    // Overrided coin equals method so that .contains works as intended
    public boolean equals(Object o) {
        // Checks if both references point to the same exact object
        if (this == o) {
            return true;
        }
        // Checks if the other object is null or a different class
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        // Allows for field comparison
        Coin coinObject = (Coin) o;
        // Two coins are equal if they share the same value and type
        return value == coinObject.value && Objects.equals(type, coinObject.type);
    }

}
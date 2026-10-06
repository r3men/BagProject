/**
 * A coin class that implements basic features of a standard coin identifying the side currently facing up (heads or tails).
 */

public class GenericCoin implements CoinInterface {

    private String sideUp;

    /**
     * Constructs a coin with a default up position of heads.
     */
    public GenericCoin() {
        sideUp = "Heads";
    }

    /**
     * Simulates a coin toss that results in the current side of a given coin being changed to heads or tails.
     */
    public void toss() {
        // Make sure coins have the same chance of landing heads or tails
        if (Math.random() < 0.5) {
            sideUp = "Heads";
        }
        else {
            sideUp = "Tails";
        }
    }

    /**
     * Retrieves the current side facing up of a coin.
     * @return The current side facing up of a given coin.
     */
    public String getSideUp() {
        return sideUp;
    }

}
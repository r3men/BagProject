public class Client {
    public static void main(String[] args) {
        BagInterface<Coin> coinBag = new ResizableArrayBag<>();
        // Testing interface methods

        // Adding a lot of coins
        coinBag.add(new Coin());
        coinBag.add(new Coin(0.05, "Nickel"));
        coinBag.add(new Coin(0.05, "Nickel"));
        coinBag.add(new Coin(1.00, "Dollar Coin"));
        coinBag.add(new Coin(1.00, "Dollar Coin"));
        coinBag.add(new Coin(1.00, "Dollar Coin"));
        coinBag.add(new Coin(0.10, "Dime"));
        coinBag.add(new Coin(0.10, "Dime"));
        coinBag.add(new Coin(0.10, "Dime"));
        coinBag.add(new Coin(0.10, "Dime"));
        coinBag.add(new Coin(0.25, "Quarter"));
        coinBag.add(new Coin(0.25, "Quarter"));

        System.out.println("Showing array before first removal:");
        Object[] tempArray = coinBag.toArray();
        for (Object coin : tempArray) {
            System.out.println(coin);
        }

        // Print bag size before first removal
        System.out.println("\nThe current size of the coin bag is " + coinBag.getCurrentSize() + ".");

        coinBag.remove();

        // Temporary array to show array after first removal and before second removal
        System.out.println("\nShowing array after first removal and before second removal:");
        Object[] tempArray2 = coinBag.toArray();
        for (Object coin : tempArray2) {
            System.out.println(coin);
        }
        // Print bag size after first removal
        System.out.println("\nThe current size of the coin bag is " + coinBag.getCurrentSize() + ".");
        
        // Initialize quarter to test if removing a coin works properly
        Coin testQuarter = new Coin(0.25, "Quarter");
        
        coinBag.remove(testQuarter);

        // Temporary array to show second removal success
        System.out.println("\nShowing array after second removal:");
        Object[] tempArray3 = coinBag.toArray();
        for (Object coin : tempArray3) {
            System.out.println(coin);
        }

        // Print bag size after second removal
        System.out.println("\nThe current size of the coin bag is " + coinBag.getCurrentSize() + ".");

        Coin testNickel = new Coin(0.05, "Nickel");

        if (coinBag.contains(testNickel)) { 
            System.out.println("\nThe coin bag does contain a nickel!");
        }
        else {
            System.out.println("\nThe coin bag does not contain a nickel.");
        }

        // Scenarios & Probability Calculations
        // Declare all test coins needed
        Coin dime = new Coin(0.10, "Dime");
        Coin nickel = new Coin(0.05, "Nickel");
        Coin penny = new Coin();
        Coin dollarCoin = new Coin(1.00, "Dollar Coin");

        // Scenario 1: Probability of picking a dime, then a nickel, with no replacement of coins.
        double pDime1 = (double) coinBag.getFrequencyOf(dime) / coinBag.getCurrentSize();
        double pNickel1 = (double) coinBag.getFrequencyOf(nickel) / (coinBag.getCurrentSize() - 1);
        double pBoth1 = pDime1 * pNickel1;
        
        // Scenario 2: Probability of picking two dollar coins, with putting one back after the first.
        double pDollarCoin1 = (double) coinBag.getFrequencyOf(dollarCoin) / coinBag.getCurrentSize();
        double pBoth2 = pDollarCoin1 * pDollarCoin1;

        // Scenario 3: Probability of picking a dollar coin, and then a penny, with no replacement of coins.
        double pDollarCoin2 = (double) coinBag.getFrequencyOf(dollarCoin) / coinBag.getCurrentSize();
        double pPenny1 = (double) coinBag.getFrequencyOf(penny) / (coinBag.getCurrentSize() - 1);
        double pBoth3 = pDollarCoin2 * pPenny1;

        // Scenario 4: Probability of picking a dime, a nickel, and then a penny with no replacement of coins.
        double pDime2 = (double) coinBag.getFrequencyOf(dime) / coinBag.getCurrentSize();
        double pNickel2 = (double) coinBag.getFrequencyOf(nickel) / (coinBag.getCurrentSize() - 1);
        double pPenny2 = (double) coinBag.getFrequencyOf(penny) / (coinBag.getCurrentSize() - 2);
        double pBoth4 = pDime2 * pNickel2 * pPenny2;

        // Scenario 5: Probability of picking a dollar coin, dime, and then a nickel with no replacement of coins.
        double pDollarCoin3 = (double) coinBag.getFrequencyOf(dollarCoin) / coinBag.getCurrentSize();
        double pDime3 = (double) coinBag.getFrequencyOf(dime) / (coinBag.getCurrentSize() - 1);
        double pNickel3 = (double) coinBag.getFrequencyOf(nickel) / (coinBag.getCurrentSize() - 2);
        double pBoth5 = pDollarCoin3 * pDime3 * pNickel3;

        // Use String.format throughout printing for shortening long decimals

        // Print Scenario 1
        System.out.println("\nScenario 1: P(Dime then Nickel, no replacement)");
        System.out.println("P(Dime) = " + String.format("%.4f", pDime1));
        System.out.println("P(Nickel) = " + String.format("%.4f", pNickel1));
        System.out.println("P(both) = " + String.format("%.4f", pBoth1));

        // Print Scenario 2
        System.out.println("\nScenario 2: P(Dollar Coin twice, with replacement)");
        System.out.println("P(Dollar Coin) = " + String.format("%.4f", pDollarCoin1));
        System.out.println("P(Dollar Coin again) = " + String.format("%.4f", pDollarCoin1));
        System.out.println("P(both) = " + String.format("%.4f", pBoth2));

        // Print Scenario 3
        System.out.println("\nScenario 3: P(Dollar Coin then Penny, no replacement)");
        System.out.println("P(Dollar Coin) = " + String.format("%.4f", pDollarCoin2));
        System.out.println("P(Penny) = " + String.format("%.4f", pPenny1));
        System.out.println("P(both) = " + String.format("%.4f", pBoth3));

        // Print Scenario 4
        System.out.println("\nScenario 4: P(Dime then Nickel then Penny, no replacement)");
        System.out.println("P(Dime) = " + String.format("%.4f", pDime2));
        System.out.println("P(Nickel) = " + String.format("%.4f", pNickel2));
        System.out.println("P(Penny) = " + String.format("%.4f", pPenny2));
        System.out.println("P(all three) = " + String.format("%.4f", pBoth4));

        // Print Scenario 5
        System.out.println("\nScenario 5: P(Dollar Coin then Dime then Nickel, no replacement)");
        System.out.println("P(Dollar Coin) = " + String.format("%.4f", pDollarCoin3));
        System.out.println("P(Dime) = " + String.format("%.4f", pDime3));
        System.out.println("P(Nickel) = " + String.format("%.4f", pNickel3));
        System.out.println("P(all three) = " + String.format("%.4f", pBoth5));
    }

}

/* Test Program Output
Showing array before first removal:
Penny | $0.01 | Heads
Nickel | $0.05 | Heads
Nickel | $0.05 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Quarter | $0.25 | Heads
Quarter | $0.25 | Heads

The current size of the coin bag is 12.

Showing array after first removal and before second removal:
Penny | $0.01 | Heads
Nickel | $0.05 | Heads
Nickel | $0.05 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Quarter | $0.25 | Heads

The current size of the coin bag is 11.

Showing array after second removal:
Penny | $0.01 | Heads
Nickel | $0.05 | Heads
Nickel | $0.05 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dollar Coin | $1.00 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads
Dime | $0.10 | Heads

The current size of the coin bag is 10.

The coin bag does contain a nickel!

Scenario 1: P(Dime then Nickel, no replacement)
P(Dime) = 0.4000
P(Nickel) = 0.2222
P(both) = 0.0889

Scenario 2: P(Dollar Coin twice, with replacement)
P(Dollar Coin) = 0.3000
P(Dollar Coin again) = 0.3000
P(both) = 0.0900

Scenario 3: P(Dollar Coin then Penny, no replacement)
P(Dollar Coin) = 0.3000
P(Penny) = 0.1111
P(both) = 0.0333

Scenario 4: P(Dime then Nickel then Penny, no replacement)
P(Dime) = 0.4000
P(Nickel) = 0.2222
P(Penny) = 0.1250
P(all three) = 0.0111

Scenario 5: P(Dollar Coin then Dime then Nickel, no replacement)
P(Dollar Coin) = 0.3000
P(Dime) = 0.4444
P(Nickel) = 0.2500
P(all three) = 0.0333
*/

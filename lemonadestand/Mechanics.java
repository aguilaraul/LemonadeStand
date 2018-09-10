/**
 * @author  Raul Aguilar
 * @date    2018-08-29
 */

package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class Mechanics {

    /**
     * Sets number of players based on user Integer value input
     * Checks if number of player is not zero
     * If true, sets number of player to Integer value input
     * If false, asks user for a new Integer
     * Turns all Integers into their absolute values
     * Ignores all non-Integers by asking for a new number
     * @param in
     *  Uses Scanner to input Integer value
     * @return
     *  Integer value of players
     */
    public static int setNumberOfPlayers(Scanner in) {
        int numOfPlayers = 1;
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");

        while(true) {
            try {
                numOfPlayers = Integer.parseInt(in.next());
                numOfPlayers = Math.abs(numOfPlayers);

                while(numOfPlayers == 0 ) {
                    System.out.println("Can't accept that many number of players.");
                    System.out.println("Please enter a new number:");
                    numOfPlayers = Integer.parseInt(in.next());
                    numOfPlayers = Math.abs(numOfPlayers);
                }
                System.out.println();
                return numOfPlayers;

            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
    }

    /**
     * Determines chance of selling lemonade based off the weather
     * @param weather
     *  Byte weather token to determine condition
     * @param rand
     *  Random class to randomly select percentage of selling between bounds
     * @return
     *  Chance of selling lemonade as Double
     */
    public static double weather(byte weather, Random rand) {
        double chance;

        switch(weather) {
            case 0: // hot and dry
                System.out.println("The forecast today is hot and dry");
                chance = (double) rand.nextInt(22+1) + 78;
                break;
            case 1: // sunny
                System.out.println("The forecast today is sunny");
                chance = (double) rand.nextInt(43+1) + 34;
                break;
            case 2: // cloudy
                System.out.println("The forecast today is cloudy");
                chance = (double) rand.nextInt(33+1);
                break;
            default:
                chance = 1;
                break;
        }
        return chance;
    }

    /**
     * Sets cost of making lemonade for the day
     * Checks the day against arguments and sets the cost accordingly
     * @param day
     *  Byte representing the day to determine cost
     * @return
     *  Double representing cost of making a cup of lemonade
     */
    public static double setCost(byte day) {
        double cost;

        if(day < 3) {
            cost = 0.02;
            System.out.println("On day " + day + ", the cost of lemonade is $.02\n" );
        } else if (day == 3) {
            cost = 0.04;
            System.out.println("On day " + day + ", the cost of lemonade is $.04" );
            System.out.println("(Your mom quit giving you free sugar.)\n" );
        } else if (day > 3 && day < 7) {
            cost = 0.04;
            System.out.println("On day " + day + ", the cost of lemonade is $.04\n" );
        } else if (day == 7) {
            cost = 0.05;
            System.out.println("On day " + day + ", the cost of lemonade is $.05" );
            System.out.println("(The price of lemonade mix just went up)\n" );
        } else {
            cost = 0.05;
            System.out.println("On day " + day + ", the cost of lemonade is $.05\n" );
        }

        return cost;
    }

    /**
     * Verifies that number of cups set by user is acceptable
     * Checks if user can afford to make number of cups
     * If true, sets the number of cups to make
     * If false, asks for a new number
     * Ignores all non-Integer by asking for new number
     * Converts inputs to their absolute value
     * @param in
     *  Uses Scanner to input Integer value
     * @param cost
     *  Cost of making one cup of lemonade
     * @param assets
     *  Current available funds
     * @return
     *  Integer value of number of cups
     */
    public static int setCups(Scanner in, double cost, double assets) {
        int cups = 0;
        System.out.println("How many glasses of lemonade do you\n"
                + "wish to make?");
        while (true) {
            try {
                cups = Integer.parseInt(in.next());
                cups = Math.abs(cups);
                while(!( (cups*cost) < assets) ) {
                    System.out.println("Sorry, you can't make that many signs.");
                    System.out.println("Try a new number.");
                    cups = Integer.parseInt(in.next());
                    cups = Math.abs(cups);
                }

                System.out.println();
                return cups;

            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }

    }

    /**
     * Verifies number for signs to make by user is acceptable
     * Checks if user can afford to make enough signs
     * If true, then sets number of signs to make
     * If false, asks user for a new number
     * Ignores all non-Double values by asking for new Double
     * Coverts doubles to their absolute values
     * @param in
     *  Uses Scanner to input double value
     * @param sc
     *  Cost of signs
     * @param assets
     *  Current available funds
     * @return
     *  Integer value of number of signs
     */
    public static double setSigns(Scanner in, double sc, double assets) {
        double signs = 0;
        boolean tryAgain = false;
        System.out.println("How many signs (15 cents\n"
                + "each) do you want to make?");
        while (true) {
            try {
                signs = Double.parseDouble(in.next());
                signs = Math.abs(signs);
                while(!( (signs*sc) < assets) ) {
                    System.out.println("Sorry, you can't make that many signs.");
                    System.out.println("Try a new number.");
                    signs = Double.parseDouble(in.next());
                    signs = Math.abs(signs);
                }

                System.out.println();
                return signs;

            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
    }

    /**
     * Verifies if price Double input by user is acceptable
     * Checks if price is greater or equal to one hundred
     * If true, asks for a new number
     * If false, sets price
     * Ignores all non-Doubles by asking for new Double
     * Turns all Doubles into their absolute values
     * @param in
     *  Uses Scanner to input price double value
     * @return
     *  Verified double value to set price
     */
    public static double setPrice(Scanner in) {
        double price = 0;
        System.out.println("What price (in cents) do you wish to\n"
                + "charge for lemonade?");
        while (true) {
            try {
                price = Double.parseDouble(in.next());
                price = Math.abs(price);
                while(price >= 100) {
                    System.out.println("Sorry, you can't set a price higher than $1.");
                    System.out.println("Try a new number.");
                    price = Double.parseDouble(in.next());
                    price = Math.abs(price);
                }

                System.out.println();
                return price;

            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
    }

    /**
     * Asks if the user wants to change any of their inputs
     * Any answer other than 'yes' or 'y' will reset day
     * Else continue
     * @param in
     *  Uses Scanner to input user answer String
     * @return
     *  True or false depending on user input
     */
    public static boolean askToChangeAnything(Scanner in) {
        System.out.println("Do you want to change anything? Y/N");
        String ans = "e";
        if( in.hasNext() ) {
            ans = in.next();
        }
        if(!(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) ) {
            System.out.println();
            return false;
        } else {
            System.out.println();
            return true;
        }
    }

    /**
     * Calculates the chance of selling lemonade by taking into account signs made,
     * and price of lemonade.
     * @param chance
     *  Starting chance Double value is set randomly depending on type of weather
     * @param signs
     *  Number of signs made Double value
     * @param price
     *  Price of lemonade Double value
     * @return
     *  Double chance value
     */
    public static double calculateChanceOfSelling(double chance, double signs, double price) {

        chance += (chance*(signs/100));
        chance += chance/price;
        chance = chance/100;

        return chance;
    }

    /**
     * Calculates number of cups sold by comparing chance of selling to a random value
     * If the chance of selling is greater than random number, then all cups made are sold
     * else, a percentage of cups made are sold based on the chance
     * @param rand
     * Random class sets Double value to d to compare against chance of selling
     * @param chance
     * Chance of selling lemonade Double value
     * @param cupsSold
     * Number of cups sold Double value
     * @param cups
     * Number of cups made Double value
     * @return
     * Double value representing number of cups sold
     */
    public static double cupsSold(Random rand, double chance, double cupsSold, double cups) {
        float d = rand.nextInt(101); // rng to use against chance
        d = d/100; // rng turned into percentage
        // rng vs chance
        if(d < chance) { cupsSold = cups; }
        else { cupsSold = Math.ceil(cups*chance); }

        return cupsSold;
    }
}
/**
 * @author  Raul Aguilar
 * @date    December 23, 2018
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Text text = new Text();

    private static final double SC = 0.15;

    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    private int numOfPlayers;
    private Stand[] s;
    private byte day = 1, weather;
    private double chance;
    private double cost;
    private double price;
    private double expense, totalExpense;
    private double cups, totalCupsMade;
    private double signs, totalSignsMade;
    private String answer;
    private boolean tryAgain;
    private double cupsSold, totalCupsSold;
    private double income, revenue;
    private double profit;
    private int id;
    private double assets;

    public void Game() {
        intro();
        // Process of one day
        do {
            weather = (byte) rand.nextInt(3); // Randomly choosing weather byte
            int currentStand = 0;

            while(currentStand < numOfPlayers) {

                // Deciding chance of selling lemonade based on weather
                text.border(); //text border
                weather();

                // Deciding the cost of the day
                setCost();

                // The Game
                do {
                    id = s[currentStand].getId();
                    assets = s[currentStand].getAssets();
                    expense = 0;
                    System.out.printf("%s \t %s %.2f%n", "Lemonade Stand " + id, "Assets", assets);

                    // Asking how many cups of lemonade to make
                    text.askHowManyCups();
                    setCups(cost, assets);
                    assets -= (cups*cost);

                    // Asking how many SIGNS to make
                    text.askHowManySigns();
                    setSigns(assets);

                    // Adding the cost of signs to the cost of making lemonade
                    // Subtracting expense of signs and lemonade from assets
                    expense = (cups*cost)+(signs*SC);

                    // Ask price of lemonade
                    text.askToSetPrice();
                    setPrice();

                    // Ask to change anything
                    text.askToChangeAnything();
                    tryAgain = changeAnything();

                } while(tryAgain);

                /* Selling the lemonade */
                calculateChanceOfSelling();
                cupsSold();
                setIncome();
                setProfit();

                assets = assets + getProfit();
                totalExpense += expense;

                s[currentStand].setAssets(assets);

                text.financeReport(id, getDay(), getCupsSold(), getPrice(), getIncome(), getCups(), getSigns(),
                        getExpense(), getProfit(), assets);

                currentStand++;
            } // end of current Stand
            day++;
        } while(day < 13); // end of day

        //text.endGameScreen(day, id, totalCupsMade, totalCupsSold, totalSignsMade, totalExpense, revenue);
    }

    /**
     * Prints out opening menus and asks how many players
     * will play
     */
    private void intro() {
        text.opening1();
        if(hasPlayedBefore()) {
            System.out.println();
            // How many players
            text.askHowManyPlayers();
            setNumberOfPlayers();
            instantiatePlayers();
        } else {
            System.out.println();
            // How many players
            text.askHowManyPlayers();
            setNumberOfPlayers();
            instantiatePlayers();
            text.playedBefore1();
            setDay();
            int currentStand = 0;
            while(currentStand < numOfPlayers) {
                boolean assetSet = false;
                id = s[currentStand].getId();
                System.out.println("PLAYER NO. " + id + ", HOW MUCH MONEY (ASSETS)");
                System.out.println("DID YOU HAVE? ");

                while(!assetSet) {
                    try {
                        assets = Double.parseDouble(in.next());
                        if (assets < 2) {
                            System.out.println("O.K. - WE'LL START YOU OUT WITH $2.00");
                            System.out.println();
                            assets = 2.00;
                            assetSet = true;
                        } else if (assets > 40) {
                            System.out.println("JUST TO BE FAIR, LET'S MAKE THAT $10.00");
                            System.out.println();
                            assets = 10.00;
                            assetSet = true;
                        } else {
                            assetSet = true;
                        }
                    } catch (NumberFormatException e) {
                        assetSet = false;
                        text.tryANewNumber();
                    }
                }

                s[currentStand].setAssets(assets);
                currentStand++;
            }
            System.out.println("...READY TO BEGIN? ");
            in.nextLine();
        }

        in.nextLine();
        text.opening2();
        in.nextLine();
        text.opening3();
        in.nextLine();
    }

    /**
     * Boolean check to ask player if they have played before
     * @return true if 'yes' or 'y', anything else returns false
     */
    private boolean hasPlayedBefore() {
        answer = "";
        if( in.hasNext() ) {
            answer = in.next();
        }
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }

    /**
     * Instantiates number of players and their stands
     */
    private void instantiatePlayers() {
        s = new Stand[numOfPlayers];
        for(int i = 0; i < numOfPlayers; i++){
            s[i] = new Stand(i+1);
        }
    }

    /**
     * Sets number of players based on user Integer value input
     * Checks if number of players is not zero
     * If true, sets number of players to Integer value input
     * If false, asks user for a new Integer
     * Turns all Integers into their absolute values
     * Ignores all non-Integers by asking for a new number
     */
    private void setNumberOfPlayers() {
        boolean playersSet = false;

        while(!playersSet) {
            try {
                numOfPlayers = Integer.parseInt(in.next());
                if(numOfPlayers > 0 && numOfPlayers < 30) {
                    playersSet = true;
                } else {
                    text.cantAcceptThatMany();
                }
                System.out.println();
            } catch (NumberFormatException ignore) {
                text.tryANewNumber();
            }
        }
    }

    /**
     * Sets the day at the start of the game after asking
     * players if they have played before
     * Checks if the day is in between 0 and 100
     */
    private void setDay() {
        boolean daySet = false;

        while(!daySet) {
            try {
                day = Byte.parseByte(in.next());
                if(day > 1 && day < 99) {
                    day++;
                    System.out.println("OKAY - WE'LL START WITH DAY NO. " + day);
                    daySet = true;
                }
                System.out.println();
            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }

    }

    /**
     * Determines chance of selling lemonade based off the weather
     */
    private void weather() {
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
    }

    /**
     * Sets cost of making lemonade for the day
     * Checks the day against arguments and sets the cost accordingly
     */
    private void setCost() {
        if(day < 3) {
            cost = 0.02;
            System.out.println("On day " + day + ", the cost of lemonade is $.02\n" );
        } else if (day == 3) {
            cost = 0.04;
            System.out.println("On day " + day + ", the cost of lemonade is $.04" );
            System.out.println("(Your mom quit giving you free sugar.)\n" );
        } else if (day < 7) {
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
    }

    /**
     * Sets number of cups
     * @param cost cost lemonade set by the day
     * @param assets available assets of the stand
     */
    private void setCups(double cost, double assets) {
        boolean cupsSet = false;

        while(!cupsSet) {
            try {
                cups = Double.parseDouble(in.next());
                if (cups > 0 && cups < 1000) {
                    if( (cups*cost) > assets) {
                        System.out.printf("THINK AGAIN!!! YOU HAVE ONLY $%.2f", assets);
                        System.out.println();
                        System.out.printf("IN CASH AND TO MAKE %.0f GLASSES OF", cups);
                        System.out.println();
                        System.out.printf("LEMONADE YOU NEED $%.2f IN CASH.", (cost*cups));
                        System.out.println();
                    } else {
                        totalCupsMade += cups;
                        cupsSet = true;
                    }
                } else {
                    System.out.println("COME ON, LET'S BE REASONABLE NOW!!!");
                    System.out.println("TRY AGAIN");
                }
            } catch (NumberFormatException ignore) {
                text.tryANewNumber();
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
     * @param assets Current available funds
     */
    private void setSigns(double assets) {
        boolean signsSet = false;

        while(!signsSet) {
            try {
                signs = Double.parseDouble(in.next());
                if(signs >= 0 && signs < 50) {
                    if(signs*SC > assets) {
                        System.out.printf("THINK AGAIN, YOU HAVE ONLY $%.2f", assets);
                        System.out.println();
                        System.out.println("IN CASH LEFT AFTER MAKING YOUR LEMONADE.");
                    } else {
                        totalSignsMade += signs;
                        signsSet = true;
                    }
                } else {
                    System.out.println("COME ON, BE REASONABLE!!! TRY AGAIN.");
                }
            } catch (NumberFormatException ignore) {
                text.tryANewNumber();
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
     */
    private void setPrice() {
        boolean priceSet = false;

        while(!priceSet) {
            try {
                price = Double.parseDouble(in.next());
                price = Math.abs(price);
                if(!(price >= 100)) {
                    priceSet = true;
                } else {
                    System.out.println("COME ON, BE REASONABLE!!! TRY AGAIN.");
                }
                System.out.println();
            } catch (NumberFormatException ignore) {
                text.tryANewNumber();
            }
        }
    }

    /**
     * Asks if the user wants to change any of their inputs
     * Any answer other than 'yes' or 'y' will reset day
     * Else continue
     * @return false if 'yes' or 'y', else true
     */
    private boolean changeAnything() {
        answer = "";
        if( in.hasNext() ) {
            answer = in.next();
        }
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }

    /**
     * Calculates the chance of selling lemonade by taking into account signs made,
     * and price of lemonade.
     */
    private void calculateChanceOfSelling() {
        chance += (chance*(signs/100));
        chance += chance/price;
        chance = chance/100;
    }

    /**
     * Calculates number of cups sold by comparing chance of selling to a random value
     * If the chance of selling is greater than random number, then all cups made are sold
     * else, a percentage of cups made are sold based on the chance
     */
    private void cupsSold() {
        float d = rand.nextInt(101); // rng to use against chance
        d = d/100; // rng turned into percentage
        // rng vs chance
        if(d < chance) { cupsSold = cups; }
        else { cupsSold = Math.ceil(cups*chance); }
        totalCupsSold += cupsSold;
    }

    private void setIncome() {
        income = (cupsSold * price) / 100;
        revenue += income;
    }

    private void setProfit() {
        profit = income-expense;
    }

    /**
     * Getter for the current day
     * @return Byte of current day
     */
    public byte getDay() {
        return day;
    }

    /**
     * Getter for number of cups sold
     * @return Double of cups sold
     */
    public double getCupsSold() {
        return cupsSold;
    }

    public double getPrice() {
        return price;
    }

    public double getIncome() {
        return income;
    }

    public double getCups() {
        return cups;
    }

    public double getSigns() {
        return signs;
    }

    public double getExpense() {
        return expense;
    }

    public double getProfit() {
        return profit;
    }

    public double getChance() {
        return chance;
    }
}
/*
 * @author  Raul Aguilar
 * @date    December 25, 2018
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Text text = new Text();

    private static final float SC = 0.15f;

    private Scanner in = new Scanner(System.in);
    private Random rand = new Random();
    private Stand[] s;
    private byte id;
    private float assets;
    private byte numOfPlayers;
    private byte day = 1, weather;
    private double chance;
    private float cost;
    private float price;
    private float expense;
    private float income;
    private float profit;
    private short cups;
    private short cupsSold;
    private byte signs;
    private String answer;
    private boolean tryAgain;


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
                    System.out.println();
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
     * Prints out opening menus and asks how many players will play
     */
    private void intro() {
        text.titlePage();
        if(hasPlayedBefore()) {
            System.out.println();
            // How many players
            text.askHowManyPlayers();
            setNumberOfPlayers();
            instantiatePlayers();
        } else {
            System.out.println();
            // Ask how many players
            text.askHowManyPlayers();
            setNumberOfPlayers();
            instantiatePlayers();

            text.continueOldGame();
            setDay();

            int currentStand = 0;
            while(currentStand < numOfPlayers) {
                boolean assetSet = false;
                id = s[currentStand].getId();
                System.out.println("PLAYER NO. " + id + ", HOW MUCH MONEY (ASSETS)");
                System.out.println("DID YOU HAVE? ");

                while(!assetSet) {
                    try {
                        assets = Float.parseFloat(in.next());
                        if (assets < 2) {
                            System.out.println("O.K. - WE'LL START YOU OUT WITH $2.00");
                            System.out.println();
                            assets = 2.00f;
                            assetSet = true;
                        } else if (assets > 40) {
                            System.out.println("JUST TO BE FAIR, LET'S MAKE THAT $10.00");
                            System.out.println();
                            assets = 10.00f;
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
        text.newBusiness();
        in.nextLine();
        text.newBusiness2();
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
            s[i] = new Stand((byte) (i+1));
        }
    }

    /**
     * Sets number of players using a user input byte
     * Checks if number is between 0 and 30
     * if true, the value is acceptable
     * if false, user is asked to enter a new number
     */
    private void setNumberOfPlayers() {
        boolean playersSet = false;

        while(!playersSet) {
            try {
                numOfPlayers = Byte.parseByte(in.next());
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
                text.tryANewNumber();
            }
        }
    }

    /**
     * Determines chance of selling lemonade based off the weather
     */
    private void weather() {
        switch(weather) {
            case 0: // hot and dry
                text.forecastToday("HOT AND DRY");
                chance = (double) rand.nextInt(22+1) + 78;
                break;
            case 1: // sunny
                text.forecastToday("SUNNY");
                chance = (double) rand.nextInt(43+1) + 34;
                break;
            case 2: // cloudy
                text.forecastToday("CLOUDY");
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
        if ( day <= 2) {
            cost = 0.02f;
            text.costOfLemonade(day, cost);
        }
        if( day > 2 ) {
            cost = 0.04f;
            text.costOfLemonade(day, cost);
            if (day == 3) {
                System.out.println("(YOUR MOM QUIT GIVING YOU FREE SUGAR)" );
            }
        }
        if ( day > 6) {
            cost = 0.05f;
            text.costOfLemonade(day, cost);
            if( day == 7 ) {
                System.out.println("(THE PRICE OF LEMONADE MIX JUST WENT UP)" );
            }
        }
    }

    /**
     * Sets number of cups
     * @param cost cost lemonade set by the day
     * @param assets available assets of the stand
     */
    private void setCups(float cost, float assets) {
        boolean cupsSet = false;

        while(!cupsSet) {
            try {
                cups = Short.parseShort(in.next());
                if (cups > 0 && cups < 1000) {
                    if( (cups*cost) > assets) {
                        System.out.printf("THINK AGAIN!!! YOU HAVE ONLY $%.2f", assets);
                        System.out.println();
                        System.out.printf("IN CASH AND TO MAKE %d GLASSES OF", cups);
                        System.out.println();
                        System.out.printf("LEMONADE YOU NEED $%.2f IN CASH.", (cost*cups));
                        System.out.println();
                    } else {
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
     * Sets number of signs
     * Checks if user input byte is valid
     * Checks if value is greater or equal to 0 and less than 50
     * if true, checks if user can afford to make # of signs
     *  if true, number of signs is set
     * if false, asks user to enter a new number
     * @param assets current assets available to make signs
     */
    private void setSigns(float assets) {
        boolean signsSet = false;

        while(!signsSet) {
            try {
                signs = Byte.parseByte(in.next());
                if(signs >= 0 && signs < 50) {
                    if(signs*SC > assets) {
                        System.out.printf("THINK AGAIN, YOU HAVE ONLY $%.2f", assets);
                        System.out.println();
                        System.out.println("IN CASH LEFT AFTER MAKING YOUR LEMONADE.");
                    } else {
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
                price = Float.parseFloat(in.next());
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
        chance += (chance * (double) (signs/100));
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
        else { cupsSold = (short) Math.ceil(cups*chance); }
    }

    /**
     * Calculates and sets income
     * # of cups sold * price of lemonade / 100
     */
    private void setIncome() {
        income = (cupsSold * price) / 100;
    }

    /**
     * Sets profit
     */
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
     * @return Short number of cups sold
     */
    public short getCupsSold() {
        return cupsSold;
    }

    public float getPrice() {
        return price;
    }

    public float getIncome() {
        return income;
    }

    public short getCups() {
        return cups;
    }

    public byte getSigns() {
        return signs;
    }

    public float getExpense() {
        return expense;
    }

    public float getProfit() {
        return profit;
    }

    public double getChance() {
        return chance;
    }
}
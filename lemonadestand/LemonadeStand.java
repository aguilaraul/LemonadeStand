/**
 * @author  Raul Aguilar
 * @date    2018-08-29
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class LemonadeStand {

    public static double cupsMade(Scanner in, double cost, double assets) {
        int cups = 0;
        System.out.println("How many glasses of lemonade do you\n"
            + "wish to make?");
        while (true) {
            try {
                cups = Integer.parseInt(in.next());
                while ( (((cups*cost) > assets) || cups < 0) || cups == -0 ) {
                    System.out.println("Sorry, you can't make that many cups of lemonade.");
                    System.out.println("Try a new number.");
                    cups = Integer.parseInt(in.next());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
        System.out.println();
        return cups;
    }
    public static double signsMade(Scanner in, double sc, double assets) {
        byte signs = 0;
        System.out.println("How many signs (15 cents\n"
            + "each) do you want to make?");
        while (true) {
            try {
                signs = Byte.parseByte(in.next());
                while( (( (signs*sc) > assets) || signs < 0) || signs == -0  ) {
                    System.out.println("Sorry, you can't make that many signs.");
                    System.out.println("Try a new number.");
                    signs = Byte.parseByte(in.next());
                } // checking if player has enough assets to make signs
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
        System.out.println();
        return signs;
    }
    public static double setPrice(Scanner in) {
        double price = 0;
        System.out.println("What price (in cents) do you wish to\n"
            + "charge for lemonade?");
        while(true) {
            try {
                price = Double.parseDouble(in.next());
                if ( (price < 0 || price > 100) || price == -0 ) {
                    System.out.println("Sorry, you can't set that price.");
                    System.out.println("Try a new number.");
                    price = Double.parseDouble(in.next());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
        System.out.println();
        return price;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean tryAgain = false;
        byte day = 1 , weather;
        double chance, cost, cups, cupsSold, price, profit, income, expense, signs;
        double sc = 0.15;   // sign cost
        int numOfPlayers = 1;
        
        // Print out menus
        Menus.printMenu1();
        in.nextLine();
        // How many players
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");

        while(true) {
            try {
                numOfPlayers = Integer.parseInt(in.next());
                while(numOfPlayers < 0 || numOfPlayers == -0) {
                    System.out.println("Can't accept that many number of players.");
                    System.out.println("Please enter a new number:");
                    numOfPlayers = Integer.parseInt(in.next());
                }
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Try a new number.");
            }
        }
        in.nextLine();
        Menus.printMenu2();
        in.nextLine();
        Menus.printMenu3();
        in.nextLine();

        // Instantiating number of player
        Stand[] s = new Stand[numOfPlayers];
        for(int i = 0; i < numOfPlayers; i++){
            s[i] = new Stand(i+1);
        }
        for(Stand stands : s){ System.out.println(stands); }

        // Process of one day
        do {
            weather = (byte) rand.nextInt(3); // Randomly choosing weather byte
            int currentStand = 0;
            while(currentStand < numOfPlayers) {
                int id = s[currentStand].getId();
                double assets = s[currentStand].getAssets();
                System.out.println("________________________________________"); //text border
                // Deciding weather based on weather byte
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

                // Deciding the cost of the day
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
                
                // The Game
                do {
                    expense = 0;
                    System.out.printf("%s \t %s %.2f%n", "Lemonade Stand " + id,
                            "Assets", assets);

                    // Asking how many cups of lemonade to make
                    cups = cupsMade(in, cost, assets);

                    // Asking how many SIGNS to make
                    signs = signsMade(in, sc, assets);

                    // Adding the cost of signs to the cost of making lemonade
                    // Subtracting expense of signs and lemonade from assets
                    expense = (cups*cost)+(signs*sc);
                    s[currentStand].setAssets(assets - expense);

                    // Ask price of lemonade
                    price = setPrice(in);

                    // Ask to change anything
                    System.out.println("Do you want to change anything? Y/N");
                    String ans = "e";
                    if( in.hasNext() ) {
                        ans = in.next();
                    }
                    if(ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
                        s[currentStand].setAssets(assets+expense);
                        tryAgain = true;
                    } else { break; }

                } while(tryAgain);

                /* Selling the lemonade */
                // chance of selling
                chance += (chance*(signs/100));
                chance += chance/price;
                chance = chance/100;

                float d = rand.nextInt(101); // rng to use against chance
                d = d/100; // rng turned into percentage
                // rng vs chance
                if(d < chance) { cupsSold = cups; }
                else { cupsSold = Math.ceil(cups*chance); }

                income = (cupsSold * price) / 100;
                profit = income-expense;
                s[currentStand].setAssets(assets + profit);
                assets = s[currentStand].getAssets();
                Menus.financeReport(id, day, cupsSold, price, income, cups, signs, expense,
                        profit, assets);
                currentStand++;
            } // end of current Stand
            day++;
        } while(day < 13); // end of day
    }
}
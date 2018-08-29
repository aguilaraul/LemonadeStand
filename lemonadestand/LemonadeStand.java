/**
 * @author  Raul Aguilar
 * @date    2018-06-16
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

class Stand {
    int id;
    double assets;

    public Stand() {
        this.id = 0;
        assets = 2.00;
    }
    public Stand(int id) {
        this.id = id;
        assets = 2.00;
    }
    
    public void setId(int i) { id = i; }
    public void setAssets(double a) { assets = a;}

    public int getId() {
        return id;
    }
    public double getAssets() {
        return assets;
    }

    @Override
    public String toString(){
        return "Lemonade Stand " + id
                + "\nAssets " + assets;
    }
}

public class LemonadeStand {

    static void printMenu1() {
        System.out.println("HI! WELCOME TO LEMONSVILLE, CALIFORNIA!");
        System.out.println("IN THIS SMALL TOWN, YOU ARE IN CHARGE OF\n" +
            "RUNNING YOUR OWN LEMONADE STAND. YOU CAN\n" +
            "COMPETE WITH AS MANY OTHER PEOPLE AS YOU\n" +
            "WISH, BUT HOW MUCH PROFIT YOU MAKE IS UP\n" +
            "TO YOU (THE OTHER STANDS' SALES WILL NOT\n" +
            "AFFECT YOUR BUSINESS IN ANY WAY). IF YOU\n" +
            "MAKE THE MOST MONEY, YOU'RE THE WINNER!!") ;
        System.out.println("\t(HIT RETURN TO CONTINUE)");
    }
    static void printMenu2() {
        System.out.println("TO MANAGE YOUR LEMONADE STAND, YOU WILL\n"
            + "NEED TO MAKE THESE DECISIONS EVERY DAY:\n");
        System.out.println("1. HOW MANY GLASSES OF LEMONADE TO MAKE");
        System.out.printf("%40s%n", "(ONLY ONE BATCH IS MADE EACH MORNING)" );
        System.out.println("2. HOW MANY ADVERTISING SIGNS TO MAKE");
        System.out.printf("%38s%n", "(THE SIGNS COST FIFTEEN CENTS EACH)" );
        System.out.println("3. WHAT PRICE TO CHARGE FOR EACH GLASS\n" );
        System.out.println("YOU WILL BEGIN WITH $2.00 CASH (ASSETS).\n"
            + "BECAUSE YOUR MOTHER GAVE YOU SOME SUGAR,\n"
            + "YOUR COST TO MAKE LEMONADE IS TWO CENTS\n"
            + "A GLASS (THIS MAY CHANGE IN THE FUTURE)." );
        System.out.println("\t(HIT RETURN TO CONTINUE)");
    }
    static void printMenu3() {
        System.out.println("YOUR EXPENSE ARE THE SUM OF THE COST OF\n"
            + "THE LEMONADE AND THE COST OF THE SIGNS.\n" );
        System.out.println("YOUR PROFITS ARE THE DIFFERENCE BETWEEN\n"
            + "THE INCOME FROM THE SALES AND YOUR EXPENSES.\n" );
        System.out.println("THE NUMBER OF GLASSES YOU SELL EACH DAY\n"
            + "DEPENDS ON THE PRICE YOU CHARGE, AND ON\n"
            + "THE NUMBER OF ADVERTISING SIGNS YOU USE.\n" );
        System.out.println("KEEP TRACK OF YOUR ASSETS, BECAUSE YOU\n"
            + "CAN'T SPEND MORE MONEY THAN YOU HAVE!" );
        System.out.println("\t(HIT RETURN TO CONTINUE)");
    }
    public static void financeReport(int id, byte day, double cupsSold, double price, double income,
            double cups, byte signs, double expense, double profit, double assets)
    {
        System.out.println();
        System.out.println("________________________________________");
        System.out.println("$$ LEMONSVILLE DAILY FINANCIAL REPORT $$\n");
        System.out.printf("%6S %d %25S %d\n", "day", day, "stand", id);
        System.out.println();
        System.out.printf("%4.0f %S %n", cupsSold, "glasses sold");
        System.out.printf("$.%.0f %S %17S $%.2f \n", price, "per glass", "income", income);
        System.out.println();
        System.out.printf("%4.0f %S %n", cups, "glasses made");
        System.out.printf("%3d %11S %17S $%.2f\n", signs, "signs made", "expenses", expense);
        System.out.println();
        System.out.printf("%20S $%.2f\n", "Profit", profit);
        System.out.printf("%20S $%.2f\n", "Assets", assets);
    }

    public static double cupsMade(Scanner in, double cost, double assets) {
        int cups = 0;
        System.out.println("How many glasses of lemonade do you\n"
            + "wish to make?");
        while (true) {
            try {
                cups = Integer.parseInt(in.next());
                while ( ((cups*cost) > assets) || cups < 0  ) {
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
    public static byte signsMade(Scanner in, double sc, double assets) {
        byte signs = 0;
        System.out.println("How many signs (15 cents\n"
            + "each) do you want to make?");
        while (true) {
            try {
                signs = Byte.parseByte(in.next());
                while( ((signs*sc) > assets) || signs < 0  ) {
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
        if(in.hasNextDouble()) {
            price = in.nextDouble();
        }
        System.out.println();
        return price;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean tryAgain;
        byte day = 1 , weather, signs;
        double chance, cost, cups, cupsSold, price, profit, income, expense;
        double sc = 0.15;   // sign cost
        
        // Print out menus
        printMenu1();
        in.nextLine();
        // How many players
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");
        int numOfPlayers = Integer.parseInt(in.next());
        printMenu2();
        in.nextLine();
        printMenu3();
        in.nextLine();

        // Instantiating number of player
        Stand[] s = new Stand[numOfPlayers];
        for(int i = 0; i < numOfPlayers; i++){
            s[i] = new Stand(i+1);
        }
        
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
                        chance = 80;
                        break;
                    case 1: // sunny
                        System.out.println("The forecast today is sunny");
                        chance = 50;
                        break;
                    case 2: // cloudy
                        System.out.println("The forecast today is cloudy");
                        chance = 100/3;
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

                } while(tryAgain != false);

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
                financeReport(id, day, cupsSold, price, income, cups, signs, expense,
                        profit, assets);
                currentStand++;
            } // end of current Stand
            day++;
        } while(day < 13); // end of day
    }
}

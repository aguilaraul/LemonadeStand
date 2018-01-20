/**
 * @author  Raul Aguilar
 * @date    2018-01-13
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

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
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean tryAgain = false;
        byte day = 1 , weather;
        double chance;
        int customers;
        double cost;
        int cups;
        int cupsSold;
        byte signs;
        double sc = 0.15;
        int price;
        double assests = 2.00;
        double profit;
        double income;
        double expense;
        
        // Print out menus
        printMenu1();
        in.nextLine();
        printMenu2();
        in.nextLine();
        printMenu3();
        in.nextLine();
        
        // Process of one day
        while(day < 13) {
            //text border
            System.out.println("________________________________________");
            
            weather = (byte) rand.nextInt(3);
            switch(weather) {
                case 0: // hot and dry
                    System.out.println("The forecast today is hot and dry");
                    chance = 70;
                    break;
                case 1: // sunny
                    System.out.println("The forecast today is sunny");
                    chance = 50;
                    break;
                case 2: // cloudy
                    System.out.println("The forcast today is cloudy");
                    chance = 100/3;
                    break;
                default:
                    chance = 0;
                    break;
            }
            //deciding the cost of the day
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
            } 
            else if (day == 7) {
                cost = 0.05;
                System.out.println("On day " + day + ", the cost of lemonade is $.05" );
                System.out.println("(The price of lemonade mix just went up)\n" );
            } else {
                cost = 0.05;
                System.out.println("On day " + day + ", the cost of lemonade is $.05\n" );
            }
            do {
                
            System.out.printf("%s \t %s %.2f%n", "Lemondade Stand 1", "Assests", assests);
            System.out.println("How many glasses of lemonade do you\n"
                    + "wish to make?");
            cups = in.nextInt();
            while ( ((cups*cost) > assests) || cups < 0  ) {
                System.out.println("Sorry, you can't make that many cups of lemonade.");
                System.out.println("Try a new number.");
                cups = in.nextInt();
            }
            expense = cups*cost;
            assests -= expense;
            System.out.println("How many signs (15 cents\n" +
                    "each) do you want to make?");
            signs = in.nextByte();
            while( ((signs*sc) > assests) || signs < 0  ) {
                System.out.println("Sorry, you can't make that many signs.");
                System.out.println("Try a new number.");
                signs = in.nextByte();
            }
            assests -= (signs*sc);
            expense += signs*sc;
            System.out.println("What price (in cents) do you wish to\n"
                    + "charge for lemonade?");
            price = in.nextInt();
            System.out.println("Do you want to change anything? Y/N");
            String ans = in.next();
            if(ans.equalsIgnoreCase("Yes") || ans.equalsIgnoreCase("y")) {
                assests += (cups*cost);
                assests += (signs*.15);
                tryAgain = true;
                }
            else {
                break;
                }
            } while(tryAgain != false);
            
            /* Selling the lemonade */
            // chance of selling
            chance += (chance*(signs/100));
            chance += chance/price;
            chance = chance/100;
            int d = rand.nextInt();
            if(d < chance) {
                cupsSold = cups;
            } else {
                cupsSold = (int) Math.ceil(cups*chance);
            }
            
            System.out.println("Expense:" + expense);
            income = (cupsSold * price) / 100;
            profit = income-expense;
            assests += profit;
            
            System.out.println("Income:" + income);
            System.out.println("Profit:" + profit);
            System.out.println("Chance:" + chance);
            System.out.println("Cups Sold:" + cupsSold);
            day++;
        }
    }
    
}

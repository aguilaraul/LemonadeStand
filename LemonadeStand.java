/**
 * @author  Raul Aguilar
 * @date    2018-01-13
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class LemonadeStand {
    static void printMenu1() {
        System.out.println("Hi! Welcome to Lemonsville, California!");
        System.out.print("In this small town, you are in charge of\n" +
            "running your own lemonade stand. You can\n" +
            "compete with as many other people as you\n" +
            "wish, but how much profit you make is up\n" +
            "to you (the other stands' sales will not\n" +
            "affect your business in any way). If you\n" +
            "make the most money, you're the winner!!\n") ;
        System.out.println("\t(Hit return to continue)");
    }
    static void printMenu2() {
                System.out.print("To manage your lemonade stand, you will\n" +
	"need to make these decisions every day:\n\n");
        System.out.print("1. How many glasses of lemonade to make\n" +
                "(Only one batch is made each morning)\n\n" );
        System.out.print("2. How many advertising signs to make\n" +
                "(The signs cost fifteen cents each)\n\n" );
        System.out.println("3. What price to charge for each glass\n" );
        System.out.print("You will begin with $2.00 cash (assets).\n" +
                "Because your mother gave you some sugar,\n" +
                "your cost to make lemonade is two cents\n" +
                "a glass (this may change in the future).\n" );
        System.out.println("\t(Hit return to continue)");
    }
    static void printMenu3() {
        System.out.print("Your expense are the sum of the cost of\n" +
                "the lemonade and the cost of the signs.\n\n" );
        System.out.print("Your profits are the difference between\n" +
                "the income from the sales and your expenses\n\n" );
        System.out.print("The number of glasses you sell each day\n" +
                "depends on the price you charge, and on\n" +
                "the number of advertising signs you use.\n\n" );
        System.out.print("Keep track of your assets, because you\n" +
                "can't spend more money than you have!\n" );
        System.out.println("\t(Hit return to continue)");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        byte day;
        byte weather;
        byte customers;
        double cost;
        int cups;
        byte signs;
        int price;
        double assests = 2;
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
        for(day = 1; day < 13; day++) {
            weather = (byte) rand.nextInt(4);
            switch(weather) {
                case 0: // hot and dry
                    System.out.println("Hot and dry");
                    customers = 100;
                    break;
                case 1: // sunny
                    System.out.println("Sunny");
                    customers = 70;
                    break;
                case 2: // cloudy
                    System.out.println("Cloudy");
                    customers = 40;
                    break;
                case 3: // street closure
                    System.out.println("Street closure");
                    customers = 25;
                    break;
                default:
                    customers = 0;
                    break;
            }
            
            if(day < 3) {
                cost = 0.02;
                System.out.println("On day " + day + ", the cost of lemonade is $.02" );
            } else if (day == 3) {
                cost = 0.04;
                System.out.println("On day " + day + ", the cost of lemonade is $.04" );
                System.out.println("(Your mom quit giving you free sugar.)");
            } else if (day < 3 && day > 7) {
                cost = 0.04;
                System.out.println("On day " + day + ", the cost of lemonade is $.04" );
            } 
            else if (day == 7) {
                cost = 0.05;
                System.out.println("On day " + day + ", the cost of lemonade is $.05" );
                System.out.println("(The price of lemonade mix just went up)");
            } else {
                cost = 0.05;
                System.out.println("On day " + day + ", the cost of lemonade is $.05" );
            }
            System.out.printf("%s %s %.2f%n", "Lemondade Stand 1", "Assests", assests);
            System.out.println("How many glasses of lemonade do you\n"
                    + "wish to make?");
            cups = in.nextInt();
            while ( ((cups*cost) > assests) || cups < 0  ) {
                System.out.println("Sorry, you can't make that many cups of lemonade.");
                System.out.println("Try a new number.");
                cups = in.nextInt();
            }
            assests -= (cups*cost);
            System.out.println("How many signs (15 cents\n" +
                    "each) do you want to make?");
            signs = in.nextByte();
            while( ((signs*15) > assests) || signs < 0  ) {
                System.out.println("Sorry, you can't make that many signs.");
                System.out.println("Try a new number.");
                signs = in.nextByte();
            }
            System.out.println("What price (in cents) do you wish to\n"
                    + "charge for lemonade?");
            price = in.nextInt();
            System.out.println("Do you want to change anything?");
        }
    }
    
}

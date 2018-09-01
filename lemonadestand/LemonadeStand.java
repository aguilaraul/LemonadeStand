/**
 * @author  Raul Aguilar
 * @date    2018-08-29
 */
package lemonadestand;
import java.util.Random;
import java.util.Scanner;

public class LemonadeStand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        boolean tryAgain;
        byte day = 1 , weather;
        double chance, cost, cups, cupsSold = 0, price, profit, income, expense, signs;
        double sc = 0.15;   // sign cost
        int numOfPlayers = 1;
        
        // Print out menus
        Menus.printMenu1();
        in.nextLine();
        // How many players
        numOfPlayers = Mechanics.setNumberOfPlayers(in);
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
        for(Stand stands : s){ System.out.println(stands); } //debug

        // Process of one day
        do {
            weather = (byte) rand.nextInt(3); // Randomly choosing weather byte
            int currentStand = 0;

            while(currentStand < numOfPlayers) {

                int id;
                double assets;

                // Deciding chance of selling lemonade based on weather
                Menus.border(); //text border
                chance = Mechanics.weather(weather, rand);

                // Deciding the cost of the day
                cost = Mechanics.setCost(day);
                
                // The Game
                do {
                    id = s[currentStand].getId();
                    assets = s[currentStand].getAssets();
                    expense = 0;
                    System.out.printf("%s \t %s %.2f%n", "Lemonade Stand " + id,
                            "Assets", assets);

                    // Asking how many cups of lemonade to make
                    cups = Mechanics.setCups(in, cost, assets);

                    // Asking how many SIGNS to make
                    signs = Mechanics.setSigns(in, sc, assets);

                    // Adding the cost of signs to the cost of making lemonade
                    // Subtracting expense of signs and lemonade from assets
                    expense = (cups*cost)+(signs*sc);

                    // Ask price of lemonade
                    price = Mechanics.setPrice(in);

                    // Ask to change anything
                    tryAgain = Mechanics.askToChangeAnything(in);

                } while(tryAgain);

                /* Selling the lemonade */
                // chance of selling
                chance = Mechanics.calculateChanceOfSelling(chance, signs, price);

                cupsSold = Mechanics.cupsSold(rand, chance, cupsSold, cups);

                income = (cupsSold * price) / 100;
                profit = income-expense;
                assets = assets + profit;

                s[currentStand].setAssets(assets);

                Menus.financeReport(id, day, cupsSold, price, income, cups, signs, expense,
                        profit, assets);

                currentStand++;
            } // end of current Stand
            day++;
        } while(day < 13); // end of day
        in.close();
        System.exit(0);
    }
}
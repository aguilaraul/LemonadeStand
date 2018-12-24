/**
 * @author  Raul Aguilar
 * @date    December 23, 2018
 */
package lemonadestand;

public class Text {

    /**
     * Prints out underscore border
     */
    void border() {
        System.out.println("________________________________________");
    }

    /**
     * Displays menu 1
     */
    void opening1() {
        System.out.println("HI! WELCOME TO LEMONSVILLE, CALIFORNIA!");
        System.out.println("IN THIS SMALL TOWN, YOU ARE IN CHARGE OF");
        System.out.println("RUNNING YOUR OWN LEMONADE STAND. YOU CAN");
        System.out.println("COMPETE WITH AS MANY OTHER PEOPLE AS YOU");
        System.out.println("WISH, BUT HOW MUCH PROFIT YOU MAKE IS UP");
        System.out.println("TO YOU (THE OTHER STANDS' SALES WILL NOT");
        System.out.println("AFFECT YOUR BUSINESS IN ANY WAY). IF YOU");
        System.out.println("MAKE THE MOST MONEY, YOU'RE THE WINNER!!" );
        System.out.println("ARE YOU STARTING A NEW GAME? (YES OR NO)");
        System.out.println("TYPE YOUR ANSWER AND HIT RETURN ==> ");
    }

    /**
     * Displays menu 2
     */
    void opening2() {
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

    /**
     * Displays menu 3
     */
    void opening3() {
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

    void playedBefore1() {
        System.out.println("HI AGAIN! WELCOME BACK TO LEMONSVILLE! ");
        System.out.println("LET'S CONTINUE YOUR LAST GAME FROM WHERE");
        System.out.println("YOU LEFT IT LAST TIME. DO YOU REMEMBER ");
        System.out.println("WHAT DAY NUMBER IT WAS? ");
    }

    /**
     * Error message when user inputs unacceptable number of players
     */
    public void cantAcceptThatMany() {
        System.out.println("CAN'T ACCEPT THAT MANY PLAYERS.");
        System.out.println("PLEASE ENTER A NEW NUMBER:");
    }

    /**
     * Error message when user can't afford to make specified number
     * of cups and signs
     */
    public void cantMakeThatMany() {
        System.out.println("YOU CAN'T AFFORD TO MAKE THAT MANY.");
        System.out.println("TRY A NEW NUMBER.");
    }

    /**
     * Prints with NumberFormatException
     */
    void tryANewNumber() {
        System.out.println("Try a new number.");
    }

    /**
     * Asks user how many users are playing
     */
    public void askHowManyPlayers() {
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");
    }

    /**
     * Asks user how many cups of lemonade to make
     */
    public void askHowManyCups() {
        System.out.println("HOW MANY GLASSES OF LEMONADE DO YOU\n"
                + "WISH TO MAKE?");
    }

    /**
     * Asks user how many signs to make
     */
    public void askHowManySigns() {
        System.out.println("HOW MANY ADVERTISING SIGNS (15 CENTS\n"
                + "EACH) DO YOU WANT TO MAKE?");
    }

    /**
     * Asks user to set price of lemonade
     */
    public void askToSetPrice() {
        System.out.println("WHAT PRICE (IN CENTS) DO YOU WISH TO\n"
                + "CHARGE FOR LEMONADE?");
    }

    /**
     * Asks player if they want to change anything
     */
    public void askToChangeAnything() {
        System.out.println("DO YOU WANT TO CHANGE ANYTHING? Y/N");
    }

    /**
     * Displays the end of the day financial report for the business
     * @param id lemonade stand number
     * @param day feeds in current day
     * @param cupsSold number of cups sold
     * @param price the price of lemonade
     * @param income income is equal to profit minus expenses
     * @param cups number of cups made
     * @param signs number of signs made
     * @param expense cost of cups and signs
     * @param profit net earnings
     * @param assets money available
     */
    void financeReport(int id, byte day, double cupsSold, double price, double income,
                                     double cups, double signs, double expense, double profit, double assets)
    {
        System.out.println();
        border();
        System.out.println("$$ LEMONSVILLE DAILY FINANCIAL REPORT $$\n");
        System.out.printf("%6S %d %25S %d\n", "DAY", day, "STAND", id);
        System.out.println();
        System.out.printf("%4.0f %S %n", cupsSold, "GLASSES SOLD");
        System.out.printf("$.%.0f %S %17S $%.2f \n", price, "PER GLASS", "INCOME", income);
        System.out.println();
        System.out.printf("%4.0f %S %n", cups, "GLASSES MADE");
        System.out.printf("%3.0f %11S %17S $%.2f%n", signs, "SIGNS MADE", "EXPENSES", expense);
        System.out.println();
        System.out.printf("%20S $%.2f%n", "PROFIT", profit);
        System.out.printf("%20S $%.2f%n", "ASSETS", assets);
    }

    void endGameScreen(byte day, int id, double tcm, double tcs, double tsm, double te, double tr) {
        System.out.println();
        border();
        System.out.println("$$ LEMONSVILLE DAILY FINANCIAL REPORT $$\n");
        System.out.printf("%6S %d %25S %d\n", "DAY", day, "STAND", id);
        System.out.println();
        System.out.println("Total number of cups made: " + tcm);
        System.out.println("Total number of cups sold: " + tcs);
        System.out.println("Total number of signs made: " + tsm);
        System.out.println("Total expenses: $" + te);
        System.out.println("Total revenue: $" + tr);
        System.out.println("Total Profit: $" + (tr-te) );
    }

    void bankrupt(int id) {
        System.out.println("STAND" + id);
        System.out.println("...YOU DON'T HAVE ENOUGH MONEY LEFT"
            + " TO STAY IN BUSINESS YOU'RE BANKRUPT!");
    }
}
/*
 * @author  Raul Aguilar
 * @date    December 30, 2018
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
    void titlePage() {
        System.out.println("HI! WELCOME TO LEMONSVILLE, CALIFORNIA!");
        System.out.println();
        System.out.println("IN THIS SMALL TOWN, YOU ARE IN CHARGE OF");
        System.out.println("RUNNING YOUR OWN LEMONADE STAND. YOU CAN");
        System.out.println("COMPETE WITH AS MANY OTHER PEOPLE AS YOU");
        System.out.println("WISH, BUT HOW MUCH PROFIT YOU MAKE IS UP");
        System.out.println("TO YOU (THE OTHER STANDS' SALES WILL NOT");
        System.out.println("AFFECT YOUR BUSINESS IN ANY WAY). IF YOU");
        System.out.println("MAKE THE MOST MONEY, YOU'RE THE WINNER!!" );
        System.out.println();
        System.out.println("ARE YOU STARTING A NEW GAME? (YES OR NO)");
        System.out.println("TYPE YOUR ANSWER AND HIT RETURN ==> ");
    }

    /**
     * Displays new business prompt 1
     */
    void newBusiness() {
        System.out.println("TO MANAGE YOUR LEMONADE STAND, YOU WILL");
        System.out.println("NEED TO MAKE THESE DECISIONS EVERY DAY:");
        System.out.println("1. HOW MANY GLASSES OF LEMONADE TO MAKE");
        System.out.printf("%40s%n", "(ONLY ONE BATCH IS MADE EACH MORNING)" );
        System.out.println("2. HOW MANY ADVERTISING SIGNS TO MAKE");
        System.out.printf("%38s%n", "(THE SIGNS COST FIFTEEN CENTS EACH)" );
        System.out.println("3. WHAT PRICE TO CHARGE FOR EACH GLASS");
        System.out.println();
        System.out.println("YOU WILL BEGIN WITH $2.00 CASH (ASSETS).");
        System.out.println("BECAUSE YOUR MOTHER GAVE YOU SOME SUGAR,");
        System.out.println("YOUR COST TO MAKE LEMONADE IS TWO CENTS");
        System.out.println("A GLASS (THIS MAY CHANGE IN THE FUTURE).");
        System.out.println("\t(HIT RETURN TO CONTINUE)");
    }

    /**
     * Displays prompt 2
     */
    void newBusiness2() {
        System.out.println("YOUR EXPENSE ARE THE SUM OF THE COST OF");
        System.out.println("THE LEMONADE AND THE COST OF THE SIGNS." );
        System.out.println();
        System.out.println("YOUR PROFITS ARE THE DIFFERENCE BETWEEN");
        System.out.println("THE INCOME FROM THE SALES AND YOUR EXPENSES." );
        System.out.println();
        System.out.println("THE NUMBER OF GLASSES YOU SELL EACH DAY");
        System.out.println("DEPENDS ON THE PRICE YOU CHARGE, AND ON");
        System.out.println("THE NUMBER OF ADVERTISING SIGNS YOU USE." );
        System.out.println();
        System.out.println("KEEP TRACK OF YOUR ASSETS, BECAUSE YOU");
        System.out.println("CAN'T SPEND MORE MONEY THAN YOU HAVE!" );
        System.out.println("\t(HIT RETURN TO CONTINUE)");
    }

    /**
     * Displays prompt if player starts old game
     */
    void continueOldGame() {
        System.out.println("HI AGAIN! WELCOME BACK TO LEMONSVILLE! ");
        System.out.println("LET'S CONTINUE YOUR LAST GAME FROM WHERE");
        System.out.println("YOU LEFT IT LAST TIME. DO YOU REMEMBER ");
        System.out.println("WHAT DAY NUMBER IT WAS? ");
    }

    /**
     * Error message when user inputs unacceptable number of players
     */
    void cantAcceptThatMany() {
        System.out.println("CAN'T ACCEPT THAT MANY PLAYERS.");
        System.out.println("PLEASE ENTER A NEW NUMBER:");
    }

    /**
     * Prints with NumberFormatException
     */
    void tryANewNumber() {
        System.out.println("TRY A NEW NUMBER.");
    }

    /**
     * Asks user how many users are playing
     */
    void askHowManyPlayers() {
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");
    }

    /**
     * Displays current day and the cost of lemonade
     * @param day current day
     * @param cost cost of lemonade
     */
    void costOfLemonade(byte day, float cost) {
        System.out.println("ON DAY " + day + ", THE COST OF LEMONADE IS $" + cost );
    }

    void forecastToday(byte weather) {
        String forecast;
        switch (weather) {
            case 2:
                forecast = "SUNNY";
                break;
            case 7:
                forecast = "HOT AND DRY";
                break;
            case 10:
                forecast = "CLOUDY";
                break;
            default:
                forecast = "";
        }
        System.out.println("The forecast today is " + forecast);
    }

    /**
     * Asks user how many cups of lemonade to make
     */
    void askHowManyCups() {
        System.out.println("HOW MANY GLASSES OF LEMONADE DO YOU");
        System.out.println("WISH TO MAKE?");
    }

    /**
     * Asks user how many signs to make
     */
    void askHowManySigns() {
        System.out.println("HOW MANY ADVERTISING SIGNS (15 CENTS");
        System.out.println("EACH) DO YOU WANT TO MAKE?");
    }

    /**
     * Asks user to set price of lemonade
     */
    void askToSetPrice() {
        System.out.println("WHAT PRICE (IN CENTS) DO YOU WISH TO");
        System.out.println("CHARGE FOR LEMONADE?");
    }

    /**
     * Asks player if they want to change anything
     */
    void askToChangeAnything() {
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
    void financeReport(byte id, byte day, short cupsSold, float price, float income,
                                     short cups, byte signs, float expense, float profit, float assets)
    {
        System.out.println();
        border();
        System.out.println("$$ LEMONSVILLE DAILY FINANCIAL REPORT $$");
        System.out.println();
        System.out.printf("%6S %d %25S %d\n", "DAY", day, "STAND", id);
        System.out.println();
        System.out.printf("%4d %S %n", cupsSold, "GLASSES SOLD");
        System.out.printf("$.%.0f %S %17S $%.2f \n", price, "PER GLASS", "INCOME", income);
        System.out.println();
        System.out.printf("%4d %S %n", cups, "GLASSES MADE");
        System.out.printf("%3d %11S %17S $%.2f%n", signs, "SIGNS MADE", "EXPENSES", expense);
        System.out.println();
        System.out.printf("%20S $%.2f%n", "PROFIT", profit);
        System.out.printf("%20S $%.2f%n", "ASSETS", assets);
    }

    /**
     * Displays at the end of the game, showing stats from the playthrough
     * @param day the last day played
     * @param id lemonade stand stats belong to
     * @param tcm total cups made
     * @param tcs total cups sold
     * @param tsm total signs made
     * @param te total expense
     * @param tr total revenue
     */
    void endGameScreen(byte day, int id, double tcm, double tcs, double tsm, double te, double tr) {
        System.out.println();
        border();
        System.out.println("$$ LEMONSVILLE FINAL FINANCIAL REPORT $$");
        System.out.println();
        System.out.printf("%6S %d %25S %d\n", "DAY", day, "STAND", id);
        System.out.println();
        System.out.println("Total number of cups made: " + tcm);
        System.out.println("Total number of cups sold: " + tcs);
        System.out.println("Total number of signs made: " + tsm);
        System.out.println("Total expenses: $" + te);
        System.out.println("Total revenue: $" + tr);
        System.out.println("Total Profit: $" + (tr-te) );
    }

    void streetCrewBoughtAllYourLemonade() {
        System.out.println();
        System.out.println("THE STREET CREWS BOUGHT ALL YOUR");
        System.out.println("LEMONADE AT LUNCHTIME!!");
    }

    void thunderstorms() {
        System.out.println("WEATHER REPORT: A SEVERE THUNDERSTORM");
        System.out.println("HIT LEMONSVILLE EARLIER TODAY, JUST AS");
        System.out.println("THE LEMONADE STANDS WERE BEING SET UP.");
        System.out.println("UNFORTUNATELY, EVERYTHING WAS RUINED!!");
    }
}
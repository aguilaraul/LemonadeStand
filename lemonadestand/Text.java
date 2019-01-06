/*
 * @author  Raul Aguilar
 * @date    January 04, 2019
 */
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
     * Asks user how many users are playing
     */
    void askHowManyPlayers() {
        System.out.println("HOW MANY PEOPLE WILL BE PLAYING?");
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
     * Displays the forecast determined by weather()
     */
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
     * Displays current day and the cost of lemonade
     * @param day current day
     * @param cost cost of lemonade
     */
    void costOfLemonade(byte day, float cost) {
        System.out.println();
        System.out.println("ON DAY " + day + ", THE COST OF LEMONADE IS $" + cost );
        if (day == 3) {
            System.out.println("(YOUR MOM QUIT GIVING YOU FREE SUGAR)" );
        } else if (day == 7) {
            System.out.println("(THE PRICE OF LEMONADE MIX JUST WENT UP)" );
        }
    }
    
    /**
     * Prints stand information at top of the day
     * @param id the id of the current stand
     * @param assets assets of the current stand
     */
    void standInfo(byte id, float assets) {
	    System.out.println();
	    System.out.printf("%s \t %s %.2f%n", "Lemonade Stand " + id, "Assets", assets);
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
     * Displays the financial report for the stand at the end of the day
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
        border();
    }

    /**
     * Random Event
     * Prints if the street crew bought all your lemonade
     */
    void streetCrewBoughtAllYourLemonade() {
        System.out.println();
        System.out.println("THE STREET CREWS BOUGHT ALL YOUR");
        System.out.println("LEMONADE AT LUNCHTIME!!");
    }

    /**
     * Random Event
     * Prints on the financial report screen after a thunderstorm
     */
    void thunderstorms() {
        System.out.println("WEATHER REPORT: A SEVERE THUNDERSTORM");
        System.out.println("HIT LEMONSVILLE EARLIER TODAY, JUST AS");
        System.out.println("THE LEMONADE STANDS WERE BEING SET UP.");
        System.out.println("UNFORTUNATELY, EVERYTHING WAS RUINED!!");
    }

    /**
     * Prints at the end of a financial report when a stand is bankrupt
     * Bankrupt = true when assets > cost
     */
    void youDontHaveEnoughMoney() {
        System.out.println();
	    System.out.println("...YOU DON'T HAVE ENOUGH MONEY LEFT");
        System.out.println("TO STAY IN BUSINESS YOU'RE BANKRUPT!");
        System.out.println();
    }
    
    /**
     * Prints when the current stand is bankrupt instead of asking
     * questions
     */
    void youAreBankruptNoDecisions() {
        System.out.println();
	    System.out.println("YOU ARE BANKRUPT, NO DECISIONS");
	    System.out.println("FOR YOU TO MAKE.");
	    System.out.println();
    }

    /**
     * Prints when a stand is already bankrupt has nothing to
     * display in the financial report
     */
    void standBankrupt(byte id) {
        System.out.println();
	    System.out.println("STAND " + id + " BANKRUPT");
	    System.out.println();
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
     * @param asset assets of the current stand
     */
    void endGameScreen(byte day, int id, short tcm, short tcs, short tsm, float tr, float te, float asset) {
        System.out.println();
        border();
        System.out.println("$$ LEMONSVILLE FINAL FINANCIAL REPORT $$");
        System.out.println();
        System.out.printf("%6S %d %25S %d\n", "DAY", day, "STAND", id);
        System.out.println();
        System.out.printf("%20s  %d", "Total Cups Made:", tcm);
        System.out.println();
        System.out.printf("%20s  %d", "Total Cups Sold:", tcs);
        System.out.println();
        System.out.printf("%20s  %d", "Total Signs Made:", tsm);
        System.out.println();
        System.out.printf("%20s $%.2f", "Total Revenue:", tr);
        System.out.println();
        System.out.printf("%20s $%.2f", "Total Expense:", te);
        System.out.println();
        System.out.printf("%20s $%.2f", "Total Profit:", (tr-te) );
        System.out.println();
        System.out.printf("%20s $%.2f", "Assets:", asset);
        System.out.println();
        border();
    }
}

/*
 * @author  Raul Aguilar
 * @date    06 January 2019
 */
import java.util.Random;
import java.util.Scanner;

public class Game {
	private Text text = new Text();

    	private final int P9 = 10;
    	private final int S2 = 30;
    	private final float S3 = 0.15f;

    	private Scanner in = new Scanner(System.in);
    	private Random rand = new Random();
    	private Stand[] s;
    	private byte id;
    	private float assets;
    	private byte numOfPlayers;
	private byte day;
	private byte weather;
    	private double chance;
    	private double R1 = 1.0;
    	private int G = 1;
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
    	private boolean streetCrewThirsty = false;
    	private boolean thunderstorm = false;
	
	public void play() {
        	day = 1;
        	intro();
        	text.border();

        	// Process of one day
        	/*
         	 * The process of one day
         	 * 1. display weather report
         	 * 2. displays the day and cost of lemonade
         	 * 3. displays stand info
         	 * 4. asks questions (cups/signs to make, set price)
         	 * 4a. if stand is bankrupt
         	 * 	   display YouAreBankruptNoDecisions
         	 * 5. would you like to change anything?
         	 * 5a. if yes, reset to (2.)
         	 * 6. calculate cups sold, income, profit
         	 * 7. set values to current stand
         	 * 8. move on to next stand
         	 * 9. display financial report
         	 * 9a. if stand becomes bankrupt
         	 * 	   display YouDontHaveEnoughMoney
         	 * 9b. if stand is already bankrupt
         	 * 	   DO NOT display financial report
         	 * 	   display STAND id BANKRUPT
         	 * 9c. move on to next stand
         	 * 10. move on to next day
         	 */ 		
		do {
			G = 1;
			// reset currentStand at the beginning of everyday
            		int currentStand = 0;
            		// set weather once per day
            		weather();
            		// weather report once per day at the start of day
            		text.forecastToday(weather);
	       		// Random events can occur after day 2
	       		if (day > 2) {
                		randomEvents();
            		}

            		processOfOneStand(currentStand);
            		financialReport();

            		day++;
        	} while(day < 13); // end of day

        	int currentStand = 0;
        	while (currentStand < numOfPlayers) {
            		text.endGameScreen((byte) (day-1), s[currentStand].getId(), s[currentStand].getTotalCupsMade(),
					s[currentStand].getTotalCupsSold(), s[currentStand].getTotalSignsMade(),
					s[currentStand].getRevenue(), s[currentStand].getTotalExpense(), s[currentStand].getAssets());
			currentStand++;
        	}
	}
	
	/**
     	 * Prints out opening menus, starts a new game or not,  and instatntiates number of players playing
     	 */
	private void intro() {
        	text.titlePage();
        	if(askYesOrNo()) {
            		//if the player has played before
			System.out.println();
            		// How many players
            		text.askHowManyPlayers();
            		setNumberOfPlayers();
			instantiatePlayers();
        	} else {
			//if the player has not played before
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
						String a = in.next();
						exit(a);

						assets = Float.parseFloat(a);
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
	private boolean askYesOrNo() {
		answer = "";
		if(in.hasNext()) {
			answer = in.next();
		}
		exit(answer);

		return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
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
				String n = in.next();
				exit(n);

				numOfPlayers = Byte.parseByte(n);
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
	 * Instantiates number of players and their stands
    	 */
	private void instantiatePlayers() {
		s = new Stand[numOfPlayers];
		for(int i = 0; i < numOfPlayers; i++){
			s[i] = new Stand((byte) (i+1));
		}
	}

    	/**
    	 * Used to set day after user has played before
    	 * Checks if the day is in between 0 and 100
    	 */
	private void setDay() {
        	boolean daySet = false;

        	while(!daySet) {
            		try {
				String d = in.next();
				exit(d);

				day = Byte.parseByte(d);
                		if(day >= 1 && day < 99) {
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
		R1 = 1;
		double random = rand.nextDouble();
		
		if (random < .6) {
			weather = 2;
			chance = (double) rand.nextInt(43 + 1) + 34;
		} else if (random < .8) {
			weather = 10;
			chance = (double) rand.nextInt(33 + 1);
		} else {
			weather = 7;
			chance = (double) rand.nextInt(22 + 1) + 78;
		}
	}
	
	/**
	 * Sets cost of making lemonade for the day
    	 */
	private void costOfTheDay() {
		if (day < 3) {
			cost = 0.02f;
		} else if (day < 7) {
			cost = 0.04f;
		} else {
			cost = 0.05f;
		}
	}
	
	/**
	 * Random Events
    	 * Random events can occur as thunderstorms, street closure, and heat waves
    	 */
	private void randomEvents(){
		streetCrewThirsty = false;
		thunderstorm = false;
		
		if(rand.nextDouble() < 0.25) {
			System.out.println("THE STREET DEPARTMENT IS WORKING TODAY.");
			System.out.println("THERE WILL BE NO TRAFFIC ON YOUR STREET.");
			if(rand.nextInt(2) < 1) {
				streetCrewThirsty = true;
			} else {
				R1 = .1;
			}
		} else {
			if(weather == 10) {
				if(rand.nextDouble() < .25) {
					G = 0;
					thunderstorm = true;
				} else {
					int J = 30 + (int) Math.floor(rand.nextDouble()*5*10);
					System.out.println("THERE IS A " + J + "% CHANCE OF LIGHT RAIN");
					System.out.println("AND THE WEATHER IS COOLER TODAY.");
					R1 = 1 - J/100.0;
				}
			}
			if(weather == 7) {
				System.out.println("A HEAT WAVE IS PREDICTED FOR TODAY!");
				R1 = 2;
			}
		}
	}
	
	/*
	 * The process of one stand
    	 * 1. displays the day and cost of lemonade
    	 * 2. displays stand info
    	 * 3. asks questions (cups/signs to make, set price)
    	 * 3a. if stand is bankrupt
    	 *     display YouAreBankruptNoDecisions
    	 * 4. would you like to change anything?
    	 * 4a. if yes, reset to (2.)
     	 * 5. calculate cups sold, income, profit
    	 * 6. set values to current stand
    	 * 7. move on to next stand while currentStand < numOfPlayers
    	 * @param currentStand the current stand playing
     	 */ 
	private void processOfOneStand(int currentStand) {
		// Process of one player
        	while(currentStand < numOfPlayers) {
			// The Game
			do {
				id = s[currentStand].getId();
				assets = s[currentStand].getAssets();
				expense = 0;
				
				// Deciding the cost of the day
				costOfTheDay();
				if(currentStand > 0) {
					text.border();
				}
				text.costOfLemonade(day, cost);
				// Display stand info
				text.standInfo(id, assets);
			
				// 1. if bankrupt
                		// 1a. display You are bankrupt no decisions to make
                		// 2. if not bankrupt
                		// 2a.  ask questions
                		// 3. always ask to change anything
				if(s[currentStand].getIsBankrupt()) {
					text.youAreBankruptNoDecisions();
				} else {
					// Asking how many cups of lemonade to make
					text.askHowManyCups();
					makeLemonade();
					assets -= (cups*cost);
				
					// Asking how many SIGNS to make
                    			text.askHowManySigns();
					makeSigns(assets);

                    			// Adding the cost of signs to the cost of making lemonade
                    			// Subtracting expense of signs and lemonade from assets
                    			expense = ((cups*cost)+(signs*S3));

                    			// Ask price of lemonade
                    			text.askToSetPrice();
                    			setPrice();
				}
			
				// Ask to change anything
            			text.askToChangeAnything();
				tryAgain = askYesOrNo();
			} while(tryAgain);
		
			/* Selling the lemonade */
			// if street crew is thirsty
			// sell all the lemonade
            		// if thunderstorms
            		//  display weather report on financial report
            		//  sell no lemonade
            		// else
            		//  sell lemonade like normal
			if(streetCrewThirsty) {
				text.streetCrewBoughtAllYourLemonade();
				cupsSold = (cups);
			} else if (thunderstorm) {
				text.thunderstorms();
				cupsSold = (short) 0;
			} else {
				sellLemonade();
			}
		
			s[currentStand].setAll(price, expense, income, profit, cups, cupsSold, signs);

            		// Calculate assets and set to current stand
            		assets = assets + profit;
            		s[currentStand].setAssets(assets);

            		currentStand++;
		} // end of current Stand
	}
	
	/**
    	 * Set number of cups of lemonade to make
    	 */
	private void makeLemonade() {
        	boolean cupsSet = false;

		while(!cupsSet) {
            		try {
		    		String c = in.next();
				exit(c);

				cups = Short.parseShort(c);
				if (cups >= 0 && cups < 1000) {
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
	private void makeSigns(float assets) {
		boolean signsSet = false;
		
		while(!signsSet) {
			try {
				String s = in.next();
				exit(s);
				
				signs = Byte.parseByte(s);
				if(signs >= 0 && signs < 50) {
					if(signs*S3 > assets) {
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
    	 * Ignores all non-Float by asking for new Double
    	 * Turns all Floats into their absolute values
    	 */
	private void setPrice() {
		boolean priceSet = false;

		while(!priceSet) {
			try {
				String p = in.next();
				exit(p);

				price = Float.parseFloat(p);
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
	 * Sets the number of cups sold
    	 */
	private void sellLemonade() {
		double N1;
		if(price >= P9) {
			N1 = (Math.pow(P9,2)*S2 / Math.pow(price, 2));
		} else {
			N1 = ( (P9 - price)/P9*.8*S2+S2);
		}
    		double W = -signs*P9;
    		double V = 1 - (Math.exp(W)*1);
    		cupsSold = (short) (R1 * (N1 + (N1 * V)));
    		cupsSold = (short) (cupsSold * G);
		if( !(cupsSold <= cups)) {
			cupsSold = cups;
		}
		income = (float) (cupsSold * price * 0.01);
		expense = signs * S3 + cups * cost;
		profit = income - expense;
	}
	
	/*
	 * Displays the financial report and sets the bankruptcy state of a stand
	 * 1. If the stand is bankrupt
    	 *     then display STAND id BANKRUPT
    	 *    Else
    	 *     then display the financial report
    	 * 2. If the current stands assets < the cost of lemonade
    	 *     then the stand is bankrupt and display message
    	 * 3. Move on to next stand
    	 */
	private void financialReport() {
        	int currentStand = 0;
		while (currentStand < numOfPlayers) {
			// if current stand is bankrupt
			// display stand id is bankrupt
            		// else
            		//  display financial report
			if(s[currentStand].getIsBankrupt()) {
				text.standBankrupt(id);
			} else {
				text.financeReport(s[currentStand].getId(), day, s[currentStand].getCupsSold(), s[currentStand].getPrice(),
						s[currentStand].getIncome(), s[currentStand].getCups(), s[currentStand].getSigns(),
						s[currentStand].getExpense(), s[currentStand].getProfit(), s[currentStand].getAssets());
			}
			
			// if current stand assets < cost of lemonade
			// then stand is bankrupt and display message
			if (!s[currentStand].getIsBankrupt()) {
				if(s[currentStand].getAssets() < cost) {
					s[currentStand].setBankrupt(true);
					text.youDontHaveEnoughMoney();
				}
			}
			currentStand++;
		}
	}
	
	/**
	 * Exits program if user types "exit" at any prompt
	 */
	private void exit(String str) {
		if(str.equals("exit")) System.exit(0);
	}
}

def border():
    "prints underscore border"
    print "________________________________________"
    return

def firstScreen():
    print "HI! WELCOME TO LEMONSVILLE, CALIFORNIA!"
    print
    print "IN THIS SMALL TOWN, YOU ARE IN CHARGE OF"
    print "RUNNING YOUR OWN LEMONADE STAND. YOU CAN"
    print "COMPETE WITH AS MANY OTHER PEOPLE AS YOU"
    print "WISH, BUT HOW MUCH PROFIT YOU MAKE IS UP"
    print "TO YOU (THE OTHER STANDS' SALES WILL NOT"
    print "AFFECT YOUR BUSINESS IN ANY WAY). IF YOU"
    print "MAKE THE MOST MONEY, YOU'RE THE WINNER!!"
    print
    print "ARE YOU STARTING A NEW GAME? (YES OR NO)"
    print "TYPE YOUR ANSWER AND HIT RETURN ==> "
    return

def newBusiness():
    "display new business prompt 1"
    print "TO MANAGE YOUR LEMONADE STAND, YOU WILL"
    print "NEED TO MAKE THESE DECISIONS EVERY DAY:"
    print "1. HOW MANY GLASSES OF LEMONADE TO MAKE"
    print '{:>40}\n'.format("(ONLY ONE BATCH IS MADE EACH MORNING)")
    print "2. HOW MANY ADVERTISING SIGNS TO MAKE"
    print '{:>38}\n'.format("(THE SIGNS COST FIFTEEN CENTS EACH)")
    print "3. WHAT PRICE TO CHARGE FOR EACH GLASS"
    print
    print "YOU WILL BEGIN WITH $2.00 CASH (ASSETS)."
    print "BECAUSE YOUR MOTHER GAVE YOU SOME SUGAR,"
    print "YOUR COST TO MAKE LEMONADE IS TWO CENTS"
    print "A GLASS (THIS MAY CHANGE IN THE FUTURE)."
    print "\t(HIT RETURN TO CONTINUE)"
    return

def newBusiness2():
    "display new business prompt 2"
    print "YOUR EXPENSE ARE THE SUM OF THE COST OF"
    print "THE LEMONADE AND THE COST OF THE SIGNS." 
    print
    print "YOUR PROFITS ARE THE DIFFERENCE BETWEEN"
    print "THE INCOME FROM THE SALES AND YOUR EXPENSES." 
    print
    print "THE NUMBER OF GLASSES YOU SELL EACH DAY"
    print "DEPENDS ON THE PRICE YOU CHARGE, AND ON"
    print "THE NUMBER OF ADVERTISING SIGNS YOU USE." 
    print
    print "KEEP TRACK OF YOUR ASSETS, BECAUSE YOU"
    print "CAN'T SPEND MORE MONEY THAN YOU HAVE!" 
    print "\t(HIT RETURN TO CONTINUE)"
    return

def continueOldGame():
    "displays if player wants to start an previous game"
    print "HI AGAIN! WELCOME BACK TO LEMONSVILLE! "
    print "LET'S CONTINUE YOUR LAST GAME FROM WHERE"
    print "YOU LEFT IT LAST TIME. DO YOU REMEMBER "
    return

def askHowManyPlayers():
    "ask user how many people are playing"
    print "HOW MANY PEOPLE WILL BE PLAYING?"
    return

def cantAcceptThatMany():
    "error message when user inputs unacceptable number of players"
    print "CAN'T ACCEPT THAT MANY PLAYERS"
    print "PLEASE ENTER A NEW NUMBER"
    return

def tryANewNumber():
    "Prints with NumberFormatException"
    print "TRY A NEW NUMBER"
    return

def forecastToday(weather):
    "Displays the forecast determined by weather()"
    if(weather == 2):
        forecast = "SUNNY"
    if(weather == 7):
        forecast = "HOT AND DRY"
    if(weather == 10):
        forecast = "CLOUDY"
    return "THE FORECAST TODAY IS ", forecast

def costOfLemonade(day, cost):
    print
    print "ON DAY ", day, ", THE COST OF LEMONADE IS $", cost
    if day == 3:
        print "(YOUR MOM QUIT GIVING YOU FREE SUGAR)"
    elif day == 7:
        print "(THE PRICE OF LEMONADE MIX JUST WENT UP)"
    return

def standInfo(id, assets):
    print
    print "{} \t {} {:.2f}\n".format("Lemonade Stand ", id, "Assets", assets)
    return

def askHowManyCups():
    print "HOW MANY GLASSES OF LEMONADE DO YOU"
    return

def askHowManySigns():
    print "HOW MANY ADVERTISING SIGNS (15 CENTS"
    print "EACH) DO YOU WANT TO MAKE?"
    return

def askToSetPrice():
    print "WHAT PRICE (IN CENTS) DO YOU WISH TO"
    print "CHARGE FOR LEMONADE?"
    return

def askToChangeAnything():
    print "DO YOU WANT TO CHANGE ANYTHING? Y/N"
    return

def financeReport(id, day, cupsSold, price, income, cups, signs, expense, profit, assets):
    print
    border()
    print "$$ LEMONSVILLE DAILY FINANCIAL REPORT $$"
    print
    print "{:>6} {:d} {:>25} {:d}".format("DAY", day, "STAND", id)
    print
    print "{:>4d} {} \n".format(cupsSold, "GLASSES SOLD")
    print "$.{:.0f} {} {:>17} ${:.2f} \n".format(price, "PER GLASS", "INCOME", income)
    print
    print "{:>4d} {} \n".format(cups, "GLASSES MADE")
    print "{:>3d} {:>11} {:>17} ${:.2f}\n".format(signs, "SIGNS MADE", "EXPENSES", expense)
    print
    print "{:>20} ${:.2f}".format("PROFIT", profit)
    print "{:>20} %{:.2f}".format("ASSETS", assets)
    border()
    return

def streetCrewBoughtAllYourLemonade():
    print
    print "THE STREET CREWS BOUGHT ALL YOUR"
    print "LEMONADE AT LUNCHTIME!!"
    return

def thunderstorms():
    print "WEATHER REPORT: A SEVERE THUNDERSTORM"
    print "HIT LEMONSVILLE EARLIER TODAY, JUST AS"
    print "THE LEMONADE STANDS WERE BEING SET UP."
    print "UNFORTUNATELY, EVERYTHING WAS RUINED!!"
    return

def youDontHaveEnoughMoney():
    print
    print "...YOU DON'T HAVE ENOUGH MONEY LEFT"
    print "TO STAY IN BUSINESS YOU'RE BANKRUPT!"
    print
    return

def youAreBankruptNoDecisions():
    print
    print "YOU ARE BANKRUPT, NO DECISIONS"
    print "FOR YOU TO MAKE."
    print
    return

def standBankrupt(id):
    print
    print "STAND ", id, " BANKRUPT"
    print
    return

def endGameScreen(day, id, tcm, tcs, tsm, tr, te, assets):
    print
    border()
    print "$$ LEMONSVILLE FINAL FINANCIAL REPORT $$"
    print
    print "{:>6} {:d} {:>25} {:d}\n".format("DAY", day, "STAND", id)
    print
    print "{:>20}  {d}".format("Total Cups Made:", tcm)
    print
    print "{:>20}  {d}".format("Total Cups Sold:", tcs)
    print
    print "{:>20}  {d}".format("Total Signs Made:", tsm)
    print
    print "{:>20} ${:.2f}".format("Total Revenue:", tr)
    print
    print "{:>20} ${:.2f}".format("Total Expense:", te)
    print
    print "{:>20} ${:.2f}".format("Total Profit:", (tr-te)) 
    print
    print "{:>20} ${:.2f}".format("Assets:", assets)
    print
    border()
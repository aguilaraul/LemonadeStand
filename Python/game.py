import math
import random
import text
import stand

S3 = 0.15

# global variables
s = [stand.Stand(0)]
id = 0
assets = 0
numOfPlayers = 0
day = 0
weather = 0
R1 = 1.0
G = 1
cost = 0
price = 0
expense = 0
income = 0
profit = 0
cups = 0
cupsSold = 0
signs = 0
streetCrewThirsty = False
thunderstorms = False

def play():
    day = 1
    intro()
    text.border()
    while True:
        G = 1
        currentStand = 0
        weather()
        text.forecastToday(weather)
        if(day > 2):
            randomEvents()
        processOfOneStand(currentStand)
        financialReport()
        day += 1
        if(day < 13): # break out of do while loop
            break
    return

def intro():
    text.firstScreen()
    if(askYesOrNo()):
        # if the player has not played before
        print
        # ask how many players are playing
        text.askHowManyPlayers()
        setNumberOfPlayers()
        instaniatePlayers()
    else:
        # if the player is continuing an old game
        print
        # ask how many players are playing
        text.askHowManyPlayers()
        setNumberOfPlayers()
        instaniatePlayers()

        text.continueOldGame()
        setDay()

        currentStand = 0
        while currentStand < numOfPlayers:
            assetSet = False
            id = s[currentStand].getId()
            print "PLAYER NO.", id, ", HOW MUCH MONEY (ASSETS)"
            print "DID YOU HAVE?"

            while not assetSet:
                try:
                    a = input()

                    assets = float(a)
                    if assets < 2:
                        print "O.K. - WE'LL START YOU OUT WITH $2.00"
                        print
                        assets = 2.00
                        assetSet = True
                    elif assets > 40:
                        print "JUST TO BE FAIR, LET'S MAKE THAT $10.00"
                        print
                        assets = 10.00
                        assetSet = True
                    else:
                        assetSet = True
                except:
                    assetSet = False
                    text.tryANewNumber()

            s[currentStand].setAssets(assets)
            currentStand += 1

        print "...READY TO BEGIN?"
        input()

    text.newBusiness()
    input()
    text.newBusiness2()
    input()
    return

def askYesOrNo():
    answer = input()
    return answer == "yes" or answer == "y"

def setNumberOfPlayers():
    playerSet = False

    while not playerSet:
        try:
            n = input()
            numberOfPlayers = bytes(n)
            if(numberOfPlayers > 0 and numberOfPlayers < 30):
                playerSet = True
            else:
                text.cantAcceptThatMany()
            print
        except ValueError:
            text.tryANewNumber()
    return

def instaniatePlayers():
    i = 0
    while i < numOfPlayers:
        s.append(stand.Stand(i+1))
        i += 1
    return

def setDay():
    daySet = False
    
    while not daySet:
        try:
            d = input("WHAT DAY NUMBER IT WAS? ")

            day = bytes(d)
            if day >= 1 and day < 99:
                day += 1
                print "OKAY - WE'LL START WITH DAY NO. ", day
                daySet = True
            print
        except:
            text.tryANewNumber()
    return

def weather():
    R1 = 1
    rng = random.unifrom(0.0, 1.0)

    if rng < 0.6:
        weather = 2
    elif rng < 0.8:
        weather = 10
    else:
        weather = 7
    return

def costOfTheDay():
    if day < 3:
        cost = 0.02
    elif day < 7:
        cost = 0.04
    else:
        cost = 0.05
    return

def randomEvents():
    streetCrewThirsty = False
    thunderstorms = False

    if random.uniform(0.0, 1.0) < 0.25 :
        print "THE STREET DEPARTMENT IS WORKING TODAY."
        print "THERE WILL BE NO TRAFFIC ON YOUR STREET."
        if(random.randint(0,2) < 1):
            streetCrewThirsty = True
        else:
            R1 = 0.1
    else:
        if weather == 10:
            if random.uniform(0.0, 1.0) < 0.25:
                G = 0
                thunderstorms = True
            else:
                J = 30 + int(math.floor(random.uniform(0.0, 1.0)*5*10))
                print "THERE IS A " + J + "% CHANCE OF LIGHT RAIN"
                print "AND THE WEATHER IS COOLER TODAY."
                R1 = 1 - J/100.0
        
        if weather == 7:
            print "A HEAT WAVE IS PREDICTED FOR TODAY!"
            R1 = 2
    
    return
    
def processOfOneStand(currentStand):
    while currentStand < numOfPlayers:
        tryAgain = True
        while tryAgain:
            id = s[currentStand].id
            assets = s[currentStand].assets
            expense = 0

            # Deciding the cost of the day
            costOfTheDay()
            if currentStand > 0:
                text.border
            
            # Display cost and stand info
            text.costOfLemonade(day, cost)
            text.standInfo(id, assets)

            # 1. if bankrupt
            # 1a. display You Are Bankrupt No Decisions to Make
            # 2. if not bankrupt
            # 2a. ask questions
            # 3. always ask to change anything
            if s[currentStand].isBankrupt == True:
                text.youAreBankruptNoDecisions()
            else:
                # How many cups of lemonade to make
                text.askHowManyCups()
                makeLemonade()
                assets -= (cups*cost)

                # How many signs to make
                text.askHowManySigns()
                makeSigns(assets)

                # Add the cost of signs and the cost of lemonade
                # Subtracting expense of signs and lemonade from assets
                expense = ((cups*cost)+(signs*S3))

                text.askToSetPrice()
                setPrice()
            
            text.askToChangeAnything()
            tryAgain = askYesOrNo()

            if not tryAgain: # break out of do-while loop
                break        # if user does not want to reinput values
        #END DO-WHILE LOOP

        # Selling the lemonade
        # if street crew is thirsty
        # sell all the lemonade
        # if thunderstorms
        #  display weather report on financial report
        #  sell no lemonade
        # else
        #  sell lemonade like normal
        if streetCrewThirsty == True:
            text.streetCrewBoughtAllYourLemonade()
            cupsSold = cups
        elif thunderstorms == True:
            text.thunderstorms()
            cupsSold = 0
        else:
            sellLemonade()
        
        s[currentStand].setAll(price, expense, income, profit, cups, cupsSold, signs)

        # Calculate assets and set to current stand
        assets = assets + profit
        s[currentStand].assets = assets
        
        currentStand += 1
    return

def makeLemonade():
    cupSet = False

    while not cupSet:
        try:
            c = input("WISH TO MAKE?")
        
            cups = int(c)
            if cups >= 0 and cups < 1000:
                if (cups*cost) > assets:
                    print "THINK AGAIN!!! YOU HAVE ONLY ${:.2F}".format(assets)
                    print
                    print "IN CASH AND TO MAKE {:d} GLASSES OF".format(cups)
                    print
                    print "LEMONADE YOU NEED ${:.2f} IN CASH".format((cups*cost))
                    print
                else:
                    cupSet = True
            else:
                print "COME ON, LET'S BE REASONABLE NOW!!!"
                print "TRY AGAIN"
        except:
            text.tryANewNumber()
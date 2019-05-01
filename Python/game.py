import text

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
            assetSet = false
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
                        assetSet = true
                    elif assets > 40:
                        print "JUST TO BE FAIR, LET'S MAKE THAT $10.00"
                        print
                        assets = 10.00
                        assetSet = true
                    else:
                        assetSet = true
                except:
                    assetSet = false
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


                
        

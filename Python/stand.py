class Stand:
    def __init__(self, id):
        self.id = id
        self.assets = 2.00
        self.isBankrupt = False

s = [Stand(3), Stand(4)]
currentStand = 0
while currentStand < len(s):
    print "{} {:d} {} {:.2f}".format("STAND", s[currentStand].id, "ASSETS", s[currentStand].assets)
    currentStand += 1
//
// Created by raula on 1/25/2021.
//

#include "Text.h"
#include <iostream>
using namespace std;

void Text::border() {
    cout << "________________________________________";
}

void Text::titlePage() {
    cout << "HI! WELCOME TO LEMONSVILLE, CALIFORNIA!" << endl;
    cout << endl;
    cout << "IN THIS SMALL TOWN, YOU ARE IN CHARGE OF" << endl;
    cout << "RUNNING YOUR OWN LEMONADE STAND. YOU CAN" << endl;
    cout << "COMPETE WITH AS MANY OTHER PEOPLE AS YOU CAN" << endl;
    cout << "WISH, BUT HOW MUCH PROFIT YOU MAKE IS UP" << endl;
    cout << "TO YOU (THE OTHER STANDS' SALES WILL NOT)" << endl;
    cout << "AFFECT YOUR BUSINESS IN ANY WAY). IF YOU" << endl;
    cout << "MAKE THE MOST MONEY, YOU'RE THE WINNER!!" << endl;
    cout << endl;
    cout << "ARE YOU STARTING A NEW GAME? (YES OR NO)" << endl;
    cout << "TYPE YOUR ANSWER AND HIT RETURN ==> " << endl;
}

void Text::newBusiness() {
    cout << "TO MANAGE YOUR LEMONADE STAND, YOU WILL" << endl;
    cout << "NEED TO MAKE THESE DECISIONS EVERY DAY:" << endl;
    cout << "1. HOW MANY GLASSES OF LEMONADE TO MAKE" << endl;
    printf("%40s%n", "(ONLY ONE BATCH IS MADE EACH MORNING)");
    cout << "2. HOW MANY ADVERTISING SIGNS TO MAKE" << endl;
    printf("%38s%n", "(THE SIGNS COST FIFTEEN CENTS EACH)");
    cout << "3. WHAT PRICE TO CHARGE FOR EACH GLASS" << endl;
    cout << endl;
    cout << "YOU WILL BEGIN WITH $2.00 CASH (ASSETS)." << endl;
    cout << "BECAUSE YOUR MOTHER GAVE YOU SOME SUGAR," << endl;
    cout << "YOUR COST TO MAKE LEMONADE IS TWO CENTS" << endl;
    cout << "A GLASS (THIS MAY CHANGE IN THE FUTURE)." << endl;
    cout << "\t(HIT RETURN TO CONTINUE)" << endl;
}

void Text::newBusiness2() {
    cout << "YOUR EXPENSE ARE THE SUM OF THE COST OF" << endl;
    cout << "THE LEMONADE AND THE COST OF THE SIGNS." << endl;
    cout << endl;
    cout << "YOUR PROFITS ARE THE DIFFERENCE BETWEEN" << endl;
    cout << "THE INCOME FROM THE SALES AND YOUR EXPENSES." << endl;
    cout << endl;
    cout << "THE NUMBER OF GLASSES YOU SELL EACH DAY" << endl;
    cout << "DEPENDS ON THE PRICE YOU CHARGE, AND ON" << endl;
    cout << "THE NUMBER OF ADVERTISING SIGNS YOU USE." << endl;
    cout << endl;
    cout << "KEEP TRACK OF YOUR ASSETS, BECAUSE YOU" << endl;
    cout << "CAN'T SPEND MORE MONEY THAN YOU HAVE!" << endl;
    cout << "\t(HIT RETURN TO CONTINUE)" << endl;
}

void Text::continueOldGame() {
    cout << "HI AGAIN! WELCOME BACK TO LEMONSVILLE! " << endl;
    cout << "LET'S CONTINUE YOUR LAST GAME FROM WHERE" << endl;
    cout << "YOU LEFT IT LAST TIME. DO YOU REMEMBER " << endl;
    cout << "WHAT DAY NUMBER IT WAS? " << endl;
}

void Text::askHowManyPlayers() {
    cout << "HOW MANY PEOPLE WILL BE PLAYING?" << endl;
}

void Text::cantAcceptThatMany() {
    cout << "CAN'T ACCEPT THAT MANY PLAYERS." << endl;
    cout << "PLEASE ENTER A NEW NUMBER:" << endl;
}

void Text::tryNewNumber() {
    cout << "TRY A NEW NUMBER." << endl;
}

void Text::forecastToday(int weather) {
    string forecast;
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
    cout << "The forecast today is " << forecast << endl;
}

void Text::costOfLemonade(int day, float cost) {
    cout << endl;
    cout << "ON DAY" << day << ", THE COST OF LEMONADE IS $" << cost;
    if(day == 3) {
        cout << "(YOUR MOM QUIT GIVING YOU FREE SUGAR)" << endl;
    } else if(day == 7) {
        cout << "(THE PRICE OF LEMONADE MIX JUST WENT UP)" << endl;
    }
}

void Text::standInfo(int id, float assets) {
    printf("%n%s \t %s %.2f%n", "Lemonade Stand ", "Assets", assets)
}
#include <iostream>

using namespace std;

int main() {
    bool playAgain = true;
    string answer;
    Game game = new Game();

    while(playAgain) {
        game.play();

        cout << "WOULD  YOU LIKE TO PLAY AGAIN? ";
        answer = "";
        playAgain = (answer[0] == 'y' || answer[0] == 'Y');
    }

    return 0;
}

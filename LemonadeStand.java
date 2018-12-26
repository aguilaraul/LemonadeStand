/*
 * @author  Raul Aguilar
 * @date    December 25, 2018
 */
package lemonadestand;

import java.util.Scanner;

public class LemonadeStand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tryAgain = true;
        String answer;

        while(tryAgain) {
            tryAgain = false;
            Game game = new Game();
            game.Game();

            System.out.println("WOULD YOU LIKE TO PLAY AGAIN? ");
            answer = "";
            if( in.hasNext() ) {
                answer = in.next();
            }
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                tryAgain = true;
            } else {
                tryAgain = false;
            }
        }

    }
}
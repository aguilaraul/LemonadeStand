/*
 * @author  Raul Aguilar
 * @date    December 30, 2018
 */
package lemonadestand;

import java.util.Scanner;

public class LemonadeStand {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tryAgain = true;
        String answer;
        Game game = new Game();

        while(tryAgain) {
            game.Game();

            System.out.println("WOULD YOU LIKE TO PLAY AGAIN? ");
            answer = "";
            if( in.hasNext() ) {
                answer = in.next();
            }
            tryAgain = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
        }
        System.exit(0);
    }
}
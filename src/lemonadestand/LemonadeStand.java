/*
 * @author  Raul Aguilar
 * @date    March 30, 2019
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
            game.play();

            System.out.println("WOULD YOU LIKE TO PLAY AGAIN? ");
            answer = "";
            if( in.hasNext() ) {
                answer = in.next();
            }
            tryAgain = answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
        }
        in.close();
        System.exit(0);
    }
}

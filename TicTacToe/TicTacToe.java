package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    private static void PlayGame(String p1, String p2, Integer amtGames){
        Game game = new Game(p1, p2, amtGames);
        game.play();
    }
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        System.out.println("h for human player,\ns for smart AI,\nd for dumb AI,\np for perfect AI,\nr for random AI.");
        System.out.print("Player 1: ");
        String p1 = s.nextLine();
        System.out.print("Player 2: ");
        String p2 = s.nextLine();
        System.out.println("How many games do you want to play? ");
        int amtGames = s.nextInt();
        
        PlayGame(p1, p2, amtGames);
    }
}

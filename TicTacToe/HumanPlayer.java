package TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends IPlayer{
    public int wins;
    int peice;
    public HumanPlayer(int peice){
        this.wins = 0;
        this.peice = peice;
    }
    public int makeMove(Board board){
        Scanner s = new Scanner(System.in);
        System.out.println("You are " + Globals.peiceToString(peice));
        System.out.println(board);
        System.out.println("Enter a number, one through nine, to place the peice:");
        return s.nextInt() - 1;
    }
}

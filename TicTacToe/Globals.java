package TicTacToe;

public class Globals {
    static public int X = -1;
    static public int BLANK = 0;
    static public int O = 1;
    static public String peiceToString(int peice){
        if(peice == X){
            return "X";
        }else if(peice == O){
            return "O";
        }else{
            return " ";
        }
    }
}

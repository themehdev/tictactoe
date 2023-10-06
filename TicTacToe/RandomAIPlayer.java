package TicTacToe;

public class RandomAIPlayer extends IPlayer {
    public int wins;
    int peice;
    public RandomAIPlayer(int peice){
        this.wins = 0;
        this.peice = peice;
    }
    public int makeMove(Board board){
        System.out.println("You are " + Globals.peiceToString(peice));
        System.out.println("AI is making a move...");
        int[] possibles = new int[9];
        int pushOn = 0;
        for(var i = 0; i < 9; i ++){
            //System.out.println(state[i]);
            if(board.state[i] == Globals.BLANK){
                possibles[pushOn] = i;
                pushOn ++;
            }
        }
        return possibles[(int) Math.floor(Math.random() * pushOn)];
    }
}

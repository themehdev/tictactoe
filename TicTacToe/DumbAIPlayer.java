package TicTacToe;

public class DumbAIPlayer extends IPlayer{
    public int wins;
    int peice;
    public DumbAIPlayer(int peice){
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
        //Determine if we can win
        int line = 0;
        int[] toWin = new int[3];
        for(int i = 0; i < board.winningPos.length; i ++){
            line = 0;
            toWin = new int[]{board.winningPos[i][0], board.winningPos[i][1], board.winningPos[i][2]};
            for(int j = 0; j < 3; j ++){
                line += board.state[board.winningPos[i][j]];
                if(board.state[board.winningPos[i][j]] == peice){
                    toWin[j] = -1;
                }
            }
            //System.out.println(line);
            if (line == 2 * peice){
                for(int j = 0; j < 3; j ++){
                    if(toWin[j] != -1){
                        if(board.state[toWin[j]] == 0){
                            return toWin[j];
                        }
                    }
                }
            }
        }
        return possibles[(int) Math.floor(Math.random() * pushOn)];
    }
}

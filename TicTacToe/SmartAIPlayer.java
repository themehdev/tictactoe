package TicTacToe;

public class SmartAIPlayer extends IPlayer{
    public int wins;
    int peice;
    public SmartAIPlayer(int peice){
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
        int[] placeholder = new int[3];
        for(int i = 0; i < board.winningPos.length; i ++){
            line = 0;
            toWin = new int[]{board.winningPos[i][0], board.winningPos[i][1], board.winningPos[i][2]};
            placeholder = board.winningPos[i];
            for(int j = 0; j < 3; j ++){
                line += board.state[board.winningPos[i][j]];
                if(board.state[board.winningPos[i][j]] == peice){
                    toWin[j] = -1;
                    //System.out.println(board.winningPos[i][j]);
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
            board.winningPos[i] = board.winningPosStable[i];
        }
        //Determine if we need to block
        line = 0;
        toWin = new int[3];
        placeholder = new int[3];
        for(int i = 0; i < board.winningPos.length; i ++){
            line = 0;
            toWin = new int[]{board.winningPos[i][0], board.winningPos[i][1], board.winningPos[i][2]};
            placeholder = board.winningPos[i];
            for(int j = 0; j < 3; j ++){
                line += board.state[board.winningPos[i][j]];
                if(board.state[board.winningPos[i][j]] == -1 * peice){
                    toWin[j] = -1;
                    //System.out.println(board.winningPos[i][j]);
                }
            }
            //System.out.println(line);
            if (line == -2 * peice){
                for(int j = 0; j < 3; j ++){
                    if(toWin[j] != -1){
                        if(board.state[toWin[j]] == 0){
                            return toWin[j];
                        }
                    }
                }
            }
            board.winningPos[i] = board.winningPosStable[i];
        }
        //System.out.println(possibles[0]);
        if(board.state[4] == 0){
            return 4;
        }
        
        if(board.state[0] == -1 * peice && board.state[8] == -1 * peice && board.state[1] == Globals.BLANK){
            return 1;
        }
        if(board.state[0] == 0){
            return 0;
        }
        if(board.state[2] == 0){
            return 2;
        }
        if(board.state[6] == 0){
            return 6;
        }
        if(board.state[8] == 0){
            return 8;
        }
        /* for(int k = 0; k < possibles.length; k ++){
            if(possibles[k] == 1){
                return 1;
            }
            if(possibles[k] == 3){
                return 3;
            }
            if(possibles[k] == 5){
                return 5;
            }
            if(possibles[k] == 7){
                return 7;
            }
        } */
        return possibles[(int) Math.floor(Math.random() * pushOn)];
    }
}

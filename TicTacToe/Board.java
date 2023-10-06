package TicTacToe;

public class Board {
    public int[] state = new int[9];
    public int[][] winningPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public int[][] winningPosStable = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    public Board(){
        for(var i = 0; i < state.length; i ++){
            state[i] = Globals.BLANK;
        }
    }

    public boolean setPeice(int idx, int type){
        /* System.out.println(type);
        System.out.println(idx); */
        if ((type != Globals.O && type != Globals.X) || idx > 8 || idx < 0){
            System.out.println("Enter a different number, between one and nine this time!");
            System.out.println(idx);
            return false;
        }
        if (state[idx] != Globals.BLANK){
            System.out.println("Enter a different number. Pick an open spot this time!");
            System.out.println(idx);
            return false;
        }
        state[idx] = type;
        return true;
    }
    public int hasWon(){
        int line = 0;
        for(int i = 0; i < winningPos.length; i ++){
            line = 0;
            for(int j = 0; j < 3; j ++){
                line += state[winningPos[i][j]];
            }
            //System.out.println(line);
            if (Math.abs(line) == 3){
                return line/3;
            }
        }
        return 0;
    }
    public boolean isFull(){
        boolean check = true;
        for(var i = 0; i < 9; i ++){
            //System.out.println(state[i]);
            if(state[i] == Globals.BLANK){
                check = false;
                break;
            }
        }
        return check;
    }
    public String toString(){
        return Globals.peiceToString(state[0]) + "|" + Globals.peiceToString(state[1]) + "|" + Globals.peiceToString(state[2])
        + "\n-----\n" + Globals.peiceToString(state[3]) + "|" + Globals.peiceToString(state[4]) + "|" + Globals.peiceToString(state[5])
        + "\n-----\n" + Globals.peiceToString(state[6]) + "|" + Globals.peiceToString(state[7]) + "|" + Globals.peiceToString(state[8]);
    }
    public void clear(){
        for(var i = 0; i < state.length; i ++){
            state[i] = Globals.BLANK;
        }
    }

}

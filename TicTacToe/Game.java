package TicTacToe;

public class Game {
    IPlayer p1;
    IPlayer p2;
    String p1Is;
    String p2Is;
    int games;
    public Board board = new Board();
    public Game(String p1, String p2, int amt){
        switch(p1){
            case "h" :
                this.p1 = new HumanPlayer(Globals.X);
                break;
            case "s":
                this.p1 = new SmartAIPlayer(Globals.X);
                break;
            case "d":
                this.p1 = new DumbAIPlayer(Globals.X);
        }
        p1Is = p1;
        switch(p2){
            case "h":
                this.p2 = new HumanPlayer(Globals.O);
                break;
            case "s":
                this.p2 = new SmartAIPlayer(Globals.O);
                break;
            case "d":
                this.p2 = new DumbAIPlayer(Globals.O);
        }
        p2Is = p2;
        /* System.out.println(this.p1);
        System.out.println(this.p2); */
        this.games = amt;
    }
    public void play(){
        for(int i = 0; i < games; i ++){
            while(true){
                System.out.print("Player 1's turn. ");
                while(! board.setPeice(p1.makeMove(board), Globals.X)){}
                if(board.hasWon() == Globals.X){
                    System.out.println(board);
                    System.out.println("Player 1 (X) wins!");
                    p1.wins += 1;
                    break;
                }
                if(board.isFull()){
                    System.out.println(board);
                    System.out.println("The board is full; it is a tie.");
                    break;
                }
                
                System.out.print("Player 2's turn. ");
                while(! board.setPeice(p2.makeMove(board), Globals.O)){}
                if(board.hasWon() == Globals.O){
                    p2.wins += 1;
                    System.out.println(board);
                    System.out.println("Player 2 (O) wins!");
                    break;
                }
                if(board.isFull()){
                    System.out.println(board);
                    System.out.println("The board is full; it is a tie.");
                    break;
                }
            }
            board.clear();
        }
        System.out.println("Game over.");
        System.out.println("Player 1 won " + p1.wins + " times.");
        System.out.println("Player 2 won " + p2.wins + " times.");
        if(p1.wins > p2.wins){
            System.out.println("Player 1 wins the game!");
        }else if(p1.wins < p2.wins){
            System.out.println("Player 2 wins the game!");
        }else{
            System.out.println("It is a tie.");
        }
    }
}

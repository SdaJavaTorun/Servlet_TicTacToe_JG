package pl.sdaacademy.model;


public class TicTacToe {


    private int [] [] board = {{0,0,0}, {0,0,0}, {0,0,0}};

    private int currentPlayer = 1;


    public boolean isFieldEmpty(int x , int y) {
        return board [x][y] == 0;
    }

    private void togglePlayer(){
        if(currentPlayer == 1) {
            currentPlayer =2;
        } else {
            currentPlayer =1;
        }
    }

    public boolean setField(int x , int y) {
        if (isFieldEmpty(x,y)){
            board [x][y] = currentPlayer;
            togglePlayer();
            return true;
        }
        return false;
    }
    public int getField(int x, int y){
        return board[x][y];
    }

    public boolean isXWinner(){
        return isWinner(2);
    }

    public boolean isOWinner(){
        return isWinner(1);
    }
    public boolean isWinner (int player){
         return  (board[0][0] == player && board[0][1] == player && board[0][2] == player) ||
                 (board[1][0] == player && board[1][1] == player && board[1][2] == player) ||
                 (board[2][0] == player && board[2][1] == player && board[2][2] == player) ||
                 (board[0][0] == player && board[1][0] == player && board[2][0] == player) ||
                 (board[0][1] == player && board[1][1] == player && board[2][1] == player) ||
                 (board[0][2] == player && board[1][2] == player && board[2][2] == player) ||
                 (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                 (board[2][0] == player && board[1][1] == player && board[0][2] == player);
    }
    public void zero(){
        board [0][0] = 0; board[0][1] = 0; board [0][2] = 0;
        board [1][0] = 0; board[1][1] = 0; board [1][2] = 0;
        board [2][0] = 0; board[2][1] = 0; board [2][2] = 0;

    }

}

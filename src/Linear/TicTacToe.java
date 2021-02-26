package Linear;
import java.util.Arrays;

public class TicTacToe {
    private final Board[][] board;
    private Board player;

    public TicTacToe(char player) {
        this.board = new Board[3][3];
        this.player = player == 'X' ? Board.X : Board.O;
        for (Board[] boards : board) {
            Arrays.fill(boards, Board.EMPTY);
        }
    }

    public Board[][] getBoard() {
        return board;
    }

    public void clearBoard(){
        for (Board[] boards : board) {
            Arrays.fill(boards, Board.EMPTY);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
       for(int row = 0; row < board.length; row++){
           for(int column = 0; column < board[row].length; column++){
               switch (board[row][column]){
                   case EMPTY -> builder.append(" ");
                   case O -> builder.append("O");
                   case X -> builder.append("X");
               }
               if(column < 2)
                   builder.append(" | ");
           }
           if (row < 2)
               builder.append("\n---------\n");
       }
      return builder.toString();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe('O');
        System.out.println(game.toString());
    }

    public void switchPlayer() {
        if (player == Board.O)
            player = Board.X;
        else
            player = Board.O;
    }

    public Board getPlayer() {
        return player;
    }

    public void play(int rowCount, int columnCount) {
        if(rowCount < 0 || rowCount > board.length - 1 || columnCount < 0 || columnCount > board.length - 1){
            throw new IllegalArgumentException("Invalid cell position");
        }
        if(board[rowCount][columnCount] != Board.EMPTY){
            throw new IllegalArgumentException("Cell board is occupied");
        }else{
            board[rowCount][columnCount] = player;
            switchPlayer();
        }
    }

    public boolean checkWin() {
//        Check if each element in each row are the same
        boolean isValid = false;
        if(checkRowWin(Board.O) || checkRowWin(Board.X))
            isValid = true;
//        check if each element in each column are the same
//        Check if each element in diagonal direction are the same
        return isValid;
    }

    private boolean checkRowWin(Board piece){
        for (Board[] boards : board) {
            for (int column = 0; column < boards.length; column++) {
                if (boards[column] == piece) {
                    if (column == board.length - 1) {
                        return true;
                    }
                }
                if (boards[column] != piece) {
                    return false;
                }
            }
        }
        return false;
    }
}


package Linear.array;

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
        boolean isValid = false;
        if(checkRowWin() || checkColumnWin() || checkDiagonalWin())
            isValid = true;
        return isValid;
    }

    private boolean checkRowWin(){
        boolean isValid = false;
        for (Board[] boards : board) {
            if (checkRowAndColumnElement(boards[0], boards[1], boards[2])) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private boolean checkColumnWin() {
        boolean isValid = false;
        for(int column = 0; column < board.length; column++){
            if(checkRowAndColumnElement(board[0][column], board[1][column], board[2][column])){
                isValid = true;
                break;
            }
        }
        return isValid;

    }

    private boolean checkDiagonalWin() {
        boolean isValid = false;
            if((checkRowAndColumnElement(board[0][0], board[1][1], board[2][2])) || (checkRowAndColumnElement(board[0][2], board[1][1], board[2][0]))){
                isValid = true;
        }
        return isValid;

    }


    private boolean checkRowAndColumnElement(Board piece1, Board piece2, Board piece3){
        boolean isEqual =  ((piece1 != Board.EMPTY) && (piece1 == piece2) && (piece2 == piece3));
        return isEqual;
    }

    public boolean isFull() {
        for (Board[] boards : board) {
            for (Board value : boards) {
                if (value == Board.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}


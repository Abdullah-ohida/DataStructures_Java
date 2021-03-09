package Linear.tictactoe;

import java.util.Arrays;
import static Linear.tictactoe.Cell.*;

public class TicTacToe {
    private final Cell[][] cell;
    private Cell player;

    public TicTacToe(char player) {
        this.cell = new Cell[3][3];
        this.player = player == 'X' ? X : O;
        for (Cell[] cells : cell) {
            Arrays.fill(cells, EMPTY);
        }
    }

    public Cell[][] getBoard() {
        return cell;
    }

    public void clearBoard(){
        for (Cell[] cells : cell) {
            Arrays.fill(cells, EMPTY);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
       for(int row = 0; row < cell.length; row++){
           for(int column = 0; column < cell[row].length; column++){
               switch (cell[row][column]){
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
        if (isEmpty(player, O)) player = X;
        else player = O;
    }

    public Cell getPlayer() {
        return player;
    }

    public void play(int rowCount, int columnCount) {
        boolean isInvalidCell = rowCount < 0 || rowCount > cell.length - 1 || columnCount < 0 || columnCount > cell.length - 1;
        if(isInvalidCell) throw new IllegalArgumentException("Invalid cell position");

        boolean isOccupied = cell[rowCount][columnCount] != EMPTY;
        if(isOccupied) throw new IllegalArgumentException("Cell board is occupied");

        else playOn(rowCount, columnCount);

    }

    private void playOn(int rowCount, int columnCount) {
        cell[rowCount][columnCount] = player;
        switchPlayer();
    }

    public boolean checkWin() {
        return isValidPattern();
    }

    private boolean isValidPattern() {
        return checkRowWin() || checkColumnWin() || checkDiagonalWin();
    }

    private boolean checkRowWin(){
        boolean isValid = false;
        for (Cell[] cells : cell) {
            if (isValidRowPattern(cells)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private boolean isValidRowPattern(Cell[] cells) {
        return checkRowAndColumnElement(cells[0], cells[1], cells[2]);
    }

    private boolean checkColumnWin() {
        boolean isValid = false;
        for(int column = 0; column < cell.length; column++){
            if(isValidColumnPattern(column)){
                isValid = true;
                break;
            }
        }
        return isValid;

    }

    private boolean isValidColumnPattern(int column) {
        return checkRowAndColumnElement(cell[0][column], cell[1][column], cell[2][column]);
    }

    private boolean checkDiagonalWin() {
        boolean isValid = false;
            if(isValidDiagonalPattern()){
                isValid = true;
        }
        return isValid;

    }

    private boolean isValidDiagonalPattern() {
        return (checkRowAndColumnElement(cell[0][0], cell[1][1], cell[2][2])) ||
                (checkRowAndColumnElement(cell[0][2], cell[1][1], cell[2][0]));
    }


    private boolean checkRowAndColumnElement(Cell firstPiece, Cell secondPiece, Cell thirdPiece){
        boolean isEqualCell =  ((firstPiece != EMPTY) && (isEmpty(firstPiece, secondPiece)) && (isEmpty(secondPiece, thirdPiece)));
        return isEqualCell;
    }

    public boolean isFull() {
        for (Cell[] cells : cell) {
            for (Cell value : cells) {
                if (isEmpty(value, EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isEmpty(Cell value, Cell empty) {
        return value == empty;
    }
}


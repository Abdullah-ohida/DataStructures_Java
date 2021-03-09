package Linear.tictactoe;

import java.security.SecureRandom;
import java.util.Arrays;

public class ComputerTictactoe{

    private final Cell[][] cell;
    private Player player;
    private Cell humanPiece;
    private Cell computerPiece;
    int count = 0;

    public ComputerTictactoe(char piece) {
        if(piece == 'X'){
            this.humanPiece = Cell.X;
            this.computerPiece = Cell.O;
        }else {
            this.humanPiece = Cell.O;
            this.computerPiece = Cell.X;
        }

        player = Player.HUMAN;
        cell = new Cell[3][3];
        for (Cell[] cells : cell) {
            Arrays.fill(cells, Cell.EMPTY);
        }
    }

    public Cell[][] getCell() {
        return cell;
    }

    public void clearCell(){
        for (Cell[] cells : cell) {
            Arrays.fill(cells, Cell.EMPTY);
        }
    }

    public void switchPlayer() {
        if (player == Player.COMPUTER)
            player = Player.HUMAN;
        else
            player = Player.COMPUTER;
    }

    public Player getPlayer() {
        return player;
    }

    public void play(int rowCount, int columnCount){
        if(player == Player.COMPUTER)
            computerPlay();
        else
            humanPlay(rowCount, columnCount);
    }

    public void humanPlay(int rowCount, int columnCount) {
        if(rowCount < 0 || rowCount > cell.length - 1 || columnCount < 0 || columnCount > cell.length - 1){
            throw new IllegalArgumentException("Invalid cell position");
        }
        if(cell[rowCount][columnCount] != Cell.EMPTY){
            throw new IllegalArgumentException("Cell board is occupied");
        }else{
            cell[rowCount][columnCount] = humanPiece;
            count++;
            switchPlayer();
        }
    }

    public void computerPlay(){
        if(count == 1){
            playRandom();
            switchPlayer();
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

    private void playRandom() {
        SecureRandom random = new SecureRandom();
        int row = random.nextInt(3);
        int column = random.nextInt(3);
        if(cell[row][column] != Cell.EMPTY){
           playRandom();
        }
        cell[row][column] = computerPiece;
    }


    public static void main(String[] args) {
        ComputerTictactoe computerTictactoe = new ComputerTictactoe('X');
        computerTictactoe.play(1, 0);
        computerTictactoe.play(2, 1);
        String tic = computerTictactoe.toString();
        System.out.println(tic);
    }
}

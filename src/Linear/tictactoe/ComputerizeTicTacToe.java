package Linear.tictactoe;

import java.security.SecureRandom;
import java.util.Arrays;

import static Linear.tictactoe.Cell.EMPTY;

public class ComputerizeTicTacToe extends Playable{
    private Player player;
    private final Cell humanPiece;
    private final Cell computerPiece;

    public ComputerizeTicTacToe(char piece) {
        player = Player.HUMAN;
        if (piece == 'X') {
            this.humanPiece = Cell.X;
            this.computerPiece = Cell.O;
        } else {
            this.humanPiece = Cell.O;
            this.computerPiece = Cell.X;
        }

        for (Cell[] cells : cell) {
            Arrays.fill(cells, EMPTY);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void switchPlayer(){
        if (player == Player.COMPUTER) player = Player.HUMAN;
        else player = Player.COMPUTER;
    }

    public void play(int rowCount, int columnCount){
        if(player == Player.COMPUTER)
            computerPlay();
        else
            humanPlay(rowCount, columnCount);
    }

    public void humanPlay(int rowCount, int columnCount) {
        boolean isInvalidCell = rowCount < 0 || rowCount > cell.length - 1 || columnCount < 0 || columnCount > cell.length - 1;
        if(isInvalidCell) throw new IllegalArgumentException("Invalid cell position");

        boolean isOccupied = cell[rowCount][columnCount] != EMPTY;
        if(isOccupied) throw new IllegalArgumentException("Cell board is occupied");

        else playOn(rowCount, columnCount);

    }

    private void playOn(int rowCount, int columnCount) {
        cell[rowCount][columnCount] = humanPiece;
        switchPlayer();
    }


    public void computerPlay(){
            playRandom();
            switchPlayer();
    }


    private void playRandom() {
        SecureRandom random = new SecureRandom();
        int row = random.nextInt(3);
        int column = random.nextInt(3);
        if(!isEmpty(cell[row][column])){
           playRandom();
        }
        cell[row][column] = computerPiece;
    }

    private boolean isEmpty(Cell cell1) {
        return cell1 == Cell.EMPTY;
    }

}

package Linear.tictactoe;

import java.security.SecureRandom;
import java.util.Arrays;

import static Linear.tictactoe.Cell.EMPTY;

public class ComputerizeTicTacToe extends Playable{
    private Player player;
    private final Cell humanPiece;
    private final Cell computerPiece;
    int count = 0;

    public ComputerizeTicTacToe(char piece) {
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

    public void switchPlayer(){
        if (player == Player.COMPUTER)
            player = Player.HUMAN;
        else
            player = Player.COMPUTER;
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
        ComputerizeTicTacToe computerTictactoe = new ComputerizeTicTacToe('X');
        computerTictactoe.play(1, 0);
        computerTictactoe.play(2, 1);
        String tic = computerTictactoe.toString();
        System.out.println(tic);
    }
}

package Linear;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe('X');}

    @AfterEach
    void tearDown() {
        ticTacToe = null;
    }

    @Test
    void TicTacToeBoard_canBeGet(){
        assertNotNull(ticTacToe.getBoard());
    }


    @Test
    void TicTacToeBoardIsEmptyAtCreation(){
        for(int row = 0; row < ticTacToe.getBoard().length; row++){
            for(int column = 0; column < ticTacToe.getBoard()[row].length; column++){
                assertEquals(Board.EMPTY, ticTacToe.getBoard()[row][column]);
            }
        }
    }

    @Test
    void TicTacToeCanBeClear(){
        ticTacToe.clearBoard();
        for(int row = 0; row < ticTacToe.getBoard().length; row++){
            for(int column = 0; column < ticTacToe.getBoard()[row].length; column++){
                assertEquals(Board.EMPTY, ticTacToe.getBoard()[row][column]);
            }
        }
    }

    @Test
    void TicTacToe_boardCanDisplay(){
        TicTacToe game = new TicTacToe('Y');
        assertNotNull(game.toString());
        for(int row = 0; row < game.getBoard().length; row++){
            for(int column = 0; column < game.getBoard()[row].length; column++){
                assertEquals(Board.EMPTY, game.getBoard()[row][column]);
            }
        }
    }

    @Test
    void TicTacToe_twoPlayerCanPlayInTurn(){
        ticTacToe.switchPlayer();
        assertEquals(Board.O, ticTacToe.getPlayer());

        ticTacToe.switchPlayer();
        assertEquals(Board.X, ticTacToe.getPlayer());
    }

    @Test
    void TicTacToe_canPlayOnASpecificRowAndColumn(){
        ticTacToe.play(1, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Board.X, ticTacToe.getBoard()[1][2]);

    }

    @Test
    void TicTacToe_canPlayMoreThanOnceOnBoard(){
        ticTacToe.play(1, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Board.X, ticTacToe.getBoard()[1][2]);

        ticTacToe.play(2, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Board.O, ticTacToe.getBoard()[2][2]);

        ticTacToe.play(0, 0);
        System.out.println(ticTacToe.toString());
        assertEquals(Board.X, ticTacToe.getBoard()[0][0]);
    }

    @Test
    void TicTacToe_throwExceptionWhenPlayerPlayOnInvalidCell(){
        assertThrows(IllegalArgumentException.class, ()->ticTacToe.play(3, 2));
    }

    @Test
    void TicTacToe_throwExceptionWhenPlayerPlayOnTheOccupiedCell(){
        ticTacToe.play(1, 2);
        assertThrows(IllegalArgumentException.class, ()->ticTacToe.play(1, 2));
    }


    @Test
    void TicTacToe_checkIfPlayerWinOnRow(){
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 2);
        System.out.println(ticTacToe.toString());

       assertTrue(ticTacToe.checkWin());

        ticTacToe.clearBoard();
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 2);
        System.out.println(ticTacToe.toString());

        assertTrue(ticTacToe.checkWin());
    }


}
package Linear.array;

import Linear.tictactoe.Cell;
import Linear.tictactoe.ComputerizeTicTacToe;
import Linear.tictactoe.Player;
import Linear.tictactoe.TicTacToe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    TicTacToe ticTacToe;
    ComputerizeTicTacToe autoPlay;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe('X');
        autoPlay = new ComputerizeTicTacToe('O');
       }

    @AfterEach
    void tearDown() {
        autoPlay = null;
        ticTacToe = null;
    }

    @Test
    void TicTacToeBoard_canBeGet(){
        assertNotNull(ticTacToe.getCell());
    }


    @Test
    void TicTacToeBoardIsEmptyAtCreation(){
        for(int row = 0; row < ticTacToe.getCell().length; row++){
            for(int column = 0; column < ticTacToe.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, ticTacToe.getCell()[row][column]);
            }
        }
    }

    @Test
    void TicTacToeCanBeClear(){
        ticTacToe.clearCell();
        for(int row = 0; row < ticTacToe.getCell().length; row++){
            for(int column = 0; column < ticTacToe.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, ticTacToe.getCell()[row][column]);
            }
        }
    }

    @Test
    void TicTacToe_boardCanDisplay(){
        TicTacToe game = new TicTacToe('Y');
        assertNotNull(game.toString());
        for(int row = 0; row < game.getCell().length; row++){
            for(int column = 0; column < game.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, game.getCell()[row][column]);
            }
        }
    }

    @Test
    void TicTacToe_twoPlayerCanPlayInTurn(){
        ticTacToe.switchPlayer();
        assertEquals(Cell.O, ticTacToe.getPlayer());

        ticTacToe.switchPlayer();
        assertEquals(Cell.X, ticTacToe.getPlayer());
    }

    @Test
    void TicTacToe_canPlayOnASpecificRowAndColumn(){
        ticTacToe.play(1, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Cell.X, ticTacToe.getCell()[1][2]);

    }

    @Test
    void TicTacToe_canPlayMoreThanOnceOnBoard(){
        ticTacToe.play(1, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Cell.X, ticTacToe.getCell()[1][2]);

        ticTacToe.play(2, 2);
        System.out.println(ticTacToe.toString());
        assertEquals(Cell.O, ticTacToe.getCell()[2][2]);

        ticTacToe.play(0, 0);
        System.out.println(ticTacToe.toString());
        assertEquals(Cell.X, ticTacToe.getCell()[0][0]);
    }

    @Test
    void TicTacToe_throwExceptionWhenPlayerPlayOnInvalidCell(){
        assertThrows(IllegalArgumentException.class, ()-> ticTacToe.play(3, 2));
    }

    @Test
    void TicTacToe_throwExceptionWhenPlayerPlayOnTheOccupiedCell(){
        ticTacToe.play(1, 2);
        assertThrows(IllegalArgumentException.class, ()-> ticTacToe.play(1, 2));
    }


    @Test
    void TicTacToe_checkIfPlayerWinOnRow(){
        ticTacToe.play(1, 1);
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 2);

       assertTrue(ticTacToe.checkWin());

        ticTacToe.clearCell();
        ticTacToe.play(0, 0);
        ticTacToe.play(1, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(2, 0);
        ticTacToe.play(0, 2);


        assertTrue(ticTacToe.checkWin());
    }

    @Test
    void TicTacToe_checkIfPlayerWinOnColumn(){
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 1);
        System.out.println(ticTacToe.toString());

        assertTrue(ticTacToe.checkWin());
    }

    @Test
    void TicTacToe_checkIfPlayerWinOnDiagonal(){
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(1, 1);
        ticTacToe.play(1, 0);
        ticTacToe.play(2, 2);
        ticTacToe.play(2, 1);
        System.out.println(ticTacToe.toString());

        assertTrue(ticTacToe.checkWin());
    }

    @Test
    void TicTacToeBoard_isFullWithoutWinner(){
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(0, 2);
        ticTacToe.play(1, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);
        ticTacToe.play(2, 0);
        ticTacToe.play(2, 1);

        System.out.println(ticTacToe.toString());

        assertTrue(ticTacToe.isFull());
    }

    @Test
    void TicTacToeBoard_isFullNotWithoutWinner(){
        ticTacToe.play(0, 0);
        ticTacToe.play(0, 1);
        ticTacToe.play(0, 2);
        ticTacToe.play(1, 0);
        ticTacToe.play(1, 1);
        ticTacToe.play(2, 2);
        ticTacToe.play(1, 2);

        System.out.println(ticTacToe.toString());

        assertFalse(ticTacToe.isFull());
    }


//    Computer play human
    @Test
        void computerTicTacToeBoard_canBeGet(){
        assertNotNull(autoPlay.getCell());
    }

    @Test
    void computerTicTacToeBoardIsEmptyAtCreation(){
        for(int row = 0; row < autoPlay.getCell().length; row++){
            for(int column = 0; column < autoPlay.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, autoPlay.getCell()[row][column]);
            }
        }
    }


    @Test
    void computerTicTacToeCanBeClear(){
       autoPlay.clearCell();
        for(int row = 0; row < autoPlay.getCell().length; row++){
            for(int column = 0; column < autoPlay.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, autoPlay.getCell()[row][column]);
            }
        }
    }

    @Test
    void computerTicTacToe_boardCanDisplay(){
        ComputerizeTicTacToe game = new ComputerizeTicTacToe('O');
        assertNotNull(game.toString());
        for(int row = 0; row < game.getCell().length; row++){
            for(int column = 0; column < game.getCell()[row].length; column++){
                assertEquals(Cell.EMPTY, game.getCell()[row][column]);
            }
        }
    }


    @Test
    void computerTicTacToe_twoPlayerCanPlayInTurn(){
       assertEquals(Player.HUMAN, autoPlay.getPlayer());
       autoPlay.switchPlayer();
       assertEquals(Player.COMPUTER, autoPlay.getPlayer());
    }

    @Test
    void computerTiTacToe_canPlayOnASpecificRowAndColumn(){
        autoPlay.play(1, 0);
        autoPlay.play(1, 0);
        assertEquals(Cell.O, autoPlay.getCell()[1][0]);
    }

    @Test
    void computerTiTacToe_canPlayMoreThanOnceOnBoard(){
        autoPlay.play(0, 0);
        autoPlay.play(0, 0);
        assertEquals(Cell.O, autoPlay.getCell()[0][0]);


        autoPlay.play(1, 0);
        autoPlay.play(1, 0);
        assertEquals(Cell.O, autoPlay.getCell()[1][0]);
        System.out.println(autoPlay.toString());

    }

}
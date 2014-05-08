package gameTests;

import static org.junit.Assert.*;
import game.Board;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BoardTest {

	@Test
	public void is_full_of_squares() {
		Board board = new Board(10, 10);
		assertTrue(board.getSquare(0, 0) != null);
		assertTrue(board.getSquare(6, 6) != null);
		assertTrue(board.getSquare(9, 9) != null);
	}

	@Test
	public void can_print() {
		Board board = new Board(10, 10);
		board.printBoard();
	}

}

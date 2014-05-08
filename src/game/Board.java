package game;

import java.util.Random;

public class Board {

	private Square[][] gameState;
	private int width;
	private int height;
	private int mines;

	public Board(int width, int height, int mines) {
		if (mines > width * height) {
			throw new toManyMinesException();
		} else {
			this.width = width;
			this.height = height;
			this.mines = mines;
			createBoard();
		}
	}

	public Board(int size, int mines) {
		if (mines > size * size) {
			throw new toManyMinesException();
		} else {
			width = size;
			height = size;
			this.mines = mines;
			createBoard();
		}
	}

	private void createBoard() {
		gameState = new Square[height][width];
		for (int yPos = 0; yPos < height; yPos++) {
			for (int xPos = 0; xPos < width; xPos++) {
				gameState[yPos][xPos] = new Square(false, yPos, xPos, this);
			}
		}
		layMines();
		calculateMineNumbers();
	}

	private void layMines() {
		int minesLayed = 0;
		Random dice = new Random();
		while (minesLayed < mines) {
			Square randomSquare = gameState[dice.nextInt(height)][dice
					.nextInt(width)];
			if (!randomSquare.isMined()) {
				randomSquare.setMined(true);
				minesLayed++;
			}
		}
	}

	private void calculateMineNumbers() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				gameState[y][x].setNumber(surroundingMines(x, y));
			}
		}
	}

	public int surroundingMines(int xPos, int yPos) {
		int totalMines = 0;
		  for (int hPos = Math.max(0, yPos - 1); hPos <= Math.min(height - 1,
				yPos + 1); hPos++) {
			for (int wPos = Math.max(0, xPos - 1); wPos <= Math.min(width - 1,
					xPos + 1); wPos++) {
				if (gameState[hPos][wPos].isMined())
					totalMines++;
			}
		}
		return totalMines;
	}

	public void reveal(int xPos, int yPos) {
		
		Square s = gameState[yPos][xPos];
		if(s.isVisible())
			return;

		s.setVisible(true);

		if (s.getNumber() != 0)
			return;

		for (int hPos = Math.max(0, yPos - 1); hPos <= Math.min(height - 1,
				yPos + 1); hPos++) {
			for (int wPos = Math.max(0, xPos - 1); wPos <= Math.min(width - 1,
					xPos + 1); wPos++) {
				reveal(wPos, hPos);
			}
		}
	}
	
	public void flagMine(int xPos, int yPos)
	{
		gameState[yPos][xPos].onRightClick();
	}

	public Square getSquare(int xPos, int yPos) {
		return gameState[xPos][yPos];
	}
	
	public void gameOver() {
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				gameState[h][w].setVisible(true);
			}
		}
	}
	
}

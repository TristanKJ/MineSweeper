package game;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

public class Square {

	private boolean mined;
	private boolean visible;
	private boolean flagged;
	private int number;
	private MineButton button;

	public Square(boolean mined, int yPos, int xPos, Board b) {
		this.mined = mined;
		visible = false;
		flagged = false;
		number = 0;
		button = new MineButton(b, yPos, xPos);
	}

	public void onLeftClick() {
		if(flagged)
			return;
			setVisible(true);
	}

	public void onRightClick() {
		if(visible)
			return;
		else
		flagged = !flagged;
		
		if (flagged)
			button.setBackground(Color.BLACK);
		else
			button.setBackground(Color.gray);
	}

	public boolean isMined() {
		return mined;
	}

	public void setMined(boolean mined) {
		this.mined = mined;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String toString() {
		if (mined)
			return "X";
		else
			return number + "";
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean vis) {
		if (flagged)
			return;
		
		visible = vis;
		if (visible) {
			if (mined) {
				button.setBackground(Color.red);
			} else {
				showNumberAndColor();
			}
		}
	}
	
	private void showNumberAndColor() {
		switch(number){
		case 0: button.setBackground(Color.white);
			break;
		case 1: button.setBackground(Color.lightGray);
			break;
		case 2: button.setBackground(Color.CYAN);
			break;
		case 3: button.setBackground(Color.BLUE);
			break;
		case 4: button.setBackground(Color.GREEN);
			break;
		case 5: button.setBackground(Color.YELLOW.brighter());
			break;
		case 6: button.setBackground(Color.ORANGE.darker());
			break;
		case 7: button.setBackground(Color.MAGENTA);
			break;
		case 8: button.setBackground(Color.pink);
			break;
		default: button.setBackground(Color.WHITE);
			break;
		}
		if(number != 0)
		button.setText(number + "");
		
	}

	public MineButton getButton() {
		return button;
	}
}

package game;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class MineButton extends JButton { // implements MouseListener{
	private static final long serialVersionUID = 8277126005879944904L;
	private int xPosition;
	private int yPosition;
	private Board board;

	public MineButton(Board b, int yPos, int xPos) {
		yPosition = yPos;
		xPosition = xPos;
		board = b;
		setText(" ");
		this.setBackground(Color.gray);
		//addActionListener(this);
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				if(SwingUtilities.isLeftMouseButton(e))
				board.reveal(xPosition, yPosition);
				else if(SwingUtilities.isRightMouseButton(e))
					board.flagMine(xPosition, yPosition);
			}
		});
	}
	
	public void sendGameOver()
	{
		board.gameOver();
	}

}

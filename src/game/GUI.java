package game;

import java.awt.*;
import java.awt.event.*;
import java.awt.Dialog;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame{
	private int height;
	private int width;
	private Board board;
	public GUI(int height, int width, int mines)
	{
		board = new Board(height, width, mines);
		this.height = height;
		this.width = width;
		makeFrame();
	}
	
	private void makeFrame()
	{
		JPanel panel = new JPanel();
		this.setContentPane(panel);
		this.setLayout(new GridLayout(height,width));
		makeButtons(panel);
		this.pack();
		this.setVisible(true);
	}
	
	private void makeButtons(JPanel panel)
	{
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j<width;j++)
			{
				panel.add(board.getSquare(i, j).getButton());
			}
		}
	}
	
	public void windowClosing(WindowEvent e) {
        dispose();
        System.exit(0);
}
	
}

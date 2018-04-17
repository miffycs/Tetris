package tetris;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Tetris extends JFrame
{
	public Tetris()
	{
		Board board = new Board(this);
		add(board.getStatusBar(), BorderLayout.SOUTH);
		add(board);
		board.start();
		setSize(350, 800); // 245,560
		setTitle("New Tetris Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		Tetris newGame = new Tetris();
		newGame.setLocationRelativeTo(null); // set window to center
		newGame.setVisible(true); // set visible
	}
}
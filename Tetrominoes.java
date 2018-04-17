package tetris;

import java.awt.Color;

public enum Tetrominoes
{
	// No shape
	NoShape(new int[][] { { 0, 0}, { 0, 0}, { 0, 0}, { 0, 0} },
			new Color(  0,   0,   0)),
	// I = cyan
	IShape (new int[][] { {-1,-1}, { 0,-1}, { 0, 0}, { 0, 1} },
			new Color( 10, 186, 181)),
	// J = blue
	JShape (new int[][] { { 1,-1}, { 0,-1}, { 0, 0}, { 0, 1} },
			new Color( 40, 100, 240)),
	// L = orange
	LShape (new int[][] { { 0,-1}, { 0, 0}, { 0, 1}, { 0, 2} },
			new Color(240, 140,  40)),
	// O (box) = yellow
	OShape (new int[][] { { 0, 0}, { 1, 0}, { 0, 1}, { 1, 1} },
			new Color(240, 240,  40)),
	// S = green
	SShape (new int[][] { { 0,-1}, { 0, 0}, { 1, 0}, { 1, 1} },
			new Color(100, 240, 100)),
	// T = magenta bright pink
	TShape (new int[][] { {-1, 0}, { 0, 0}, { 1, 0}, { 0, 1} },
			new Color(200, 100, 200)),
	// Z = red
	ZShape (new int[][] { { 0,-1}, { 0, 0}, {-1, 0}, {-1, 1} },
			new Color(240,  40,  40)),
	;
	
	public int[][] coords;
	public Color color;
	
	private Tetrominoes(int[][] coords, Color c)
	{
		this.coords = coords;
		this.color = c;
	}
}
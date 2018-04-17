package tetris;

import java.util.ArrayList;
import java.util.Random;

public class Shape
{
	private Tetrominoes pieceShape;
	private int[][] coords;
	
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static ArrayList<Integer> shapesCalled = new ArrayList<Integer>();
	
	public Shape()
	{
		coords = new int[4][2];
		setShape(Tetrominoes.NoShape);
	}

	public void setShape(Tetrominoes shape)
	{
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 2; ++j)
			{
				coords[i][j] = shape.coords[i][j];
			}
		}

		pieceShape = shape;
	}

	private void setX(int index, int x)
	{
		coords[index][0] = x;
	}

	private void setY(int index, int y)
	{
		coords[index][1] = y;
	}

	public int x(int index)
	{
		return coords[index][0];
	}

	public int y(int index)
	{
		return coords[index][1];
	}

	public Tetrominoes getShape()
	{
		return pieceShape;
	}
	
	// save the 7 shapes in their set order to static ArrayList list
	// pick a shape randomly out of the available shapes left
	// when all 7 shapes have been called, reset the list to every shape 
	private static int randomSevenShape()
	{
		if (list.isEmpty())
		{	
			for (int i = 0; i<7; i++)
			{
				list.add(i+1);
			}
		}
		
		if (list.size() == 1)
		{
			shapesCalled.add(list.get(0));
			
			list.clear();
			for (int i = 0; i<7; i++)
			{
				list.add(i+1);
			}
			
			return shapesCalled.get(shapesCalled.size()-1);
		}
		
		Random r = new Random();
		int index = r.nextInt(list.size());
		
		shapesCalled.add(list.get(index));
		list.remove(index);
		
		return shapesCalled.get(shapesCalled.size()-1);
	}
	
	// not completely random
	// go through a set of 7 shapes before calling another set 
	public void setRandomShape()
	{
		int x = randomSevenShape();
		Tetrominoes[] values = Tetrominoes.values();
		setShape(values[x]);
	}

	// 
	public int minX()
	{
		int m = coords[0][0];

		for (int i = 0; i < 4; i++)
		{
			m = Math.min(m, coords[i][0]);
		}
		
		return m;
	}
	
	// 
	public int minY()
	{
		int m = coords[0][1];

		for (int i = 0; i < 4; i++)
		{
			m = Math.min(m, coords[i][1]);
		}

		return m;
	}

	// rotate shape counter clockwise
	public Shape rotateLeft()
	{
		if (pieceShape == Tetrominoes.OShape)
			return this;

		Shape result = new Shape();
		result.pieceShape = pieceShape;

		for (int i = 0; i < 4; i++)
		{
			result.setX(i, y(i));
			result.setY(i, -x(i));
		}

		return result;
	}

	// rotate shape clockwise
	public Shape rotateRight()
	{
		if (pieceShape == Tetrominoes.OShape)
			return this;

		Shape result = new Shape();
		result.pieceShape = pieceShape;

		for (int i = 0; i < 4; i++)
		{
			result.setX(i, -y(i));
			result.setY(i, x(i));
		}

		return result;
	}

}

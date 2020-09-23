package numberMap;

import java.awt.Point;
import java.util.Random;

/**
 * A representation of a two-dimensional array of random integers. Here the
 * 2-d array is a square array (the number of rows is the same as the number 
 * of columns).
 * @author Ken Loomis
 */
public class NumberMap 
{
	private int size;
	private int  [][] array;
	
	
	/**
	 * Instantiates the NumberMap with the size given as a parameter. 
	 * Here size refers to the number of squares that appear in the number map.
	 * @param size : int  - A positive number representing the size of the number map
	 * @throws InvalidNumberMapSizeException if the given size is non-positive.
	 */
	public NumberMap(int size) throws InvalidNumberMapSizeException {
		
		if ( size <= 0)
		{
			throw new InvalidNumberMapSizeException ( size );
		}
		this.size = size;
		array = new int[size][size];
		
		Random rand = new Random();
		for ( int row = 0; row<size; row++ )
			for ( int col=0; col<size; col++ )
				array[row][col] = rand.nextInt(100);
	}

	/**
	 * Return the size of the number map
	 * @return the size: int
	 */
	public int getSize() 
	{
		return size;
	}
	
	/**
	 * Return the value stored in the number map at the given row and col coordinates.
	 * @param row: int - the row index in the number map
	 * @param col - the col index in the number map
	 * @return the value at the row and col coordinates: int
	 * @throws InvalidNumberMapCoordinateException if the given coordinates are invalid
	 */
	public int at(int row, int col) throws InvalidNumberMapCoordinateException
	{
		if ( row <0 || row >= size || col <0 || col >= size )
		{
			throw new InvalidNumberMapCoordinateException(row, col);
		}
		return array[row][col];
	}
	
	/**
	 * Determines the sum of all the rows in the number map
	 * @return an array of the sums of each row: int[]
	 */
	public int[] rowSums( )
	{
		int [ ] sum = new int [ size ];
		for ( int row = 0; row < size; row++ )
		{
			for ( int col = 0; col < size; col++ )
			{
				sum[row] += array[row][col];
			}
		}
		return sum;
	}
	
	/**
	 * Determines the sum of all the columns in the number map.
	 * @return an array of the sums of each column: int[]
	 */
	public int[] colSums( )
	{
		int [ ] sum = new int [ size ];
		for ( int row = 0; row < size; row++ )
		{
			for ( int col = 0; col < size; col++ )
			{
				sum[col] += array[row][col];
			}
		}
		return sum;
	}
	
	/**
	 * Determines the coordinates of the largest element in the number map.
	 * @return the coordinates of the maximum element: Point
	 */
	public Point findMaximum ( )
	{
		int x = 0;
		int y = 0;
		int max = 0;
		for ( int row = 0; row < size; row++ )
		{
			for ( int col = 0; col < size; col++ )
			{
				if ( max < array[row][col] )
				{
					max = array[row][col];
					y = row;
					x = col;
				}
			}
		}
		return new Point ( x, y );
	}

	/**
	 * Determines the coordinates of the smallest element in the number map.
	 * @return the coordinates of the minimum element: Point
	 */
	public Point findMinimum( )
	{
		int x = 0;
		int y = 0;
		int min = 100;
		for ( int row = 0; row < size; row++ )
		{
			for ( int col = 0; col < size; col++ )
			{
				if ( min > array[row][col] )
				{
					min = array[row][col];
					y = row;
					x = col;
				}
			}
		}
		return new Point ( x, y );
	}
	
	
	

}

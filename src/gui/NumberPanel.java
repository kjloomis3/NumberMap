package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import numberMap.InvalidNumberMapCoordinateException;
import numberMap.InvalidNumberMapSizeException;
import numberMap.NumberMap;

/** A graphic representation of a 2-dimensional array of number. Here the
 * 2-d array is a square array (the number of rows is the same as the number 
 * of columns). The representation also highlights the minimum and maximum
 * numbers and displays the sums of each row and column.
 * @author Ken Loomis
 *
 */
public class NumberPanel extends JPanel
{

	public static final int SQUARE_SIZE = 35;
	public static final int START_X = 20;
	public static final int START_Y = 40;

	private NumberMap numberMap;
	
	/**
	 * Instantiates the NumberPanel with the size given as a parameter. 
	 * Here size refers to the number of squares that appear in the rows and columns
	 * of the number map, such that the map square in shape.
	 * @param size : int - A positive number representing the size of the number map.
	 * @throws InvalidNumberMapSizeException if the given size is non-positive.
	 */
	public NumberPanel( int size ) throws InvalidNumberMapSizeException 
	{
	
		numberMap = new NumberMap ( size );
		Dimension dim =  new Dimension ( START_X*2 + SQUARE_SIZE*(size+1), 
																	 START_Y*2 + SQUARE_SIZE*(size+1) );
		setPreferredSize( dim );
	
	}

	/**
	 * Draws the components of the NumberPanel arranged in a square shape. It creates a 
	 * graphic representation of the number map such that each number is drawn in its
	 * corresponding row and column. Each column has the sum of the column below it and
	 * each row has the sum of the row to the right. The minimum element is drawn with a
	 * blue square around it and the maximum element is drawn with a red square. 
	 * @param pen : Graphics - draws the graphic components of the number map on the panel.
	 */
	public void paintComponent(Graphics pen) 
	{
		pen.setColor( Color.WHITE );
		pen.fillRect( START_X, START_Y, SQUARE_SIZE * numberMap.getSize() , 
				              SQUARE_SIZE * numberMap.getSize() );
		pen.setColor( Color.BLACK );

		for ( int row = 0; row < numberMap.getSize(); row++ )
			for ( int col = 0; col < numberMap.getSize(); col++ )
			{
				pen.drawRect ( START_X + SQUARE_SIZE * col, START_Y + SQUARE_SIZE * row, 
						                    SQUARE_SIZE, SQUARE_SIZE );
				try {
					pen.drawString(String.format("%3d", numberMap.at(row, col)), 
							                    START_X + SQUARE_SIZE * col + (SQUARE_SIZE  / 4 ), 
							START_Y + SQUARE_SIZE * (row) +  (SQUARE_SIZE * 3 / 4 ) );
				} catch (InvalidNumberMapCoordinateException e) {
					e.printStackTrace();
				}
			}

		Point minLoc = numberMap.findMinimum();
		pen.setColor( Color.BLUE );
		pen.drawRect( START_X + SQUARE_SIZE * minLoc.x+1, START_Y + SQUARE_SIZE * minLoc.y+1, 
				                   SQUARE_SIZE-2, SQUARE_SIZE-2 );

		Point maxLoc = numberMap.findMaximum();
		pen.setColor( Color.RED );
		pen.drawRect( START_X + SQUARE_SIZE * maxLoc.x+1, START_Y + SQUARE_SIZE * maxLoc.y+1, 
				                  SQUARE_SIZE-2, SQUARE_SIZE-2 );

		
		pen.setColor( Color.DARK_GRAY );
		int[] sum = numberMap.rowSums();
		for ( int i=0; i<numberMap.getSize(); i++ )
		{
			pen.drawString(String.format("%3d", sum[i]), 
					                    START_X + SQUARE_SIZE * (numberMap.getSize()) + (SQUARE_SIZE  / 4 ), 
					                    START_Y + SQUARE_SIZE * i +  (SQUARE_SIZE * 3 / 4 ) );
		}
		
		sum = numberMap.colSums();
		for ( int i=0; i<numberMap.getSize(); i++ )
		{
			pen.drawString(String.format("%3d", sum[i]), 
									    START_X + SQUARE_SIZE * (i) + (SQUARE_SIZE  / 4 ), 
									    START_Y + SQUARE_SIZE * numberMap.getSize()+  (SQUARE_SIZE * 3 / 4 ) );
		}
		
		pen.setColor( Color.BLACK );

	}


}

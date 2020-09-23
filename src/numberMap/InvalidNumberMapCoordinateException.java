package numberMap;

/**
 * An exception representing an error that may occur when accessing a number
 * of the NumberMap object by providing invalid coordinates.
 * @author Ken Loomis
 */
public class InvalidNumberMapCoordinateException extends Exception 
{
	/**
	 * Instantiate the exception by indicating the row and column indexes which
	 * cause the exception.
	 * @param row: int - the row coordinate
	 * @param col: int - the column coordinate
	 */
	public InvalidNumberMapCoordinateException(int row, int col)
	{
		super ( "The given coordiantes (" + row + ", " + col + ") is not valid." );
	}
	
}

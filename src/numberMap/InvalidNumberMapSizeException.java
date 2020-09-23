package numberMap;

/**
 * An exception representing a size error that may occur when creating a
 * NumberMap object.
 * @author Ken Loomis
 */
public class InvalidNumberMapSizeException extends Exception {
	
	/**
	 * Instantiates an exception which includes a message indicating the
	 * size which caused the exception.
	 * @param size
	 */
	public InvalidNumberMapSizeException( int size ) {
		super("The given size (" + size + ") is not a valid size.");
	}

}

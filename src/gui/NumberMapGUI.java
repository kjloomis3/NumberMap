package gui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import numberMap.InvalidNumberMapSizeException;

/**
 * Creates a graphic representation of a NumberMap to be displayed in a window. The size of the
 * NumberMap depends upon user input. Requires the use of the the JavaX Swing library. 
 * @author Ken Loomis
 */
public class NumberMapGUI {

	public static void main(String[] args) {
		
		JFrame window = new JFrame ( );
		window.setTitle ( "Number Map" );
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setLayout(new FlowLayout());
		int size = 0;
		 do 
		{
			String strSize = JOptionPane.showInputDialog( "Please enter the size of the number map as an integer (1-20): ");
			try {
				size = Integer.parseInt( strSize );
			} catch ( Exception e ) {
				size = 0;
			}
		} while ( size <= 0 || size > 20 );

		
		NumberPanel panel = null;
		try {
			panel = new NumberPanel ( size );
		} catch (InvalidNumberMapSizeException e) {
			e.printStackTrace();
			System.exit(1);
		}
	
		window.add( panel );
		window.pack();
		
		//window.setResizable( false );
		window.setVisible( true );

	}

}

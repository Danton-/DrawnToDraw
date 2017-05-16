/*
 * BottomPanel.java file
 * Contains all the buttons in the BottomPanel on the screen
 */

/*
 * Package location
 */
package nl.ru.ai.panels;

/*
 * Import packages?
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;

import nl.ru.ai.objects.Labels;

/*
 * LeftPanel class
 * 
 * JPanel = superclass
 * BottomPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class BottomPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public BottomPanel (Labels note) {
		super (); // `super ' calls a function inherited from the parent class ( JPanel )
		
		/* PANEL SETTINGS - START */
		setPreferredSize(new Dimension(Window.WIDTH, 40)); // Set fixed size
		setBackground(Color.DARK_GRAY); // Set background color
		/* PANEL SETTINGS - END */
		
		add (note); // Add global note label to the Bottom Panel
	}
}
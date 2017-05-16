/*
 * Labels.java file
 */

/*
 * Package location
 */
package nl.ru.ai.objects;

/*
 * Import packages?
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * Labels class
 * 
 * JLabel = superclass
 * Labels = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class Labels extends JLabel {

	private static final long serialVersionUID = 1L;

	public Labels (String label, int labelW) {
		super (); // `super ' calls a function inherited from the parent class ( JLabel )
		
		/* LABEL SETTINGS - START */
		setOpaque(true); // Enable background color of label
		setBackground(Color.BLACK);
		setText(label); // Text the labels shows on the screen
		setForeground(Color.WHITE); // Text color
		setPreferredSize(new Dimension(labelW,30));// Width, Height
		/* LABEL SETTINGS - END */
		
		
		//this.setMinimumSize(labelW);
		
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
	}
}
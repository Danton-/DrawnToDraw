package nl.ru.ai;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;

public class Buttons extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Buttons (String Text, int Width, int Height, String Imgsrc, String Tooltip) {
		super(); // `super ' calls a function inherited from the parent class ( JButton )
		
		/* BUTTON SETTINGS - START */
		setPreferredSize(new Dimension(Width, Height));	// set the button size to fixed
		setToolTipText(Tooltip); // set the Tooltip of the button to show info on rollover
		setMargin(new Insets(0, 0, 0, 0)); // to remote the spacing between the image and button's borders
		setOpaque(true); // Enable background color of label
		setBackground(Color.DARK_GRAY);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		
		setText(Text);
	}
}

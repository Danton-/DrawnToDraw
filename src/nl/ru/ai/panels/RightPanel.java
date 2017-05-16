// Gewijzigd door Danny op 25-04-17

/*
 * RightPanel.java file
 * Contains all the widgets in the RightPanel on the screen
 */

/*
 * Package location
 */
package nl.ru.ai.panels;

import java.awt.CardLayout;
/*
 * Import packages?
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import nl.ru.ai.objects.Buttons;
import nl.ru.ai.objects.Labels;
import tools.ColorPicker;
import tools.ShapeModifier;

/*
 * LeftPanel class
 * 
 * JPanel = superclass
 * RightPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class RightPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	DrawPanel DP;
	RightPanel RP = this;
	public ColorPicker CPick;
	public ShapeModifier SModifier;
	Labels Notifications;

	public RightPanel (CardLayout cardLayout, Labels Notifications, DrawPanel DP) {
		super (); // `super ' calls a function inherited from the parent class ( JPanel )
		this.DP = DP;
		this.Notifications = Notifications;
		
		/* PANEL SETTINGS - START */
		setPreferredSize(new Dimension(40, Window.HEIGHT)); // Set fixed size
		setBackground(Color.DARK_GRAY); // Set background color
		/* PANEL SETTINGS - END */
		
		
		//Add a button to the panel . The argument to the JButton constructor will become the text on the button.
		Buttons OButton = new Buttons("<",30,30,Notifications,"","Open right menu to modify",DP,this);
		OButton.setActionCommand("open");
		
		CPick = new ColorPicker(DP);
		CPick.setVisible(false);
		
		SModifier = new ShapeModifier(DP,this);
		SModifier.setVisible(false);
		
		//JPanel master = new JPanel(new CardLayout());
		this.add(OButton);
		this.add(CPick); // Or what ever child you want to add
		this.add(SModifier); // Or what ever child you want to add
		
	}
}
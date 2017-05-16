/*
 * TopPanel.java file
 * Contains all the buttons in the TopMenu on the screen
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
import nl.ru.ai.objects.Buttons;
import nl.ru.ai.objects.Labels;

/*
 * LeftPanel class
 * 
 * JPanel = superclass
 * TopPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	DrawPanel DP;
	Labels Notifications;
	RightPanel RP;

	public TopPanel (Labels Notifications, DrawPanel DP,RightPanel RP) {
		super (); // `super ' calls a function inherited from the parent class ( JPanel )
		this.DP = DP;
		this.Notifications = Notifications;
		this.RP = RP;
		
		/* PANEL SETTINGS - START */
		setPreferredSize(new Dimension(Window.WIDTH, 40)); // Set fixed size
		setBackground(Color.DARK_GRAY); // Set background color
		/* PANEL SETTINGS - END */
		
		
		/* MENU ITEMS - START */
		/*Buttons Save = new Buttons("Save File",100,30,Notifications,"","Save drawpanel to file.",DP,RP);
		Save.setActionCommand("Save");
		add (Save);
		
		Buttons Grid = new Buttons("Set Grid",100,30,Notifications,"","Set grid size.",DP,RP);
		Grid.setActionCommand("Grid");
		add (Grid);*/
		
		Buttons Clear = new Buttons("Clear screen",120,30,Notifications,"","The canvas will be cleared.",DP,RP);
		Clear.setActionCommand("Clear");
		add (Clear);
		
		Buttons Undo = new Buttons("Undo",120,30,Notifications,"","Last action will be deleted.",DP,RP);
		Undo.setActionCommand("Undo");
		add (Undo);
		
		/*
		Buttons Foreground = new Buttons("Foreground",120,30,Notifications,"","Move shape to foreground.",DP,RP);
		Foreground.setActionCommand("Foreground");
		add (Foreground);*/
		
		Buttons Forward = new Buttons("Forward",120,30,Notifications,"","Move shape forward.",DP,RP);
		Forward.setActionCommand("Forward");
		add (Forward);
		
		Buttons Backwards = new Buttons("Backwards",120,30,Notifications,"","Move shape backwards.",DP,RP);
		Backwards.setActionCommand("Backwards");
		add (Backwards);
		
		/*
		Buttons Background = new Buttons("Background",120,30,Notifications,"","Move shape to background.",DP,RP);
		Background.setActionCommand("Background");
		add (Background);*/
		/* MENU ITEMS - END */
	}
}
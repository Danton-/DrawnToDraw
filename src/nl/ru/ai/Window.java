/*
 * Window.java file
 */

/*
 * Package location
 */
package nl.ru.ai;

import javax.swing.BorderFactory;
/*
 * Import packages?
 */
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import nl.ru.ai.handlers.MouseHandler;
import nl.ru.ai.handlers.MouseMotionHandler;
import nl.ru.ai.objects.Labels;
import nl.ru.ai.panels.BottomPanel;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.LeftPanel;
import nl.ru.ai.panels.RightPanel;
import nl.ru.ai.panels.TopPanel;


/*
 * Windows class
 * 
 * JFrame = superclass
 * Window = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window () {
		// `super ' calls a function inherited from the parent class ( JFrame )
		super();
		setTitle("DrawnToDraw"); // Set Window title
		setSize (new Dimension(1024, 768)); // Set Window size
		setMinimumSize(new Dimension(800, 600));
		
		// Make sure the window appears in the middle of your screen
		setLocationRelativeTo(null);
		
		// Determines what should happen when the frame is closed
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		// Chooses a certain layout type for the elements in this frame
		getContentPane().setLayout (new BorderLayout());
		
		// Create Window content
		final Labels Notifications = new Labels("This label will contain status updates or notifications.", super.getWidth());
		BottomPanel BP = new BottomPanel (Notifications); // The bottom panel contains the notification label
		DrawPanel DP = new DrawPanel (Notifications); // The draw panel will be used to draw / place objects
		RightPanel RP = new RightPanel(new CardLayout(),Notifications,DP); // The right panel will be used to modify placed objects like color or content
		LeftPanel LP = new LeftPanel (Notifications,DP,RP); // The left panel contains the tools to draw and place objects
		TopPanel TP = new TopPanel (Notifications,DP,RP); // The top panel will contain the main menu function / buttons
		
		
		JScrollPane SPR = new JScrollPane(RP);
		SPR.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		SPR.setBorder(BorderFactory.createEmptyBorder());

		// Places the panels on the screen
		getContentPane (). add (DP);
		getContentPane (). add (LP , BorderLayout . WEST );
		getContentPane (). add (TP , BorderLayout . NORTH );
		getContentPane (). add (SPR , BorderLayout . EAST );
		getContentPane (). add (BP , BorderLayout . SOUTH );
		
		// Add Mouse Listeners to all Panels
		DP.addMouseListener(new MouseHandler(DP,RP));
				
		// Mouse motion listener
		DP.addMouseMotionListener(new MouseMotionHandler(DP,RP));
		
		// Set the window to visible ! Yup ... This is necessary
		setVisible (true);
		
		this.getRootPane().addComponentListener(new ComponentAdapter() {
			// Adds a function that listens to the resizing of the Frame / Window
            public void componentResized(ComponentEvent e) {
            	int Width =getWidth();
            	Notifications.setPreferredSize(new Dimension(Width, 30));
            }
        });
	}
}
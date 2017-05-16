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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;


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
		setTitle("DrawnToDraw Interface design"); // Set Window title
		setSize (new Dimension(1024, 768)); // Set Window size
		setMinimumSize(new Dimension(800, 600));
		
		// Make sure the window appears in the middle of your screen
		setLocationRelativeTo(null);
		
		// Determines what should happen when the frame is closed
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		
		// Chooses a certain layout type for the elements in this frame
		getContentPane().setLayout (new BorderLayout());
		
		// Create Window content
		//Label Notifications = new Label("This label will contain status updates or notifications.", super.getWidth());
		JPanel BP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // The bottom panel contains the notification label
		JPanel DP = new JPanel (); // The draw panel will be used to draw / place objects
		JPanel RP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // The right panel will be used to modify placed objects like color or content
		JPanel LP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // The left panel contains the tools to draw and place objects
		JPanel TP = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); // The top panel will contain the main menu function / buttons
		
		BP.setBackground(Color.BLUE);
		DP.setBackground(Color.WHITE);
		RP.setBackground(Color.RED);
		LP.setBackground(Color.YELLOW);
		TP.setBackground(Color.GREEN);		
		
		TP.setPreferredSize(new Dimension(super.getWidth(), 40));
		BP.setPreferredSize(new Dimension(super.getWidth(), 40));		
		LP.setPreferredSize(new Dimension(80, super.getHeight()));
		RP.setPreferredSize(new Dimension(200, 500));

		JScrollPane SPR = new JScrollPane(RP);
		SPR.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		SPR.setBorder(BorderFactory.createEmptyBorder());
		
		// FLOWPANEL
		// http://www.mathcs.emory.edu/~cheung/Courses/377/Syllabus/8-JDBC/GUI/layout.html
		
		

		// Places the panels on the screen
		getContentPane (). add (DP);
		getContentPane (). add (LP , BorderLayout . WEST );
		getContentPane (). add (TP , BorderLayout . NORTH );
		getContentPane (). add (SPR , BorderLayout . EAST );
		getContentPane (). add (BP , BorderLayout . SOUTH );
		
		
		// Lables
		Label L1 = new Label("Tools");
		L1.setPreferredSize(new Dimension(80, 30));
		L1.setBackground(Color.CYAN);
		
		
	 	JPanel ToolP = new JPanel();
	 	ToolP.setBackground(Color.WHITE);
	 	ToolP.setPreferredSize(new Dimension(70, 100));
      GridLayout layout = new GridLayout(3,2);
      layout.setHgap(5);
      layout.setVgap(5);
      ToolP.setLayout(layout); 
		
		// Buttons Left Panel
		Buttons B1 = new Buttons("1",30,30,"","Tooltip");
		Buttons B2 = new Buttons("2",30,30,"","Tooltip");
		Buttons B3 = new Buttons("3",30,30,"","Tooltip");
		Buttons B4 = new Buttons("4",30,30,"","Tooltip");
		Buttons B5 = new Buttons("5",30,30,"","Tooltip");
		Buttons B6 = new Buttons("6",30,30,"","Tooltip");
		
		
		ToolP.add(B1);
		ToolP.add(B2);
		ToolP.add(B3);
		ToolP.add(B4);
		ToolP.add(B5);
		ToolP.add(B6);
		
		
		LP.add(L1);
		LP.add(ToolP);
		
		
		// Add Mouse Listeners to all Panels
		DP.addMouseListener(null);
				
		// Mouse motion listener
		DP.addMouseMotionListener(null);
		
		// Set the window to visible ! Yup ... This is necessary
		setVisible (true);
		
		/*this.getRootPane().addComponentListener(new ComponentAdapter() {
			// Adds a function that listens to the resizing of the Frame / Window
            public void componentResized(ComponentEvent e) {
            	int Width =getWidth();
            	Notifications.setPreferredSize(new Dimension(Width, 30));
            }
        });*/
	}
}
/*
 * ButtonLeftPanel.java file
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
import java.awt.Insets;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import nl.ru.ai.handlers.InputHandler;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;

/*
 * LeftPanel class
 * 
 * JPanel = superclass
 * BottomPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */

public class Buttons extends JButton {

	private static final long serialVersionUID = 1L;
	DrawPanel DP;
	Buttons btn;
	RightPanel RP;
	public String txt;
	public boolean active = false;
	
	/*
	 * Text = button text
	 * Width = width of the button
	 * Height = height of the button
	 * Note = the notification label at the bottom
	 * Imgsrc = the source of the button icon
	 * Tooltip = information about the button
	 * DP = the DrawPanel which we can manipulate
	 * RP = the RightPanel which contains extra tools
	 */
	
	
	public Buttons (String Text, int Width, int Height, Labels Note, String Imgsrc, String Tooltip,DrawPanel DP,RightPanel RP) {
		super(); // `super ' calls a function inherited from the parent class ( JButton )
		
		this.DP = DP;
		this.btn = this;
		this.RP = RP;
		this.txt = Text; 
		
		/* BUTTON SETTINGS - START */
		setPreferredSize(new Dimension(Width, Height));	// set the button size to fixed
		setToolTipText(Tooltip); // set the Tooltip of the button to show info on rollover
		setMargin(new Insets(0, 0, 0, 0)); // to remote the spacing between the image and button's borders
		setOpaque(true); // Enable background color of label
		setBackground(null);
		setForeground(Color.WHITE);
		setBorderPainted(false);
		/* BUTTON SETTINGS - START */
		
		
		/* ADD IMAGE - START */
		File imageCheck = new File(Imgsrc);
		if(imageCheck.exists()) 
		    setIcon(new ImageIcon(imageCheck.toString()));
		else 
			setText(Text); // add text if image file does not exist
		/* ADD IMAGE - END */
		
		
		addActionListener(new InputHandler(this,Text,Note,DP,RP));
		
		
		/* BUTTON ROLLOVER - START */
		setRolloverEnabled(true); // activate rollover
		
		this.addChangeListener(new ChangeListener() {
			//@Override
            public void stateChanged(ChangeEvent e) {

            	if(DP.button != btn){
            		if(model.isArmed() == true){
    		        	System.out.println("Pressed: " + e.toString());
    		        	
    		        	if(DP.button != null)	
    		        		DP.button.setBackground(Color.DARK_GRAY);
    		        	
    		        	DP.button = btn;
    		        	setBackground(Color.BLACK);
    		        }else if(model.isRollover() == true){
    		        	System.out.println("Rollover: " + e.toString());
    		        	setBackground(Color.GRAY);
    		        } else if (active == false){
    		        	setBackground(null);
    		        }
            	}
            }
        });
		/* BUTTON ROLLOVER - END */
		
	}
}
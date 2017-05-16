// Gewijzigd door Danny op 02-05-17

/*
 * LeftPanel.java file
 * Contains all the buttons in the LeftPanel on the screen
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
 * LeftPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */

public class LeftPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	DrawPanel DP;
	Labels Notifications;
	RightPanel RP;
	
	public LeftPanel (Labels Notifications, DrawPanel DP,RightPanel RP) {
		super (); // `super ' calls a function inherited from the parent class ( JPanel )
		this.DP = DP; // Get DrawPanel, used by the buttons
		this.Notifications = Notifications; // Get Notifications label, used by the buttons
		this.RP = RP; // Get RightPanel, used by the buttons

		/* PANEL SETTINGS - START */
		setPreferredSize(new Dimension(80, Window.HEIGHT)); // Set fixed size
		setBackground(Color.DARK_GRAY); // Set background color
		/* PANEL SETTINGS - END */
		
		
		/* TOOLS - START */
		Labels labelT = new Labels("Tools",80);
		add(labelT);
		
		// Add a button to the panel . The argument to the JButton constructor will become the text on the button .
		
		// Draw shapes
		Buttons Draw = new Buttons("Draw",30,30,Notifications,"src/img/draw.png","Draw shapes",DP,RP);
		Draw.setActionCommand("Draw");
		add (Draw);
		
		// Select and move shapes
		Buttons Select = new Buttons("Select",30,30,Notifications,"src/img/move.png","Select and  shapes",DP,RP);
		Select.setActionCommand("Select");
		add (Select);
		
		// Resize shapes
		Buttons Resize = new Buttons("Resize",30,30,Notifications,"src/img/resize.png","Resize shape",DP,RP);
		Resize.setActionCommand("Resize");
		add (Resize);
		
		// Delete shapes
		Buttons Delete= new Buttons("Delete",30,30,Notifications,"src/img/delete.png","Delete shapes",DP,RP);
		Delete.setActionCommand("Delete");
		add (Delete);
		
		// Change shape color
		Buttons FillColor= new Buttons("Bucket",30,30,Notifications,"src/img/bucket.png","Fill shape color",DP,RP);
		FillColor.setActionCommand("Bucket");
		add (FillColor);
		
		// Get shape color
		Buttons GetColor= new Buttons("Pipette",30,30,Notifications,"src/img/Pipette.png","Get shape color",DP,RP);
		GetColor.setActionCommand("Pipette");
		add (GetColor);
		
		/*Buttons Rotate= new Buttons("Rotate",30,30,Notifications,"src/img/Rotate.png","Rotate shape",DP,RP);
		Select.setActionCommand("Rotate");
		add (Rotate);*/
		/* TOOLS - END */
		
		
		/* SHAPES - START */
		Labels labelS = new Labels("Shapes",80); // Shape label
		add(labelS);
		
		// MyRectangle button
		Buttons Rectangle = new Buttons("R",30,30,Notifications,"src/img/rectangle.png","Select rectangle",DP,RP);
		Rectangle.setActionCommand("Rectangle");
		add (Rectangle);	
		
		// MyRoundrectangle button
		Buttons RRectangle = new Buttons("RR",30,30,Notifications,"src/img/roundrectangle.png","Select round rectangle",DP,RP);
		RRectangle.setActionCommand("RRectangle");
		add (RRectangle);	
		
		// MyEllipse button
		Buttons Ellipse = new Buttons("E",30,30,Notifications,"src/img/ellipse.png","Select ellipse",DP,RP);
		Ellipse.setActionCommand("Ellipse");
		add (Ellipse);
		
		// MyArc button
		Buttons Arc = new Buttons("A",30,30,Notifications,"src/img/Arc.png","Select Arc",DP,RP);
		Arc.setActionCommand("Arc");
		add (Arc);
		
		// MyLine button
		Buttons Line = new Buttons("L",30,30,Notifications,"src/img/line.png","Select line",DP,RP);
		Line.setActionCommand("Line");
		add (Line);
		
		// Free form drawing button
		/*Buttons FreeForm = new Buttons("F",30,30,Notifications,"","Select free form",DP,RP);
		FreeForm.setActionCommand("Free");
		add (FreeForm);*/
		
		// Textfield button
		Buttons TextField = new Buttons("Textfield",30,30,Notifications,"src/img/text.png","Create Textfield",DP,RP);
		TextField.setActionCommand("Textfield");
		add (TextField);
		
		//Image Button
		Buttons Image = new Buttons("Image",30,30,Notifications,"src/img/image.png","Create Image",DP,RP);
		Image.setActionCommand("Image");
		add (Image);
		/* SHAPES - END */
	}
}
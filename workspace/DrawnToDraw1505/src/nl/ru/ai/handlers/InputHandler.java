// Gewijzigd door Danny op 25-04-17

/*
 * Inputhandler.java file
 * Contains all the actions for the buttons onscreen
 */

/*
 * Package location
 */
package nl.ru.ai.handlers;

import java.awt.Dimension;
import java.awt.Window;
/*
 * Import packages?
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nl.ru.ai.objects.Buttons;
import nl.ru.ai.objects.Labels;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;

/*
 * InputHandler class
 * 
 * ActionListener = superclass
 * InputHandler = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class InputHandler implements ActionListener{
	
	String l;
	Labels note;
	Buttons btn;
	String exec;
	DrawPanel DP;
	RightPanel RP;
	
	public InputHandler(Buttons btn, String label, Labels note, DrawPanel DP, RightPanel RP) {
		// TODO Auto-generated constructor stub
		this.l = label;
		this.note = note;
		this.btn = btn;
		this.DP = DP;
		this.RP = RP;
	}
	
	public void actionPerformed (ActionEvent e) {
		
		exec = e.getActionCommand().toString();
		if(exec == "open"){
			if(RP.getWidth() < 50){
				note.setText("Open right menu!");
				RP.setPreferredSize(new Dimension(220, 800));
				RP.CPick.setVisible(true);
				RP.SModifier.setVisible(true);
				btn.setText(">");
			}
			else{
				note.setText("Close right menu!");
				RP.CPick.setVisible(false);
				RP.SModifier.setVisible(false);
				RP.setPreferredSize(new Dimension(40, Window.HEIGHT));
				btn.setText("<");
			}
		}
		
		// Top menu 
		//else
		if(exec == "Save"){
			note.setText("Saving canvas......");
		}else if(exec == "Grid"){
			note.setText("Choose a grid size.");
		}else if(exec == "Clear"){
			note.setText("Canvas has been wiped.");
			DP.clearShapesListB();
			//remove textfields
			DP.removeAll();
		}else if(exec == "Undo"){
			note.setText("Last action deleted.");
			DP.deleteShapeB();
		}else if(exec == "Forward"){
			note.setText("Move shape forward.");
			DP.moveShape(1);
		}else if(exec == "Backwards"){
			note.setText("Move shape backwards.");
			DP.moveShape(-1);
		}else if(exec == "Foreground"){
			note.setText("Move shape to Foreground.");
			DP.moveShape(DP.shapesList.size()-DP.selectedShape.getAPosition()-1);
		}else if(exec == "Background"){
			note.setText("Move shape to Background.");
			DP.moveShape(-1);
		}
		
		// Left menu tools
		else if(exec == "Draw"){
			note.setText("You have selected: Draw shape mode. Please select a shape on the left.");
			DP.mode = 0;
		}else if(exec == "Select"){
			note.setText("You have selected: Move shape mode.");
			DP.mode = 1;
		}else if(exec == "Delete"){
			note.setText("You have selected: Delete shape mode.");
			DP.mode = 2;
		}else if(exec == "Resize"){
			note.setText("You have selected: Resize shape mode");
			DP.mode = 3;
		}else if(exec == "Bucket"){
			note.setText("Select shape to fill.");
			DP.mode = 4;
		}else if(exec == "Pipette"){
			note.setText("Select shape to get color.");
			DP.mode = 5;
		}else if(exec=="Rotate"){
			note.setText("Rotate shape");
			DP.mode = 6;
		}
		// Left menu shapes
		else if(exec == "Rectangle"){
			note.setText("You have selected: Rectangle.");
			DP.shape = 1;
		}else if(exec == "RRectangle"){
			note.setText("You have selected: RoundRectangle.");
			DP.shape = 2;
		}else if(exec == "Ellipse"){
			note.setText("You have selected: Ellipse.");
			DP.shape = 3;
		}else if(exec == "Arc"){
			note.setText("You have selected: Arc.");
			DP.shape = 4;
		}else if(exec == "Line"){
			note.setText("You have selected: Line.");
			DP.shape = 5;
		}else if(exec == "Free"){
			note.setText("You have selected: Freeform.");
			DP.shape = 6;
		}else if(exec == "Textfield"){
			note.setText("You have selected: Textfield.");
			DP.shape = 7;
		}else if(exec == "Image"){
			note.setText("You have selected: Image");
			DP.shape = 8;
		}else{
			note.setText("You have selected: " + l);
		}
	}
}
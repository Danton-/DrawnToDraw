/*
 * DrawPanel.java file
 */

/*
 * Package location
 */
package nl.ru.ai.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextField;

import nl.ru.ai.Drawable;
import nl.ru.ai.objects.Buttons;
import nl.ru.ai.objects.Labels;

/*
 * DrawPanel class
 * 
 * JPanel = superclass
 * DrawPanel = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	
	// create variables
	//private Color color = new Color(0, 0, 0, 255);
	
	public int shape = 0; // chosen shape
	public int mode = 0;// current function / mode of the application
	public Drawable selectedShape = null;//selected shape for move-shape
	String shapeL;
 	/*new variables for the move function*/
	//private Drawable buffer_drawShape = null;
 	//private Drawable buffer_selectDrawable = null;
	private Drawable buffer_moveDrawable = null;
	private int buffer_moveX;
	private int buffer_moveY;
	
	public JTextField jt = null;
	
	public int RRRadius = 20; // Integer that contains the data for the right rectangle arc corners
	public int BWidth = 0; // Integer that contains the border width
	public Color colorB = Color.black; // Color that contains the border color
	public Color colorF = Color.black; // Color that contains the shape fill color
	
	public Buttons button;
	
	/*------------------------------------------------------*/
	
	// Can't read the coordinates from the Drawable shapesList.....
	public ArrayList < Drawable > shapesList = new ArrayList <Drawable>();
	
	// main function of DrawPanel
	public DrawPanel(Labels note){
		// `super ' calls a function inherited from the parent class ( JPanel )
		super();
		//this.setBackground(Color.WHITE);
		setLayout(null);
	}
	
	
	public Color getColorF() {
        return colorF;
    }
	
	public Color getColorB() {
        return colorB;
    }
	
	public int getBWidth() {
        return BWidth;
    }
	
	
	public void setColors(Color colorF, Color colorB) {
	    this.colorF = colorF;
	    this.colorB = colorB;
	    repaint();
	}
	

	//@Override
	public void paintComponent(Graphics g) {	
		super.paintComponent(g);
		//g.setColor(getColor());
		// Cast the graphics object to type Graphics2D
		Graphics2D g2d = (Graphics2D) g;
		
		// Loop through the shapesList and draw every shape
		for (Drawable s : shapesList)
			s.draw(g2d);
	}
	
	
	// Delete shape on button press
		public void deleteShapeM(double x, double y){
			int c = 0;
			
			for(Drawable s: shapesList) {
				double x1 = s.getX1(); 
				double y1 = s.getY1(); 
				double x2 = s.getX2(); 
				double y2 = s.getY2(); 
				
			  if(x >= x1 && x <= x2 && y >= y1 && y <= y2){
				  shapesList.remove(c);
				  break;
			  	}else if(x <= x1 && x >= x2 && y >= y1 && y <= y2){
				  shapesList.remove(c);
				  break;
			  	}else if(x >= x1 && x <= x2 && y <= y1 && y >= y2){
				  shapesList.remove(c);
				  break;
				  	
			  	}else if(x <= x1 && x >= x2 && y <= y1 && y >= y2){
				  shapesList.remove(c);
				  break;
			  	}
				c++;
			}
			repaint();
		}
		
		// Delete last placed shape with a button press
		public void deleteShapeB(){ 
			int lSize = shapesList.size();
			if(shapesList.isEmpty()){
				shape = 0;
				shapesList.clear();
			}else{
				shapesList.remove(lSize - 1); // Remove shape from array
				repaint();
			}
		}
			
		// Clear DrawPanel, remove all shapes
		public void clearShapesListB(){
			shapesList.clear();
			repaint();
		}
		
		//select the shape to move
		public void startMoveDrawable(int x, int y) {
					buffer_moveDrawable = selectedShape;
					buffer_moveX = x;
					buffer_moveY = y;
		}
		
		//resize shape
				public void resizeDrawable(int x, int y) {
					if(this.selectedShape != null) {
						this.selectedShape.resize(x - buffer_moveX, y - buffer_moveY);
						this.buffer_moveX = x;
						this.buffer_moveY = y;
						repaint();
					}
				}
				
		//move the shape
		public void updateMoveDrawable(int x, int y) {
			if(this.buffer_moveDrawable != null) {
				this.buffer_moveDrawable.move(x - buffer_moveX, y - buffer_moveY);
				this.buffer_moveX = x;
				this.buffer_moveY = y;
				repaint();
			}
		}
		
		//deselect the shape
		public void finishMoveDrawable() {
			buffer_moveDrawable = null;
			buffer_moveX = 0;
			buffer_moveY = 0;
			repaint();
		}

		
		
		// move shape
		public void moveShape(int direction){
			System.out.println(direction);
			
			Drawable s = selectedShape;
			int indexOfShape = s.getAPosition();
			int newIndexOfShape = indexOfShape + direction;
			int arraySize = shapesList.size();
			
			if(newIndexOfShape!=-1 && newIndexOfShape < arraySize){
				System.out.println(newIndexOfShape + ", " + arraySize);
				
				int min = Math.min(newIndexOfShape, indexOfShape);
				int max = Math.max(newIndexOfShape, indexOfShape);
				
				s.setAPosition(newIndexOfShape); // set shape Array position
				Drawable rs = shapesList.get(newIndexOfShape); // shape to switch with
				rs.setAPosition(indexOfShape); // set shape Array Position
				
				Collections.rotate(shapesList.subList(min, max+1), 1);
				System.out.println(shapesList);
				repaint();
			}
		}	
		
		
		
		
		
		
		public void print(String text){
			System.out.println(text);
		}
}
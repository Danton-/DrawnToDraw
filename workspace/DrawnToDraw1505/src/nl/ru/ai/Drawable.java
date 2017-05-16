// Gewijzigd door Danny op 08-05-17

package nl.ru.ai;

import java.awt.Color;
import java.awt.Graphics2D;

public interface Drawable {
	public void draw(Graphics2D g);
	
	//public void setCoordinates( double x1, double y1, double x2, double y2 );
	
	public double getX1(); // Get X1 coordinate
	public double getX2(); // Get X2 coordinate
	public double getY1(); // Get Y1 coordinate
	public double getY2(); // get Y2 coordinate 
	
	public double getArc1(); // Get arc1 of MyRoundRectangle
	public double getArc2(); // Get arc2 of MyRoundRectangle
	
	public Color getColorF(); // Get the shape fill color
	public void setColorF(Color colorF); // Set the shape fill color
	
	public Color getColorB(); // Get the shape border color
	public void setColorB(Color colorB); // Set the shape border color
	
	public void setBWidth(int bWidth); // Get the shape border width
	public int getBWidth(); // Set the shape border width
	
	public String getShape(); // Get the shape type
	
	public void move(int dx, int dy); //move the shape 
	public void resize(double dx, double dy); //resize the shape
	
	public int getAPosition(); // Get shape position in array list
	public void setAPosition(int APosition); // Set shape position in array list

	public void setArc(int RRRadius);
}
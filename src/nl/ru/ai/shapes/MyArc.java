// Gewijzigd door Danny op 25-04-17

/*  
* MyRectangle class
 * 
 * This is called when a rectangle needs to be drawn.
 * 
 */

package nl.ru.ai.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import nl.ru.ai.Drawable;

public class MyArc implements Drawable {

	private double x,y,w,h,angSt,angExt;
	private int closure;
	private Color color; // shape fill color
	private String shape; //shape type

	public MyArc(double x, double y,double w,double h,double angSt,double angExt,int closure, Color color) {
		this.x = x; // The X coordinate of the upper-left corner of the arc.
		this.y = y; //  The Y coordinate of the upper-left corner of the arc.
		this.w = w; // The overall width of the full ellipse of which this arc is a partial section.
		this.h = h; // The overall height of the full ellipse of which this arc is a partial section.
		this.angSt = angSt; // The starting angle of the arc in degrees.
		this.angExt = angExt; // The angular extent of the arc in degrees.
		this.closure = closure; // The closure type for the arc: OPEN, CHORD, or PIE.
		this.color = color; // Shape color
		this.shape = "MyArc"; // Shape type
	}

	/*public void setCoordinates( double x1, double y1, double x2, double y2 ){
		Random random = new Random();
		this.x1 = random.nextInt(30);
		this.x2 = x1 + 30; 
		this.y1 = random.nextInt(30);
		this.y2 = y1 + 30; 
		return; 
	}*/
	
	public void draw(Graphics2D g) {
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		Arc2D a = new Arc2D.Double(x, y, width, height, 90, 135, Arc2D.PIE);
		g.setColor(color);
		g.draw(a);
		//g.fill(a);
	}

	private double getWidth() {
		return this.w;
	}

	private double getHeight() {
		return this.h;
	}

	private double getStartX() {
		return this.x;
	}

	private double getStartY() {
		return this.y;
	}

	//@Override
	public double getX1() {
		return this.x;
	}

	//@Override
	public double getX2() {
		return 0;
	}

	//@Override
	public double getY1() {
		return this.y;
	}

	//@Override
	public double getY2() {
		return 0;
	}
	
	//@Override
	public Color getColor(){ // return the fill color of this shape
		return this.color;
	}
	
	//@Override
	public String getShape(){ // return the type of this shape
		return this.shape;
	}

	//@Override
	public double getArc1() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public double getArc2() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public void move(int dx, int dy) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void resize(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}
	
	//@Override
	public Color setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
		return null;
	}

	//@Override
	public Color getColorF() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void setColorF(Color colorF) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public Color getColorB() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void setColorB(Color colorB) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void setBWidth() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public int getBWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getAPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public void setAPosition(int APosition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBWidth(int bWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setArc(int RRRadius) {
		// TODO Auto-generated method stub
		
	}
	
}

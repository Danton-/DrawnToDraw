// Gewijzigd door Danny op 25-04-17

/* 
 * MyEllipse class
 * 
 * This is called when an Ellipse needs to be drawn.
 * 
 */

package nl.ru.ai.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import nl.ru.ai.Drawable;

public class MyEllipse implements Drawable {

	private double x1, y1, x2, y2; // Shape coordinates
	private Color ColorF; // fill color
	private Color ColorB; // border color
	private int BWidth, APosition; // border width
	private String shape; // type

	public MyEllipse(double x1, double y1, double x2, double y2, Color ColorF, Color ColorB, int BWidth, int APosition) {
		this.x1 = x1; // X1 coordinate
		this.y1 = y1; // Y1 coordinate
		this.x2 = x2; // X2 coordinate
		this.y2 = y2; // Y2 coordinate
		
		this.ColorF = ColorF; // fill color
		this.ColorB = ColorB; // border color
		this.BWidth = BWidth; // border width
		
		this.shape = "MyEllipse"; // type
		
		this.APosition = APosition; // Array list position
	}
	/*
	public void setCoordinates( double x1, double y1, double x2, double y2 ){
		Random random = new Random();
		this.x1 = random.nextInt(30);
		this.x2 = x1 + 30; 
		this.y1 = random.nextInt(30);
		this.y2 = y1 + 30; 
		return; 
	}*/
	
	public void draw(Graphics2D g) {
		double x = getStartX(); // get start point mouse X
		double y = getStartY(); // get start point mouse Y
		double width = getWidth(); // get width
		double height = getHeight(); // get height
		
		Ellipse2D e = new Ellipse2D.Double(x, y, width, height);

		g.setColor(ColorF); // set fill color
		g.fill(e); // draw shape with fill
	
		if(BWidth != 0){
		g.setColor(ColorB); // set border color
		g.setStroke(new BasicStroke(BWidth)); // set border width
		g.draw(e); // draw shape with border
		}
	}

	private double getWidth() {
		return Math.abs(x1 - x2);
	}

	private double getHeight() {
		return Math.abs(y1 - y2);
	}

	private double getStartX() {
		return Math.min(x1, x2);
	}

	private double getStartY() {
		return Math.min(y1, y2);
	}

	////@Override
	public double getX1() {
		return this.x1;
	}

	////@Override
	public double getX2() {
		return this.x2;
	}

	////@Override
	public double getY1() {
		return this.y1;
	}

	////@Override
	public double getY2() {
		return this.y2;
	}
	
	// set new coordinates 
	public void move(int dx, int dy) {
		this.x1 += dx;
		this.x2 += dx;
		this.y1 += dy;
		this.y2 += dy;
	}
	
	public void resize(double dx, double dy) {
		this.x2 += dx;
		this.y2 += dy;
	}
	
	////@Override
	public Color getColorF(){ // return the fill color of this shape
		return this.ColorF;
	}
	
	////@Override
	public String getShape(){ // return the type of this shape
		return this.shape;
	}

	////@Override
	public double getArc1() {
		// TODO Auto-generated method stub
		return 0;
	}

	////@Override
	public double getArc2() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setArc(int Radius) {
		// TODO Auto-generated method stub
	}

	////@Override
	public void setColorF(Color ColorF) {
		// TODO Auto-generated method stub
		this.ColorF = ColorF;
	}

	////@Override
	public void setColorB(Color ColorB) {
		// TODO Auto-generated method stub
		this.ColorB = ColorB;
	}

	////@Override
	public Color getColorB() {
		// TODO Auto-generated method stub
		return ColorB;
	}

	@Override
	public void setBWidth(int BWidth) {
		// TODO Auto-generated method stub
		this.BWidth = BWidth;
	}

	public int getBWidth() {
		// TODO Auto-generated method stub
		return BWidth;
	}

	public int getAPosition() {
		// TODO Auto-generated method stub
		return APosition;
	}

	//@Override
	public void setAPosition(int APosition) {
		// TODO Auto-generated method stub
		this.APosition = APosition;
	}
}


/* 
 * MyEllipse class
 * 
 * This is called when an Ellipse needs to be drawn.
 * 
 */

package nl.ru.ai.shapes;


import java.awt.BasicStroke;
import java.awt.Color;

//!!!!! http://www.java2s.com/Code/Java/2D-Graphics-GUI/CreatingBasicShapes.htm

import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import nl.ru.ai.Drawable;

public class MyRoundRectangle implements Drawable {

	private double x1, y1, x2, y2, a1, a2; // Shape coordinates
	private Color ColorF; // fill color
	private Color ColorB; // border color
	private int BWidth, APosition; // border width
	private String shape; // type

	public MyRoundRectangle(double x1, double y1, double x2, double y2, double a1, double a2, Color ColorF, Color ColorB, int BWidth, int APosition) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.a1 = a1;
		this.a2 = a2;
		
		this.ColorF = ColorF; // shape fill color
		this.ColorB = ColorB; // shape border color
		this.BWidth = BWidth; // border width
		
		this.shape = "MyRoundRectangle"; // shape type
		
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
		double x = getStartX();
		double y = getStartY();
		double width = getWidth();
		double height = getHeight();
		double arc1 = getArc1();
		double arc2 = getArc2();
		
		RoundRectangle2D rr = new RoundRectangle2D.Double(x, y, width, height, arc1, arc2);

		g.setColor(ColorF); // set fill color
		g.fill(rr); // draw shape with fill
		
		if(BWidth != 0){
		g.setColor(ColorB); // set border color
		g.setStroke(new BasicStroke(BWidth)); // set border width
		g.draw(rr); // draw shape with border
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

	//@Override
	public double getX1() {
		return this.x1;
	}

	//@Override
	public double getX2() {
		return this.x2;
	}

	//@Override
	public double getY1() {
		return this.y1;
	}

	//@Override
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
	
	//@Override
	public Color getColorF(){ // return the fill color of this shape
		return this.ColorF;
	}
	
	//@Override
	public String getShape(){ // return the type of this shape
		return this.shape;
	}

	//@Override
	public double getArc1() {
		// TODO Auto-generated method stub
		return this.a1;
	}

	//@Override
	public double getArc2() {
		// TODO Auto-generated method stub
		return this.a2;
	}
	
	@Override
	public void setArc(int Radius) {
		// TODO Auto-generated method stub
		this.a1 = Radius;
		this.a2 = Radius;
	}

	//@Override
	public void setColorF(Color ColorF) {
		// TODO Auto-generated method stub
		this.ColorF = ColorF;
	}

	//@Override
	public void setColorB(Color ColorB) {
		// TODO Auto-generated method stub
		this.ColorB = ColorB;
	}

	//@Override
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


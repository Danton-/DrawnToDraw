// Gewijzigd door Danny op 25-04-17

/* 
 * MyLine class
 * 
 * This is called when a line needs to be drawn.
 * 
 *  1 = begin lijn horizontaal
* 2 = einde lijn horizontaal
* 3 = einde lijn verticaal
* 4 = begin lijn verticaal
* */

package nl.ru.ai.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import nl.ru.ai.Drawable;

public class MyLine implements Drawable {

	private double x1, y1, x2, y2; // Shape coordinates
	private Color ColorF; // fill color
	private Color ColorB; // border color
	private int BWidth, APosition; // border width
	private String shape; // type
	
	public MyLine(double x1, double x2, double y1, double y2, Color ColorF, Color ColorB, int BWidth, int APosition){
		this.x1 = x1;
		this.x2 = x2; 
		this.y1 = y1;
		this.y2 = y2; 
		
		this.ColorF = ColorF; // fill color
		this.ColorB = ColorB; // border color
		this.BWidth = BWidth; // border width
		
		this.shape = "MyLine"; // shape type
		
		this.APosition = APosition; // Array list position
	}
	
	/*public void setCoordinates( double x1, double y1, double x2, double y2 ){
		Random random = new Random();
		this.x1 = random.nextInt(30);
		this.x2 = x1 + 30; 
		this.y1 = random.nextInt(30);
		this.y2 = y1 + 30; 
		return; 
	}*/
	
	public void draw(Graphics2D g){
		//switched x2 and y1
		//stopped drawing from smallest values to biggest
		Line2D l = new Line2D.Double(x1,y1,x2,y2);
		g.setColor(ColorB);
		g.setStroke(new BasicStroke(BWidth));
		g.draw(l);
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
	public void setColorF(Color ColorF) {
		// TODO Auto-generated method stub
		this.ColorF = ColorF;
	}
	
	//@Override
	public Color getColorF(){ // return the fill color of this shape
		return this.ColorF;
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

	public int getAPosition() {
		// TODO Auto-generated method stub
		return APosition;
	}

	//@Override
	public void setAPosition(int APosition) {
		// TODO Auto-generated method stub
		this.APosition = APosition;
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

	@Override
	public void setArc(int RRRadius) {
		// TODO Auto-generated method stub
		
	}
}

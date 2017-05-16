/* 
 * MyRectangle class
 * 
 * This is called when a rectangle needs to be drawn.
 * 
 */

package nl.ru.ai.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import nl.ru.ai.Drawable;
import nl.ru.ai.panels.DrawPanel;

public class MyTextField implements Drawable {

	private double x1, y1, x2, y2;
	private Color color;
	DrawPanel DP = null; 
	
	public MyTextField(double x1, double y1, double x2, double y2, DrawPanel DP) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.DP = DP;
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
		//g.drawString("Progress!", (int)x, (int)y);
		//set the textfield to certain coordinates
		JTextField jt = new JTextField();
		jt.setBounds((int)x,(int)y,(int)getWidth(),(int)getHeight());
		jt.setBackground(null);
		DP.add(jt);
		System.out.println("New Textfield");
		jt.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					String input = jt.getText();
					g.drawString(input, (int)x, (int)y);
					DP.remove(jt); //deze regel doet het wel buiten de loop maar niet in de loop
					DP.deleteShapeB();
					DP.shapesList.add(new MyText(x1,y1+(getHeight()/2),x2,y2,input));
					//System.out.println("jt has new bounds now. As you can clearly see. *sarcasm*");
				}
			}
		});
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

	//@Override
	public Color getColor(){
		return this.getColor();
	}

	//@Override
	public String getShape() {
		
		return null;
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
	public Color setColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
		return null;
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

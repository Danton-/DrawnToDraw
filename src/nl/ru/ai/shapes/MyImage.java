package nl.ru.ai.shapes;
/* 
 * MyRectangle class
 * 
 * This is called when a rectangle needs to be drawn.
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import nl.ru.ai.Drawable;

public class MyImage implements Drawable {

	private double x1, y1, x2, y2;
	private Color color;
	private File file;
	private BufferedImage bi;
	
	public MyImage(double x1, double y1,double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.file = null;
		JFileChooser filechooser= new JFileChooser();
	    filechooser.setDialogTitle("Choose Your File");
	    filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    //below codes for select  the file 
	    int returnval=filechooser.showOpenDialog(null);
	    if(returnval==JFileChooser.APPROVE_OPTION)
	    {
	        File file = filechooser.getSelectedFile();
	        try
	        {
	            bi=ImageIO.read(file);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        }
	    }
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
		//Graphics g2 = (Graphics) g;
		double x = getStartX();
		double y = getStartY();
		Graphics g2 = (Graphics) g;
		g2.drawImage(bi, (int)x, (int)y, (int)getWidth(), (int)getHeight(), null);
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


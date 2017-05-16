// Gewijzigd door Danny op 25-04-17

/*
 * MouseHandler.java file
 * Contains all the buttons in the LeftPanel on the screen
 */

/*
 * Package location
 */
package nl.ru.ai.handlers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import nl.ru.ai.Drawable;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;
import nl.ru.ai.shapes.MyImage;
import nl.ru.ai.shapes.MyTextField;

/*
 * MouseHandler class
 * 
 * MouseListener = superclass
 * MouseHandler = subclass
 * 
 * The extending class becomes a subclass, it inherits the methods and variables of the superclass.
 */
public class MouseHandler implements MouseListener{
	
	DrawPanel DP;
	RightPanel RP;

	double x1,y1,x2,y2;
	
	public MouseHandler (DrawPanel DP, RightPanel RP) {
		this.DP = DP;
		this.RP = RP;
	}
	
	//@Override
    public void mouseClicked(MouseEvent e) {
		// UNUSED
    }
    
	//@Override
	    public void mousePressed(MouseEvent e) {	
	    	x1 = e.getX();
	    	MouseMotionHandler.x1 = x1;
	    	y1 = e.getY();
	    	MouseMotionHandler.y1 = y1;
	    	//System.out.println("x1: " + x1 +  "y1: " + y1 );
	    	
	    	if(DP.mode == 0){ // 0 == draw
	    		DP.selectedShape = null;
	    	}else if(DP.mode == 1 || DP.mode == 3){	// 1 == select || 3 == move    		
	    		int i = DP.shapesList.size();
	    		while(i > 0) {
	    			Drawable s = DP.shapesList.get(i-1);
	    			
					if((e.getX() >= s.getX1() && e.getX() <= s.getX2() && e.getY() >= s.getY1() && e.getY() <= s.getY2())||
						(e.getX() <= s.getX1() && e.getX() >= s.getX2() && e.getY() >= s.getY1() && e.getY() <= s.getY2())||
						(e.getX() >= s.getX1() && e.getX() <= s.getX2() && e.getY() <= s.getY1() && e.getY() >= s.getY2())||
						(e.getX() <= s.getX1() && e.getX() >= s.getX2() && e.getY() <= s.getY1() && e.getY() >= s.getY2())){
						  DP.selectedShape = s;
						  //new code 
						  DP.startMoveDrawable(e.getX(),e.getY());
						  RP.CPick.getColors(s.getColorF(), s.getColorB());
						  RP.SModifier.getBorder(s.getBWidth());
						  RP.SModifier.getRadius(s.getArc1());
						  
						  //RP.repaint();
						  break;
				  	}
					i--;
	    	    }
	    	} else if(DP.mode == 2){ // 2 == Delete
	    		DP.deleteShapeM(x1, y1);
	    	}else if(DP.mode == 4 || DP.mode == 5){ // 4 == Bucket || 5 == pipette
	    		int i = DP.shapesList.size();
	    		while(i > 0) {
	    			Drawable s = DP.shapesList.get(i-1);

	    			if((e.getX() >= s.getX1() && e.getX() <= s.getX2() && e.getY() >= s.getY1() && e.getY() <= s.getY2())||
							(e.getX() <= s.getX1() && e.getX() >= s.getX2() && e.getY() >= s.getY1() && e.getY() <= s.getY2())||
							(e.getX() >= s.getX1() && e.getX() <= s.getX2() && e.getY() <= s.getY1() && e.getY() >= s.getY2())||
							(e.getX() <= s.getX1() && e.getX() >= s.getX2() && e.getY() <= s.getY1() && e.getY() >= s.getY2())){
	    				DP.selectedShape = s;
						  //new code 
						  if(DP.mode == 4){
							  s.setColorF(DP.getColorF());
							  s.setColorB(DP.getColorB());
						  }else if(DP.mode == 5){
							  RP.CPick.getColors(s.getColorF(),s.getColorB());
						  }
						  break;
					  	}	
					i--;
	    	    }
	    		DP.repaint();
	    	}else if(DP.mode == 6){ // 6 == rotate
	    		System.out.println("Rotate?");
	    	}
	    }
    
	 //@Override
	    public void mouseReleased(MouseEvent e) {
	    	MouseMotionHandler.delete = false;
	    	//test code
	    	if(DP.mode == 0 && DP.shape == 7){
	    		DP.deleteShapeB();
	    		DP.shapesList.add(new MyTextField(x1,y1,e.getX(),e.getY(),DP));
	    	}else if(DP.mode == 0 && DP.shape == 8){
	    		DP.deleteShapeB();
	    		DP.shapesList.add(new MyImage(x1,y1,e.getX(),e.getY()));
	    	}
	    	//
	    	DP.finishMoveDrawable();
	    }
    
    //@Override
    public void mouseEntered(MouseEvent e) {
    }
    
    //@Override
    public void mouseExited(MouseEvent e) {
    }
}
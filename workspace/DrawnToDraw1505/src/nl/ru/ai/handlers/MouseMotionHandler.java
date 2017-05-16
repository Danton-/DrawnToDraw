package nl.ru.ai.handlers;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;

import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;
import nl.ru.ai.shapes.*;

public class MouseMotionHandler implements MouseMotionListener{

	DrawPanel DP;
	RightPanel RP;
	static boolean delete = false;
	Color colorF;
	Color colorB;
	int BWidth;
	
	static double x1,y1,x2,y2;
	public MouseMotionHandler (DrawPanel DP, RightPanel RP) {
		this.DP = DP;	
		this.RP = RP;
	}
	
	// Store MyLine coordinates
	double l1, l2;
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
	 */
	//@Override
	public void mouseDragged(MouseEvent e) {
		colorF = DP.getColorF();
		colorB = DP.getColorB();
		BWidth = DP.getBWidth();
		//System.out.println("GetColor: " + color);
    	
    	// Store MyLine coordinates
    	 /*  1 = begin lijn horizontaal
		 * 2 = einde lijn horizontaal
		 * 3 = einde lijn verticaal
		 * 4 = begin lijn verticaal
		 * MyLine(x1,x2,y2,y1)
		 */
    	
    	//l1 = x1;
    	//l2 = y1;
		
		int SPosition = DP.shapesList.size() - 1; // Shapes List length / size
    	
    	if(DP.mode == 0){
    		// if trigger to not delete the first placed shape
    		if(delete == true){
    			DP.deleteShapeB();
    		}
    		
    		if(DP.shape == 0){
    			return;
    		}else if(DP.shape == 1){
    			//stopped drawing from smallest to biggest x and y
    			DP.shapesList.add(new MyRectangle(x1,y1,e.getX(),e.getY(),colorF,colorB,BWidth,SPosition));
    			//also added an alternative for addShapeM
    		}else if(DP.shape == 2){
    			//int r = Integer.parseInt(RP.RRRadius.getText());
    			int r = DP.RRRadius;
    			DP.shapesList.add(new MyRoundRectangle(x1,y1,e.getX(),e.getY(),r,r,colorF,colorB,BWidth,SPosition));
    		}else if (DP.shape == 3){
    			DP.shapesList.add(new MyEllipse(x1,y1,e.getX(),e.getY(),colorF,colorB,BWidth,SPosition));
    		}else if (DP.shape == 4){
    		    DP.shapesList.add(new MyArc(x1,y1,e.getX(),e.getY(),90,135,Arc2D.OPEN,colorF));
    		}else if(DP.shape == 5){
    			DP.shapesList.add(new MyLine(x1,e.getX(),y1,e.getY(),colorF,colorB,BWidth,SPosition));
    		}else if(DP.shape == 6){
    			// Free form
    		}else if(DP.shape == 7 || DP.shape == 8){
    			//test 
    			//DP.shapesList.add(new MyTextField(x1,y1,e.getX(),e.getY(),DP));
    			DP.shapesList.add(new MyRectangle(x1,y1,e.getX(),e.getY(),colorF,colorB,BWidth,SPosition));
    			//
    		}else{
    			return;
    		}
    		delete = true;
    		DP.repaint();
    	}else if(DP.mode == 1 || DP.mode == 7){
    		
    		//new code ----------------------------------------
    		DP.updateMoveDrawable(e.getX(), e.getY());
    		//
    	}
    	else if (DP.mode == 2){ 
    		// Delete shapes on drag / wipe
    		DP.deleteShapeM(e.getX(),e.getY());
    		DP.repaint();
    	}
    	else if(DP.mode == 3){
    		DP.resizeDrawable(e.getX(),e.getY());
    	}
	}
	//@Override
	public void mouseMoved(MouseEvent e) {
	}

}

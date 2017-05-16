package nl.ru.ai.handlers;

import java.awt.TextComponent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import nl.ru.ai.panels.DrawPanel;

public class MyTextListener implements TextListener {
	DrawPanel DP;
	String Field;
	static int i;

    public MyTextListener(DrawPanel DP, String Field) {
		this.DP = DP;
		this.Field = Field;
    }

    public void textValueChanged(TextEvent e) {
      TextComponent tc = (TextComponent) e.getSource();
      //System.out.println("Typed value in TextComponent " + tc.getText());
      
      // Check if textfield is Numeric
      if (!isNumeric(tc.getText()) && !tc.getText().isEmpty())
      {
         // Number is NOT integer
    	  tc.setText("");
    	  if(Field == "RRRadius"){
    		  DP.RRRadius = 0;
    	  }else if(Field == "BWidth"){
    		  DP.BWidth = 0;
    	  }
    	 
      }else{
    	  if(Field == "RRRadius"){
    		  DP.RRRadius = i;
    	  }else if(Field == "BWidth"){
    		  DP.BWidth = i;
    	  }
      }
      
      if(DP.selectedShape != null){
	    	DP.selectedShape.setBWidth(DP.BWidth);
	    	DP.selectedShape.setArc(DP.RRRadius);
	    	DP.repaint();
  		}
    }
    
    // Function to check if a String is numeric or not
    public static boolean isNumeric(String str)  
    {  
	  try  
	  {  
	    i = Integer.parseInt(str);
	  }  
	  catch(NumberFormatException i)  
	  {  
	    return false;  
	  }  
	  return true;  
    }
  }
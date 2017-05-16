// Gewijzigd door Danny op 25-04-17

package tools;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import nl.ru.ai.panels.DrawPanel;

public class ColorPicker extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final DrawPanel DrawPanel = null;
	JLabel rgbValue = new JLabel(""); // rgbValue label
	JSlider sliderR, sliderG, sliderB, sliderAlpha; // assign slider values

  /*
   * Color panel with sliders and color representation
  */
  
  DrawPanel DP;
  Color color;
  public Color colorF; // fill color
  public Color colorB; // border color
  public DrawingCanvas canvas;
  DrawingCanvas canvasF = new DrawingCanvas(); // canvas that changes to the selected fill color
  DrawingCanvas canvasB = new DrawingCanvas(); // canvas that changes to the selected border color
  
  
  public ColorPicker(DrawPanel DP) {
	this.DP = DP;
	
	//this.setBackground(Color.white);
	this.canvas = canvasF;
	this.color = colorF;
	
    sliderR = getSlider(0, 255, 0, 60, 20); // Red
    sliderG = getSlider(0, 255, 0, 60, 20); // Green
    sliderB = getSlider(0, 255, 0, 60, 20); // Blue
    sliderAlpha = getSlider(0, 255, 255, 60, 20); // Alpha

    JPanel LPanel = new JPanel();
    JPanel RPanel = new JPanel();
    
    LPanel.setPreferredSize(new Dimension(35, 300));
    LPanel.setLayout(new GridLayout(7, 1, 10, 0));
    
    RPanel.setPreferredSize(new Dimension(135, 300));
    RPanel.setLayout(new GridLayout(7, 1, 10, 0));
    
    LPanel.add(new JLabel("Red", JLabel.RIGHT));
    RPanel.add(sliderR);
    LPanel.add(new JLabel("Green", JLabel.RIGHT));
    RPanel.add(sliderG);
    LPanel.add(new JLabel("Blue", JLabel.RIGHT));
    RPanel.add(sliderB);

    LPanel.add(new JLabel("Alpha", JLabel.RIGHT));
    RPanel.add(sliderAlpha);

    LPanel.add(new JLabel("HEX", JLabel.RIGHT));
    rgbValue.setBackground(Color.white);
    rgbValue.setForeground(Color.black);
    rgbValue.setOpaque(true);
    RPanel.add(rgbValue);
    
    LPanel.add(new JLabel("Fill color", JLabel.RIGHT));
    RPanel.add(canvasF);
    
    LPanel.add(new JLabel("Border color", JLabel.RIGHT));
    RPanel.add(canvasB);
    
    //add(new JLabel("Shape colors", JLabel.CENTER), BorderLayout.NORTH);

    add(LPanel, BorderLayout.SOUTH);
    add(RPanel, BorderLayout.SOUTH);
    
    // canvas settings
    canvasF.setBackground(Color.black);
    canvasB.setBackground(Color.black);
    
    canvasF.addMouseListener(new CanvasListener(canvasF));
    canvasB.addMouseListener(new CanvasListener(canvasB));
  }

  public JSlider getSlider(int min, int max, int init, int mjrTkSp, int mnrTkSp) {
    JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, init);
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(mjrTkSp);
    slider.setMinorTickSpacing(mnrTkSp);
    slider.setPaintLabels(true);
    slider.addChangeListener(new SliderListener());
    return slider;
  }

  class DrawingCanvas extends Canvas {
	private static final long serialVersionUID = 1L;
	Color color;
    int redValue, greenValue, blueValue;
    int alphaValue = 255;

    public DrawingCanvas() {
      setSize(120, 30);
      color = new Color(0, 0, 0);
      setBackgroundColor();
      // https://docs.oracle.com/javase/tutorial/uiswing/misc/trans_shaped_windows.html
    }

    public void setBackgroundColor() {
    	//System.out.println(alphaValue);
    	color = new Color(redValue, greenValue, blueValue, alphaValue);
    	setBackground(color);
    	
    	if(canvas == canvasF){
			colorF = color;
		}else if(canvas == canvasB){
			colorB = color;
		}
    }

    public void setColor() {
    	// Set the Shape Color of the DrawPanel

    	DP.setColors(colorF, colorB);
    	
    	if(DP.selectedShape != null){
	    	DP.selectedShape.setColorF(colorF);
	    	DP.selectedShape.setColorB(colorB);
    	}
    }
  }


  class CanvasListener implements MouseListener {
	  DrawingCanvas canvasS;
	  
	  public CanvasListener(DrawingCanvas canvas){
		  this.canvasS = canvas;
	  }

	//@Override
	public void mousePressed(MouseEvent e) {// FUNCTION - action on mouse press
		canvas = canvasS;					// set Canvas
		getColor(canvas.getBackground());	// get Canvas background and set Sliders
	}

	//@Override
	public void mouseClicked(MouseEvent e) {
		// UNUSED
	}

	//@Override
	public void mouseReleased(MouseEvent e) {
		// UNUSED
	}

	//@Override
	public void mouseEntered(MouseEvent e) {
		// UNUSED
	}

	//@Override
	public void mouseExited(MouseEvent e) {
		// UNUSED
	} 
  }

  class SliderListener implements ChangeListener {
    public void stateChanged(ChangeEvent e) {
      JSlider slider = (JSlider) e.getSource();

      if (slider == sliderAlpha) {
    	  canvas.alphaValue = slider.getValue();
        displayRGBColor();
      } else if (slider == sliderR) {
    	  canvas.redValue = slider.getValue();
        displayRGBColor();
      } else if (slider == sliderG) {
    	  canvas.greenValue = slider.getValue();
        displayRGBColor();
      } else if (slider == sliderB) {
    	  canvas.blueValue = slider.getValue();
        displayRGBColor();
      }
      canvas.repaint();
    }

    public void displayRGBColor() {
		canvas.setBackgroundColor();
		canvas.setColor();
	  // RGB to HEX
	  // hex -> "ffff0000"
	  String hex = Integer.toHexString(canvas.color.getRGB());
	  // Reduced to RGB: hex -> "#ff0000"
	  hex = "#" + hex.substring(2, hex.length());
	  rgbValue.setText(hex.toUpperCase());
    }
    
  }

  public void getColor(Color color){  	// FUNCTION - Get color from canvas and set sliders
	this.color = color; 				// set color
		
	int redValue = color.getRed(); 		// convert color RED to int
	int greenValue = color.getGreen(); 	// convert color GREEN to int
	int blueValue = color.getBlue(); 	// convert color BLUE to int
	int alphaValue = color.getAlpha(); 	// convert ALPHA to int
	
	this.sliderR.setValue(redValue); 		// set RED slider
	this.sliderG.setValue(greenValue); 		// set GREEN slider
	this.sliderB.setValue(blueValue); 		// set BLUE slider
	this.sliderAlpha.setValue(alphaValue); 	// set ALPHA slider
  }
  
  public void getColors(Color colorF, Color colorB){	// FUNCTION - Get colors when selecting a shape and set the canvasses and sliders
	  this.colorF = colorF; 							// set fill color
	  this.colorB = colorB; 							// set border color
	  
	  DP.print("F: " + colorF + ", B: " + colorB);
	  
	  canvasF.setBackground(colorF); 					// set fill canvas background
	  canvasB.setBackground(colorB); 					// set border canvas background
	  
	  canvasF.repaint(); 								// repaint fill canvas
	  canvasB.repaint(); 								// repaint border canvas
	  
	  canvas = canvasF;
	  
	  this.repaint();
	  getColor(colorF); 								// set sliders to fill canvas background color
  }
}
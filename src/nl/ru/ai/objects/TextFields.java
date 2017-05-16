package nl.ru.ai.objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import nl.ru.ai.handlers.MyTextListener;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;

public class TextFields extends TextField {
	private static final long serialVersionUID = 1L;
	DrawPanel DP;
	RightPanel RP;
	String Value,Field;
	
	public TextFields (String Value, String Field, int Width, int Height, DrawPanel DP, RightPanel RP) {
		super(); // `super ' calls a function inherited from the parent class ( JButton )
		
		this.Value = Value;
		this.Field = Field;
		this.DP = DP;
		this.RP = RP;
		
		this.addTextListener(new MyTextListener(DP,Field));   
		
		/* TESTFIELD SETTINGS - START */
		setPreferredSize(new Dimension(Width, Height));	// set the button size to fixed
		setBackground(null);
		setForeground(Color.black);
		setText(Value);
		/* BUTTON SETTINGS - START */

	}
}
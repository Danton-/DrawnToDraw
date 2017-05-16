package tools;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nl.ru.ai.objects.TextFields;
import nl.ru.ai.panels.DrawPanel;
import nl.ru.ai.panels.RightPanel;

public class ShapeModifier extends JPanel{
	private static final long serialVersionUID = 1L;
	public TextField RRRadius, BWidth; // textfields for radius and width
	private DrawPanel DP; // Drawpanel variable
	private RightPanel RP; // Rightpanel variable
	private JPanel MPanel = new JPanel();

	public ShapeModifier(DrawPanel DP, RightPanel RP) {	
		this.DP = DP; // assign DrawPanel to local variable
		this.RP = RP; // assign DrawPanel to local variable

		MPanel.setPreferredSize(new Dimension(180, 140));
		MPanel.setLayout(new GridLayout(6, 1, 10, 0));

		MPanel.add(new JLabel("Shape settings", JLabel.CENTER));
		
		SModifier();
		RRModifier();
		add(MPanel);
	 }
	
	public void SModifier(){ // shape settings
		MPanel.add(new JLabel("Border Width", JLabel.LEFT));
		BWidth = new TextFields("0","BWidth",100,20,DP,RP);
		MPanel.add(BWidth);
	}
	
	public void RRModifier(){ // round rectangle settings
		MPanel.add(new JLabel("Round Rectangle Corner", JLabel.LEFT));
		RRRadius = new TextFields("20","RRRadius",100,20,DP,RP);
		MPanel.add(RRRadius);
	}
	
	public void getRadius(double radius) { // assign radius value to RRRadius textfield
		RRRadius.setText(Integer.toString((int)radius));
	}
	
	public void getBorder(int border) { // assign border width value to BWidth textfield
		BWidth.setText(Integer.toString(border));
	}
}

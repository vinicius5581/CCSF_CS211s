/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: ScrollBarPanel.java 
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class ScrollBarPanel extends JPanel 
{
	private ColorDisplay canvas; //container to which bars should be added

	//********************************ScrollBarPanel()******************************
	public ScrollBarPanel(ColorDisplay canvas)
	{
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); //use boxlayout
		this.canvas = canvas;
		add(getSBPanel("RED")); //add Red scrollbar
		add(getSBPanel("GREEN")); //add Green scrollbar
		add(getSBPanel("BLUE")); //add Blue scrollbar
	}
	
	//METHOD that returns a JPanel that contains a ScrollBar and Name of Color 
	//********************************getSBPanel()**********************************
	public JPanel getSBPanel(String name)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setPreferredSize(new Dimension(100,100));
		//name of scrollbar
		JLabel label = new JLabel(name);
		//scroll bar
		JScrollBar sb = new JScrollBar(JScrollBar.HORIZONTAL, 0, 5, 0, 260);
		//add scroll bar listener
		sb.addAdjustmentListener(new ScrollBarListener(name));
		//add label and scroll bar to panel
		panel.add(label);
		panel.add(sb);
		//align label
		label.setAlignmentX(CENTER_ALIGNMENT);
		//add border
		panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		return panel;
	}
	
	//********************************ScrollBarListener - Class*********************
	private class ScrollBarListener implements AdjustmentListener
	{
		private String name;
		//********************************ScrollBarListener()***********************
		public ScrollBarListener(String name)
		{
			this.name = name;
		}
		
		//********************************adjustmentValueChanged()******************
		@Override
		public void adjustmentValueChanged(AdjustmentEvent ae) 
		{
			//change color of shapes based on scrollbar value
			int value = ae.getValue();
			//change red
			if(name.equals("RED"))
			{
				canvas.setRedColor(value);
			}
			//change green
			if(name.equals("GREEN"))
			{
				canvas.setGreenColor(value);
			}
			//change blue
			if(name.equals("BLUE"))
			{
				canvas.setBlueColor(value);
			}
		
		}
	}
}

/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: ButtonPanel.java 
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ButtonPanel extends JPanel
{
	private RadioButtonListener rbListener; //listens to user's choices 
	private ColorDisplay canvas; //container of buttons
	
	//********************************ButtonPanel()*********************************
	public ButtonPanel(ColorDisplay canvas)
	{
		this.canvas = canvas; //obtain container 
		rbListener = new RadioButtonListener(); //setup listener 
		//set layout to box
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//create decimal button
		JRadioButton decimal = new JRadioButton("Decimal");
		decimal.setSelected(true);
		decimal.setBackground(Color.yellow);
		decimal.addActionListener(rbListener);
		//create octal button
		JRadioButton octal = new JRadioButton("Octal");
		octal.setBackground(Color.yellow);
		octal.addActionListener(rbListener);
		//create binary button
		JRadioButton binary = new JRadioButton("Binary");
		binary.setBackground(Color.yellow);
		binary.addActionListener(rbListener);
		//create hex button
		JRadioButton hex = new JRadioButton("Hex");
		hex.setBackground(Color.yellow);
		hex.addActionListener(rbListener);
		//add buttons to group
		ButtonGroup group = new ButtonGroup();
		group.add(decimal);
		group.add(octal);
		group.add(binary);
		group.add(hex);
		//add space between buttons and top of layout
		add(Box.createVerticalGlue());
		add(decimal);
		add(octal);
		add(binary);
		add(hex);
		//add space between buttons and bottom of layout 
		add(Box.createVerticalGlue());
		setBackground(Color.yellow);
	}
	
	//***************************RadioButtonListener - Class************************
	private class RadioButtonListener implements ActionListener
	{
		//**********************actionPerformed()***********************************
		@Override
		public void actionPerformed(ActionEvent ae) 
		{
			//find out what button is selected
			JRadioButton source = (JRadioButton) ae.getSource();
			//get name of button
			String buttonSelected = source.getText();
			//have canvas communicate with display about which button was selected
			canvas.setType(buttonSelected);

		}
	}
}

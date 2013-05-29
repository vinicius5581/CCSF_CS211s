/**Name: Victor Malchikov
 * File: BasicButton.java
 */
package hw.button;

import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ToolTipManager;


/**BasicButton class allows creation of buttons for the program. It has a 
 *             constructor that takes in name for button, container that
 *             button should be added to, and BasicListener class. 
 * @author Victor
 */
public class BasicButton implements Serializable 
{	
	protected JButton button; 
	protected BasicListener listener; //listener implementation done separately 
	
	//********************BasicButton()*********************************************
	public BasicButton(String name, JPanel container, BasicListener bListener)
	{
		button = new JButton(name); //Instantiate button
		listener = bListener; //Instantiate listener
		button.addActionListener(listener); //add listener to button
		container.add(button); //add button to the container
		
	}
	
	//***********************setToolTip()*******************************************
	public void setToolTip(String text)
	{
		//setup tooltip that all buttons will share
	
		//tooltip display 
		button.setToolTipText(text); //tooltip text
		ToolTipManager.sharedInstance().setInitialDelay(1000);
		ToolTipManager.sharedInstance().setDismissDelay(2000);
		ToolTipManager.sharedInstance().setReshowDelay(5000);

	}
	
}

/**Name: Victor Malchikov
 * File: ShapeBuilder.java
 */
package hw.shape;

import java.awt.Graphics2D;
import java.io.Serializable;

/**Class that allows user to draw shapes. Used in List<Shapes> container object.*/
public abstract class ShapeBuilder implements Serializable 
{
	//abstract method that must be implemented by any class that extends this class
	//this method should help the class draw itself 
	public abstract void drawShape(Graphics2D g);
	
}

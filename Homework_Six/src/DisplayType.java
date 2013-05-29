/** 
 * Professor: Abbas Moghtanei
 * Class: CS211S, Advanced Java: Standard Edition 
 * @author Victor Malchikov
 * File: DisplayType.java 
*/

public class DisplayType 
{
	private boolean decimalFormat = true;
	private boolean octalFormat = false;
	private boolean binaryFormat = false;
	private boolean hexFormat = false;

	//***************************setDecimalFormat()*********************************
	//method turns on Decimal 
	public void setDecimalFormat()
	{
		decimalFormat = true;
		octalFormat = false;
		binaryFormat = false;
		hexFormat = false;
	}
	
	//***************************setOctalFormat()***********************************
	//method turns on Octal
	public void setOctalFormat()
	{
		decimalFormat = false;
		octalFormat = true;
		binaryFormat = false;
		hexFormat = false;
	}
	
	//***************************setBinaryFormat()*********************************
	//method turns on Binary
	public void setBinaryFormat()
	{
		decimalFormat = false;
		octalFormat = false;
		binaryFormat = true;
		hexFormat = false;
	}
	
	//***************************setHexFormat()************************************
	//method turns on Hex
	public void setHexFormat()
	{
		decimalFormat = false;
		octalFormat = false;
		binaryFormat = false;
		hexFormat = true;
	}
	
	//***************************toString()****************************************
	//shows which format is being used 
	public String toString()
	{
		if(decimalFormat)
			return "Decimal";
		if(octalFormat)
			return "Octal";
		if(binaryFormat)
			return "Binary";
		if(hexFormat)
			return "Hex";
		
		return "unknown";
	}
}

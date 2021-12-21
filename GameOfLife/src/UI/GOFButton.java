package UI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GOFButton extends JButton {
	public Boolean isClicked = false;
	//public int xCoordinate = 0;
	//public int yCoordinate = 0;
	GOFButton() 
	{
		setBorder(new LineBorder(Color.BLACK));
		setBackground(Color.WHITE);
	}
	public void selectButton() 
	{
		setBackground(Color.YELLOW);
		isClicked = true;
	}
	
	public void deselectButton() 
	{
		setBackground(Color.WHITE);
		isClicked = false;
	}
	
}
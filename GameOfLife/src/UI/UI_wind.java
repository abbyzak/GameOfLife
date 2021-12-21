package UI;
import business_layer.GoL;
import business_layer.Main;
import java.awt.*;    
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;



public class UI_wind extends JFrame implements ActionListener {
	
	GOFButton[][] button_struct = new GOFButton [20][20];
	GOFButton place_holder;
	
	public UI_wind()
	{
		
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				button_struct[i][j] = new GOFButton();
				button_struct[i][j].addActionListener(this);
			}
		}
	    
	 // adding buttons to the frame       
	    
		for(int i = 0; i < 20; i++)
		{
			for(int j = 0; j < 20; j++)
			{
				this.add(button_struct[i][j]);
			}
		}
		
	 // setting grid layout of 20 rows and 20 columns    
	    this.setLayout(new GridLayout(20,20));    
	    this.setSize(1550,800);    
	    this.setVisible(true);    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	// constructor end

	@Override //if mouse is clicked
	public void actionPerformed(ActionEvent e)
	{
		
		place_holder = (GOFButton) e.getSource();
		if (place_holder.isClicked) {
			place_holder.deselectButton();
		} else {
			place_holder.selectButton();
		}
		
	}
	
	public void working()
	{
		GoL game = new GoL();
		boolean [][] gameSet = new boolean [20][20];
		int [][] numGameSet = new int [20][20];
		
			gameSet = game.initGrid();
									
			game.tracing(numGameSet, gameSet);
			
			for(int i = 0; i < 20; i++)
			{
				for(int j = 0; j < 20; j++)
				{
					//System.out.println(gameSet[i][j]);
					if(numGameSet[i][j] == 0)
					{
						button_struct[i][j].deselectButton();
					}
					else
						button_struct[i][j].selectButton();
				}
			}

			
		for(int i = 0; i < 20; i++)
			{
				
				gameSet = game.changeCells(gameSet);		
				game.tracing(numGameSet, gameSet);		
				
				for(int j = 0; j < 20; j++)
				{
					//System.out.println("anything in second loop");
					for(int k = 0; k < 20; k++)
					{
						//System.out.println(gameSet[i][j]);
						if(numGameSet[j][k] == 0)
						{
							button_struct[j][k].deselectButton();
						}
						else
							button_struct[j][k].selectButton();
					}
				}
				
				try {
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
	}
	
}

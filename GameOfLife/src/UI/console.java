package UI;

import business_layer.GoL;

public class console {
	
	GoL game = new GoL();
	boolean [][] gameSet = new boolean [20][20];
	int [][] numGameSet = new int [20][20];
	
	public void working()
	{
	
	gameSet = game.initGrid();
	game.tracing(numGameSet, gameSet);
	game.print(numGameSet);
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
	
		try {
			game.start(numGameSet, gameSet);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

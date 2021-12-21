package business_layer;

public class GoL
{	
	boolean [][] grid = new boolean [20][20];
	
	public boolean[][] initGrid()
	{
		for(int i=0; i < grid.length; i++ )
	    {
	      for(int j=0; j < grid[i].length; j++ )
	      {   
	        grid[i][j] = false;
	      }
	    }
		// making of glider
		grid[2][4] = true;
		grid[3][5] = true;
		grid[4][3] = true;
		grid[4][4] = true;
		grid[4][5] = true;
		
		return grid;
	}
	
	public boolean[][] changeCells(boolean[][] gameSet) // making of cells for next state
	{
		boolean [][] nextState = new boolean [20][20];
		int count;
		for(int i=1; i <= 18; i++ )
	    {
	      for(int j=1; j <= 18; j++ )
	      {   
	    	  if(gameSet[i][j] == true)
	    	  {
	    		  count = -1;
	    		  for(int a = i-1; a <= i+1; a++)
	    		  {
	    			  for(int b = j-1; b <= j+1; b++)
	    			  {
	    				  if(gameSet[a][b] == true)
	    				  {
	    					  count++; // to see if neighboring cells are alive or not
	    				  }
	    			  }
	    		  }
	    		  if (count < 2) //dies due to under-population
	    		  {
	    			  nextState[i][j] = false; 
	    		  }
	    		  else if (count == 2 || count == 3) //lives on to next generation
	    		  {
	    			  nextState[i][j] = true;
	    		  }
	    		  else if(count > 3) // dies due to over-popluation
	    		  {
	    			  nextState[i][j] = false; 
	    		  }
	    		  
	    		  
	    		  
	    	  }
	    	  
	    	  else if(gameSet[i][j] == false)
	    	  {
	    		  count = 0;
	    		  for(int a = i-1; a <= i+1; a++)
	    		  {
	    			  for(int b = j-1; b <= j+1; b++)
	    			  {
	    				  if(gameSet[a][b] == true)
	    				  {
	    					  count++; // to see if neighboring cells are alive or not
	    				  }
	    			  }
	    		  }
	    		  if(count == 3) // reproduction
	    		  {
	    			  nextState[i][j] = true;
	    		  }
	    		  else
	    		  {
	    			  nextState[i][j] = false;
	    		  }
	    		  
	    		  
	    	  }
	    	  
	      }
	    }
		return nextState;
	}
	
	public void tracing(int [][] numGameSet, boolean [][] gameSet)
	{
		for(int i = 0; i < gameSet.length; i++)
		{
			for(int j = 0; j < gameSet[i].length; j++)
			{
				if(gameSet[i][j] == false)
					numGameSet[i][j] = 0;
				else
					numGameSet[i][j] = 1;
			}
		}
	}
	
	public void print(int [][] numGameSet)
	{
		for(int i = 0; i <= 19; i++)
		{
			for(int j = 0; j <= 19; j++)
			{
				System.out.print("|");
				System.out.print(numGameSet[i][j]);
			}
			System.out.println();
		}
	}

	public void start(int [][] numGameSet, boolean [][] gameSet) throws InterruptedException 
	{
		for(int i = 0; i < 10; i++)
		{
			gameSet = changeCells(gameSet);		
			tracing(numGameSet, gameSet);		
			print(numGameSet);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();

			Thread.sleep(1000);
			
		}
	}
	
	public void next(int [][] numGameSet, boolean [][] gameSet)
	{
		gameSet = changeCells(gameSet);		
		tracing(numGameSet, gameSet);		
		print(numGameSet);
		System.out.println();
		
	}
	
	/*void stop(int [][]numGameSet, boolean [][]gameSet)
	{
		
	}*/
	
}

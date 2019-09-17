class Board
{
	private int boardsize=3;
	private char Board[][];
	private char symbol1, symbol2;
	//Number of cells that have been marked
	private int count;
	public static final int PLAYER1WON=1;
	public static final int PLAYER2WON=2;
	public static final int DRAW=3;
	public static final int INVALID=4;
	public static final int INCOMPLETE=5;


	public Board(char p1symbol, char p2symbol)
	{
		this.symbol1=p1symbol;
		this.symbol2=p2symbol;
		Board= new char [boardsize][boardsize];
		for(int i=0;i<boardsize;i++)
		{
			for(int j=0;j<boardsize;j++)
			{
				Board[i][j]=' ';
			}
		}
	}
	public int move(char symbol , int x, int y)
	{
		if(x < 0 || x>=boardsize || y<0 || y>= boardsize )
			return INVALID;

		  Board[x][y]= symbol;
		  count++;

		if(Board[x][0] == Board[x][1] && Board[x][0] == Board[x][2])
		{
			if(symbol == symbol1)
				return PLAYER1WON;
			else
				return 
			PLAYER2WON;
		}
		if(Board[0][y] == Board[1][y] && Board[0][y] == Board[2][y])
		{
			if(symbol == symbol1)
				return PLAYER1WON;
			else
				return 
			PLAYER2WON;
		}
		if(Board[1][1]!=' ' && Board[1][1]== Board[2][2] && Board[1][1]== Board[3][3])
		{
		if(symbol == symbol1)
				return PLAYER1WON;
			else
				return 
			PLAYER2WON;	
		}
		if(Board[0][2]!=' ' && Board[0][2]== Board[2][2] && Board[0][2]== Board[2][0])
		{
			if(symbol == symbol1)
				return PLAYER1WON;
			else
				return 
			PLAYER2WON;	
		}
		if(count == boardsize*boardsize)
			return DRAW;

		  return INCOMPLETE;


	}
	public void print()
	{
		System.out.println("-------------------");
		for(int i=0;i<boardsize;i++)
		{
			for(int j=0;j<boardsize;j++)
			{
                System.out.print("|  " + Board[i][j] + "|  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------");
	}
}
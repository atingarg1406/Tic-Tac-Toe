import java.util.Scanner;
class TicTacToe
{
	private Player player1, player2;
	private Board board;
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
           game.startGame();
	}

	public void startGame()
	{
		Scanner s = new Scanner(System.in);

		//Players input
		player1 = takePlayerInput(1);
		player2 = takePlayerInput(2);
		while(player1.getSymbol()==player2.getSymbol())
		{
           System.out.println("Enter another symbol !! This one has already been taken.");
           char symbol = s.next().charAt(0);
           player2.setSymbol(symbol);
		}
		//Create board
		board = new Board(player1.getSymbol(), player2.getSymbol());
		//Conduct the game
		boolean player1_turn= true;
		int status = board.INCOMPLETE;
		while(status == board.INCOMPLETE || status == board.INVALID)
		{
		  if(player1_turn)
		  {
				Scanner scan= new Scanner(System.in);
	         System.out.println("It's" +player1.getName()+"'s turn");
	         System.out.println("Enter x coordinate");
	         int x=scan.nextInt();
	         System.out.println("Enter y coordinate");
	         int y =scan.nextInt();
	         status = board.move(player1.getSymbol(), x,y);
            if(status != board.INVALID)
           {	
           	player1_turn = false;
              board.print();
           }
            else
             {
         	System.out.println("Invalid move, try again!!");
             }
		  }
		  else
		  {
         Scanner sin = new Scanner(System.in);
         System.out.println("It's" +player2.getName()+"'s turn");
         System.out.println("Enter x coordinate");
         int x=sin.nextInt();
         System.out.println("Enter y coordinate");
         int y =sin.nextInt();
         status = board.move(player2.getSymbol(), x,y);
         if(status != board.INVALID)
         	{
         		player1_turn = true;
         board.print();
            }
            else
            {
            	System.out.println("Invalid move, try again!!");
            }

		}
		
	}
	if(status== Board.PLAYER1WON)
			System.out.println("Player 1: "+ player1.getName()+" wins.");
	   	
	   	else if(status== Board.PLAYER2WON)
			System.out.println("Player 2: "+ player2.getName()+" wins.");
	   	
	   	else if(status== Board.DRAW)
			System.out.println("It's a draw");

}
	private Player takePlayerInput(int num)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter player"+num+"name:");
		String name=s.nextLine();
		System.out.println("Enter player"+num+"symbol:");
        char symbol= s.next().charAt(0);
        Player p = new Player(name,symbol);
        return p;
	}

}
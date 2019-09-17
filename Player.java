class Player
{
	private String name;
	private char symbol;
	private int number_of_games_played;
	private int number_of_games_won;

	public Player(String name, char symbol)
	{
		setName(name);
		setSymbol(symbol);
	}

	public void setName(String name)
	{
		if(!name.isEmpty())
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setSymbol(char symbol)
	{
		if(symbol != '\u0000')
		this.symbol=symbol;
    }
    public char getSymbol()
    {
    	return this.symbol;
    }



}
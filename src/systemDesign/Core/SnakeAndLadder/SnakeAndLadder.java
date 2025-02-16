package systemDesign.Core.SnakeAndLadder;

public class SnakeAndLadder {
	public static void main(String[] args)
	{
		Board board = new Board();
		board.initialize(1, 10, 2);
		board.players[0].name = "Vrittik";
		board.players[1].name = "Priya";
		
		board.addSnakesAndLadders(10, 7);
		
		board.startGame();
	}
}

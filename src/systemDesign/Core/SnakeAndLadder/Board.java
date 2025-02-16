package systemDesign.Core.SnakeAndLadder;
import java.util.*;

import javax.management.Query;

public class Board {
	Dice dice;
	int size; // n x n
	int numberOfPlayers;
	Cell[][] cells;
	Player[] players;
	
	public void initialize(int numberOfDice, int boardSize, int playerCount)
	{
		size = boardSize;
		numberOfPlayers = playerCount;
		Dice d = new Dice();
		d.diceCount = numberOfDice;
		dice = d;
		
		cells = new Cell[size][size];
		players = new Player[numberOfPlayers];
		
		for (int i = 0; i < size; i++) {
		    for (int j = 0; j < size; j++) {
		        cells[i][j] = new Cell();
		    }
		}
		
		for(int i = 0; i < numberOfPlayers; i++)
		{
			players[i] = new Player();
		}
	}
	
	public void addSnakesAndLadders(int snakes, int ladders)
	{
		Random random = new Random();
		while(snakes > 0)
		{
			int n = size*size;
			int head = random.nextInt(size+1, n);
			int tail = random.nextInt(size, n);
			if(head <= tail)
			{
				continue;
			}
			else 
			{
				int h_i = head/size;
				int h_j = head%size;
				
				Jump j = new Jump();
				j.start = head;
				j.end = tail;
				cells[h_i][h_j].jump = j;
			}
			snakes--;
		}
		
		while(ladders > 0)
		{
			int n = size*size;
			int foot = random.nextInt(size, n);
			int top = random.nextInt(size+1, n);
			if(top <= foot)
			{
				continue;
			}
			else 
			{
				int f_i = foot/size;
				int f_j = foot%size;
				
				if(cells[f_i][f_j].jump != null)
				{
					// should not apply ladders where snake is present
					continue;
				}
				Jump j = new Jump();
				j.start = foot;
				j.end = top;
				cells[f_i][f_j].jump = j;
			}
			ladders--;
		}
	}
	
	public void startGame()
	{
		Queue<Player> queue = new LinkedList<>();
		int finalStep = size*size;
		
		for(var player: players)
		{
			player.position = 0;
			queue.add(player);
		}
		
		System.out.println("Game of snake and ladder \n");
		
		while(true)
		{
			Player p = queue.poll();
			System.out.println(p.name + " turn at " + p.position);
			
			int roll = dice.rollDice();
			System.out.println("Dice number = " + roll);
			
			int newPosition = p.position + roll;
			
			if(newPosition > finalStep)
			{
				System.out.println("Step is greater than destination " + finalStep);
				queue.add(p);
				System.out.println("-------------------------\n");
				continue;
			}
			
			if(newPosition == finalStep)
			{
				System.out.println("Player: " + p.name + " has won.");
				return;
			}
			
			System.out.println(p.name+ " moved to number " + newPosition);
			p.position = newPosition;
			
			int n_i = newPosition/size;
			int n_j = newPosition%size;
			
			Cell newPosCell = cells[n_i][n_j];
			if(newPosCell.jump != null)
			{
				int end = newPosCell.jump.end;
				p.position = end;
				
				int start = newPosCell.jump.start;
				
				if(start < end) {
					System.out.println("Ladder came and " + p.name+ " moved to number " + end);
				}
				else {
					System.out.println("Snake came and " + p.name+ " moved to number " + end);
				}
			}
			queue.add(p);
			
			System.out.println("-------------------------\n");
		}
	}
}

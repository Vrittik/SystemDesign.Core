package systemDesign.Core.SnakeAndLadder;

import java.util.Random;

public class Dice {
	int diceCount;
	void setDiceCount(int newDiceCount)
	{
		diceCount = newDiceCount;
	}
	int rollDice() {
		Random random = new Random();
		int res = 0;
		int dc = diceCount;
		while(dc > 0)
		{
			res = res + random.nextInt(1, 6);
			dc--;
		}
		return res;
	}
}

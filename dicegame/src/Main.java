
public class Main {
	private static Player player1;
	private static Player player2;
	private static DiceGame diceGame;

	public static void main(String[] args) {
		player1 = new Player("ȫ�浿");
		player2 = new Player("��浿");
		diceGame = new DiceGame();
		playDiceGame();
	}
	
	public static void playDiceGame(){
		diceGame.play(player1, player2);
	}

}


public class Main {
	private static Player player1;
	private static Player player2;
	private static DiceGame diceGame;

	public static void main(String[] args) {
		player1 = new Player("홍길동");
		player2 = new Player("고길동");
		diceGame = new DiceGame();
		playDiceGame();
	}
	
	public static void playDiceGame(){
		diceGame.play(player1, player2);
	}

}

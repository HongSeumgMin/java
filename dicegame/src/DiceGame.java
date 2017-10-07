
public class DiceGame {
	private Die die;
	
	private Player winner(Player p1, Player p2){
		System.out.println(p1.getName()+":"+p1.getScore()+"Á¡ ");
		System.out.println(p2.getName()+":"+p2.getScore()+"Á¡ ");
		
		if(p1.getScore()>p2.getScore())
			return p1;
		else if(p2.getScore()>p1.getScore())
			return p2;
		else
			return new Player("¹«½ÂºÎ");
	}
	
	public DiceGame() {
		die = new Die(6);
	}
	public void play(Player p1, Player p2){
		p1.setScore(die.roll()+die.roll());
		p2.setScore(die.roll()+die.roll());
		
		System.out.println("½ÂÀÚ´Â "+winner(p1,p2).getName());
	}
}

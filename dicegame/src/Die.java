
import java.util.Random;

public class Die {
	private int size;

	public Die(int n){
		this.size = n;
	}
	public int roll() {
		Random rd = new Random();
		return rd.nextInt(this.size) + 1;
	}
}

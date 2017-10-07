import javax.swing.JButton;

public class CustomButton extends JButton{
	private int index;
	int imgIndex;
	public CustomButton(int index) {
		// TODO Auto-generated constructor stub
		this.index = index;
	}

	public int getIndex(){
		return this.index;
	}
	
	public void setImgIndex(int i){
		this.imgIndex = i;
	}
	
	public int getImgIndex(){
		return this.imgIndex;
	}
}

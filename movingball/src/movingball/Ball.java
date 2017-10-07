package movingball;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private int x;
	private int y;
	private int size;
	private int xSpeed;
	private int ySpeed;

	public void draw(Graphics g) {
		
		/*
		switch ((int) (Math.random() * 6)) {
		case 0:
			g.setColor(Color.RED);
			break;
		case 1:
			g.setColor(Color.BLUE);
			break;
		case 2:
			g.setColor(Color.BLACK);
			break;
		case 3:
			g.setColor(Color.GREEN);
			break;
		case 4:
			g.setColor(Color.CYAN);
			break;
		case 5:
			g.setColor(Color.PINK);
			break;
		}
		
*/
		g.setColor(new Color((int) (Math.random() *256), (int) (Math.random() *256), (int) (Math.random() *256)));
		
		g.fillOval(x, y, size, size);
	}

	public void update() {
		if ((int) (Math.random() * 10000) > 9990) {
			if (xSpeed < 0)
				xSpeed = -((int) (Math.random() * 3) + 1);
			else
				xSpeed = (int) (Math.random() * 3) + 1;

			if (ySpeed < 0)
				ySpeed = -((int) (Math.random() * 3) + 1);
			else
				ySpeed = (int) (Math.random() * 3) + 1;
		}

		x += xSpeed;
		y += ySpeed;

		if (x > MyPanel.BOARD_WIDTH - size || x < 0) {
			xSpeed = -xSpeed;
		}
		if (y > MyPanel.BOARD_HEIGHT - size || y < 0) {
			ySpeed = -ySpeed;
		}
	}

	public Ball() {
		size = (int)(Math.random()*50)+10;
		
		x = (int) (Math.random() * MyPanel.BOARD_WIDTH-100)/2+200;
		y = (int) (Math.random() * MyPanel.BOARD_HEIGHT-100)/2+200;
		
		xSpeed = (int) (Math.random() * 10) + 1;
		switch ((int) (Math.random() * 4)) {
		case 0:
			xSpeed =-xSpeed;
			ySpeed =-ySpeed;
			break;
		case 1:
			ySpeed = -ySpeed;
			break;
		case 2:
			xSpeed = -xSpeed;
			ySpeed = xSpeed;
			break;
		case 3:
			ySpeed = xSpeed;
			break;
		}
	}
}

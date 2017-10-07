package movingball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	static final int BOARD_WIDTH = 1900;
	static final int BOARD_HEIGHT = 1000;
	static final int BALL_QUANTITY = 200;
	private Ball[] ball;
	private Thread t1;

	private boolean flag = true;

	public MyPanel() {
		ball = new Ball[BALL_QUANTITY];

		for (int i = 0; i < BALL_QUANTITY; i++)
			ball[i] = new Ball();

		this.setSize(MyPanel.BOARD_WIDTH, MyPanel.BOARD_HEIGHT);

		/////////////////
		this.setBackground(Color.YELLOW);

		//////////////////////

		Runnable task2 = () -> {
			while (true) {
				if (flag) {

					this.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
							(int) (Math.random() * 256)));
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

				}
			}
		};

		new Thread(task2).start();
		
		Runnable task = () -> {
			while (true) {
				if (flag) {
					for (int i = 0; i < BALL_QUANTITY; i++)
						ball[i].update();

					//this.setBackground(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
					//		(int) (Math.random() * 256)));

					/*
					 * switch ((int) (Math.random() * 6)) { case 0:
					 * this.setBackground(new Color(flags, flags, flags));
					 * break; case 1: this.setBackground(Color.BLUE); break;
					 * case 2: this.setBackground(Color.BLACK); break; case 3:
					 * this.setBackground(Color.GREEN); break; case 4:
					 * this.setBackground(Color.CYAN); break; case 5:
					 * this.setBackground(Color.PINK); break; case 6:
					 * this.setBackground(Color.MAGENTA); break; case 7:
					 * this.setBackground(Color.YELLOW); break; }
					 */
					repaint();
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {

				}
			}
		};

		t1 = new Thread(task);
		t1.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < BALL_QUANTITY; i++)
			ball[i].draw(g);
	}

	public void runrunrun() {
		JFrame frame = new JFrame();
		JButton btStart = new JButton("Start");
		JButton btStop = new JButton("Stop");

		btStart.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				flag = true;
			}
		});

		btStop.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				flag = false;
			}
		});

		frame.setLayout(null);
		frame.setSize(MyPanel.BOARD_WIDTH + 15, MyPanel.BOARD_HEIGHT + 80);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);

		JPanel pn = new JPanel(new GridLayout(1, 2, 3, 3));

		frame.add(pn);
		pn.setBackground(Color.BLACK);
		pn.setBounds(0, MyPanel.BOARD_HEIGHT, MyPanel.BOARD_WIDTH, 40);

		pn.add(btStart);
		pn.add(btStop);
	}

	public static void main(String[] args) {
		MyPanel myPanel = new MyPanel();
		myPanel.runrunrun();
	}
}

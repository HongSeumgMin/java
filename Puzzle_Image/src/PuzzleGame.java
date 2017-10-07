import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PuzzleGame extends JFrame{

	private JPanel pnMainPanel;
	private JPanel pnPuzzleMain;
	private JTextField tfPieces;
	private BufferedImage img = null;
	private int pieces=5;
	private int totPieces;
	private CustomButton[] pieceNumber;
	private ImageIcon[] icon;

	public PuzzleGame() {
		setTitle("Àç¹ÌÀÖ´Â ÆÛÁñ ³îÀÌ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 700);
		pnMainPanel = new JPanel();
		pnMainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnMainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(pnMainPanel);

		pnPuzzleMain = new JPanel();
		pnMainPanel.add(pnPuzzleMain, BorderLayout.CENTER);
		pnPuzzleMain.setLayout(new GridLayout(5, 5, 0, 0));

		JPanel pnPuzzleMenu = new JPanel();
		pnMainPanel.add(pnPuzzleMenu, BorderLayout.SOUTH);

		JLabel label = new JLabel("Ä­¼ö´Â?");
		pnPuzzleMenu.add(label);

		tfPieces = new JTextField();
		tfPieces.setText("5");
		pnPuzzleMenu.add(tfPieces);
		tfPieces.setColumns(10);

		JButton btSetPieces = new JButton("Àû¿ë");
		btSetPieces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//pnPuzzleMain.removeAll();
				pnMainPanel.remove(pnPuzzleMain);
				pieces = Integer.parseInt(tfPieces.getText());

				pnPuzzleMain = new JPanel();
				pnPuzzleMain.setLayout(new GridLayout(pieces, pieces, 0, 0));
				pnMainPanel.add(pnPuzzleMain, BorderLayout.CENTER);
				
				totPieces = pieces * pieces;

				if (img != null) {
					icon = new ImageIcon[totPieces];
					
					for(int i=0; i<totPieces;i++){
						icon[i] = new ImageIcon();
						icon[i] = new ImageIcon(subImage(img, i));
					}
				}
				
				//MyButton.initCount();
				pieceNumber = new CustomButton[totPieces];
				for (int i = 0; i < totPieces; i++) {
					pieceNumber[i] = new CustomButton(i);
					pieceNumber[i].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							CustomButton b = (CustomButton) e.getSource();
							int index = b.getIndex();
							int x = index % pieces;
							int y = index / pieces;

							ImageIcon buf;
							
							if (b.getIcon() == null)
								return;
							else {
								if (x == pieces - 1) { // µ¿
									if (y == pieces - 1) { // µ¿³² //À§,ÁÂ ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) { // µ¿³²ÀÇ ºÏ
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) { // µ¿³²ÀÇ ¼­
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else if (y == 0) { // µ¿ºÏ //¾Æ·¡,ÁÂ ¹Ù²Þ
										if (pieceNumber[index + pieces].getIcon() == null) {
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) {
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else { // µ¿ÂÊ ¾îµò°¡ // À§,¾Æ·¡,ÁÂ ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) { //À§
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + pieces].getIcon() == null) { //¾Æ·¡
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) { //ÁÂ
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									}
								} else if (x == 0) { // ¼­
									if (y == pieces - 1) { // ¼­³² // À§,¿ì ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) {
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else if (y == 0) { // ¼­ºÏ // ¾Æ·¡,¿ì ¹Ù²Þ
										if (pieceNumber[index + pieces].getIcon() == null) {
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else { // ¼­ÂÊ ¾îµò°¡ // À§,¾Æ·¡,¿ì ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) {
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + pieces].getIcon() == null) {
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									}
								} else {
									if (y == pieces - 1) { // X³² //À§,ÁÂ,¿ì ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) {
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) {
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else if (y == 0) { // XºÏ //¾Æ·¡,ÁÂ,¿ì ¹Ù²Þ
										if (pieceNumber[index + pieces].getIcon() == null) {
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) {
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									} else { // ¼¾ÅÍ //À§,¾Æ·¡,ÁÂ,¿ì ¹Ù²Þ
										if (pieceNumber[index - pieces].getIcon() == null) {
											pieceNumber[index - pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + pieces].getIcon() == null) {
											pieceNumber[index + pieces].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index - 1].getIcon() == null) {
											pieceNumber[index - 1].setIcon(b.getIcon());
											b.setIcon(null);
										} else if (pieceNumber[index + 1].getIcon() == null) {
											pieceNumber[index + 1].setIcon(b.getIcon());
											b.setIcon(null);
										}
									}
								}

								if(isCheck()){
									JOptionPane.showMessageDialog(null, "Â¦Â¦Â¦ ¿Ï¼ºÇÏ¿´½À´Ï´ç.");
								}
								//pieceNumber[8].transferFocus();
								//if (isCheck()) {
								//	JOptionPane.showMessageDialog(null, "Á¤´äÀÔ´Ï´Ù.");
								//}
							}
					
						}
					});
					pnPuzzleMain.add(pieceNumber[i]);
				}

				if (img != null) {
					if (totPieces == 1) {
						pieceNumber[0].setIcon(icon[0]);
						pieceNumber[0].setImgIndex(0);
						//pieceNumber[0].setPieceNumber(0);
					} else
						for (int i = 0; i < totPieces - 1; i++) {
							pieceNumber[i].setIcon(icon[i]);
							pieceNumber[i].setImgIndex(i);
							//pieceNumber[i].setPieceNumber(i);
						}
				}
				//pnPuzzleMain.repaint();
				setVisible(true);
			}
		});
		pnPuzzleMenu.add(btSetPieces);

		JButton btOpenImage = new JButton("ÀÌ¹ÌÁö ºÒ·¯¿À±â");
		btOpenImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});
		pnPuzzleMenu.add(btOpenImage);

		JButton btShuffle = new JButton("¼¯¾î~");
		btShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shuffle();
			}
		});
		pnPuzzleMenu.add(btShuffle);

		JButton btHint = new JButton("ÈùÆ®!");
		btHint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new hintForm();
			}
		});
		pnPuzzleMenu.add(btHint);

		setVisible(true);
	}

	private boolean isCheck() {
		for (int i = 0; i < totPieces-1; i++) {
			if(pieceNumber[i].getImgIndex()==i){
				
			}
			else{
				return false;
			}
		}
		return true;
	}

	private void load() {
		File file = null;

		JFileChooser fs = new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("°ñ¶ó~ °ñ¶ó~");
		fs.setFileFilter(new FileTypeFilter(".jpg", "ÀÌ¹ÌÁö ÆÄÀÏ"));

		int result = fs.showOpenDialog(null);

		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				file = fs.getSelectedFile();
			} catch (Exception e) {
			}
		}
		
		try {
			img = ImageIO.read(file);
			Image resize = img.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
			BufferedImage newImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
			Graphics g = newImage.getGraphics();
			g.drawImage(resize, 0, 0, this);
			g.dispose();

			img = newImage;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "ÀÌ¹ÌÁö¸¦ ºÒ·¯¿Ã ¼ö ¾ø½À´Ï´Ù.");
		}
	}

	private void shuffle() {
		Random rand = new Random();
		int[] sequence = new int[totPieces-1];
		
		boolean flag = false;

		for (int i = 0; i < totPieces - 1; i++) {
			int r = (rand.nextInt(totPieces - 1));
			flag = true;
			for (int j = 0; j < i; j++) {
				if (sequence[j]==r) {
					i--;
					flag = false;
					break;
				}
			}
			if(flag)
			sequence[i] = r;
		}
		
		for(int i =0; i< totPieces-1;i++){
			pieceNumber[i].setIcon(icon[sequence[i]]);
			pieceNumber[i].setImgIndex(sequence[i]);
		}
		pieceNumber[totPieces-1].setIcon(null);
	}

	private BufferedImage subImage(BufferedImage source, int index) {
		BufferedImage buf;
		int srcImageWidth = source.getWidth();
		int srcImageHeight = source.getHeight();
		int x = index % pieces;
		int y = index / pieces;
		int destImageWidth = srcImageWidth / pieces;
		int destImageHeight = srcImageHeight / pieces;

		buf = source.getSubimage(x * destImageWidth, y * destImageHeight, destImageWidth, destImageHeight);

		return buf;
	}

	class hintForm extends JFrame {
		public hintForm() {
			setTitle("ÈùÆ®!!");
			setBounds(100, 100, 600, 700);

			Hint hint = new Hint();
			add(hint);
			setVisible(true);
		}

		class Hint extends JPanel {

			public Hint() {
				// TODO Auto-generated constructor stub
			}

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponents(g);

				try {
					g.drawImage(img, 0, 0, 600, 600, null);
				} catch (Exception e) {
				}
			}

		}
	}

}


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class Grid extends JPanel implements MouseListener{

	private static int ROWS = 7;
	private static int COLS = 7;
	private int startX = 10;
	private int startY = 10;
	private int cellWidth = 40;
	int player = 2;//start with red, yellow is player 1
	int playAgain = 0;//0 - YES, 1- NO


	Color[][] gridColor = new Color[ROWS][COLS];

	private GameRun game;
	private int[][] playerGrid = new int[ROWS][COLS];


	//public Grid(Dimension dimension, Graphics g) {
	public Grid(Graphics g) {

		game = new GameRun(ROWS, COLS, this);
		addMouseListener(this);

	}


	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		//super.paintComponent(g2d);

		startX = 0;
		startY =0;

		drawGrid(g2d);

	}

	//draw and initialize the grid
	public void drawGrid(Graphics2D g2d) {

		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {

				gridColor[i][j] = new Color(255,255,255);
				g2d.setColor(new Color(128,128,255));
				g2d.fillRect(startX,startY,cellWidth,cellWidth);

				g2d.setColor(new Color(255,255,255));
				g2d.fillOval(startX,startY,cellWidth, cellWidth);
				startX = startX + cellWidth;
				playerGrid[i][j] = 0;

			}
			startX = 0;
			startY = startY + cellWidth;
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {

		Graphics2D g2d = (Graphics2D)this.getGraphics();


		int col = e.getX()/cellWidth;
		int row = e.getY()/cellWidth;
		int x = col * cellWidth;
		int y = row * cellWidth;

		if(gridColor[row][col].equals(new Color(255,255,255))) {

			if(player == 2) {

				g2d.setColor(new Color(255,0,0));
				gridColor[row][col] = new Color(255,0,0);

				g2d.fillOval(x,y,cellWidth, cellWidth);
				playerGrid[row][col] = 2;

				if(game.tie(playerGrid)) {
					System.out.println("tie------------");
				}

				if(game.win(playerGrid, player)){


					playAgain = JOptionPane.showConfirmDialog(
							this,
							"Red Win!! Do you like play again?",
							"Connect Four",
							JOptionPane.YES_NO_OPTION);

					if(playAgain == 1) {
						System.exit(0);
					}
					else if (playAgain == 0){


						this.add(new Grid(this.getGraphics()));
						repaint();


					}
					else {

					}

				}



				player = 1;



			}else {


				g2d.setColor(new Color(255,255,0));
				g2d.fillOval(x,y,cellWidth, cellWidth);
				gridColor[row][col] = new Color(255,255,0);
				playerGrid[row][col] = 1;

				if(game.tie(playerGrid)) {
					System.out.println("tie------------");
				}

				
				if(game.win(playerGrid, player)){
					JOptionPane.showConfirmDialog(
							this,
							"Yellow Win!! Do you like play again?",
							"Connect Four",
							JOptionPane.YES_NO_OPTION);

					if(playAgain == 1) {
						System.exit(0);
					}
					else if (playAgain == 0){
						this.add(new Grid(this.getGraphics()));

						repaint();
					}
					else {

					}
				}

				player = 2;



			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



}

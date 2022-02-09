import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class Grid extends JPanel implements MouseListener{

	private static int ROWS = 7;
	private static int COLS = 7;
	private int startX = 10;
	private int startY = 10;
	private int cellWidth = 40;
	int player = 2; 

	
	Color[][] gridColor = new Color[ROWS][COLS];
	
	private GameRun game;
	private int[][] playerGrid = new int[ROWS][COLS];
	

	public Grid(Dimension dimension, Graphics g) {
		
		setSize(dimension);
		setPreferredSize(dimension);
		
		game = new GameRun(ROWS, COLS, this);

		//this.setGrphics();
		addMouseListener(this);

	}
	
	/**
	 * @param frame the frame to set
	 */
	//public void setFrame(JFrame frame) {
	//	this.frame = frame;
	//}


	
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
				//g2d.setColor(gridColor[i][j]);
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
				
		System.out.println(gridColor[row][col]);
		System.out.println(gridColor[row][col].equals(new Color(255,255,255)));

		
		//do {
			if(!(gridColor[row][col].equals(new Color(255,255,255)))) {
				System.out.println("Not a Valid Entry");
			}else {
		
				if(player == 2) {
					System.out.println("set color=" + "red");
					
					g2d.setColor(new Color(255,0,0));
					gridColor[row][col] = new Color(255,0,0);
					//System.out.println("x=" + x + " y=" + y);
					g2d.fillOval(x,y,cellWidth, cellWidth);
					playerGrid[row][col] = 2;
					
					
					if(game.win(playerGrid, player)){
						System.out.println("Red win?? = " + game.win(playerGrid, player));
						//break;
					}
				
					
					
					player = 1;
					
					
		
				}else {
					
					System.out.println("set color=" + "yellow");
					
					g2d.setColor(new Color(255,255,0));
					//System.out.println("x=" + x + " y=" + y);
					g2d.fillOval(x,y,cellWidth, cellWidth);
					gridColor[row][col] = new Color(255,255,0);
					playerGrid[row][col] = 1;
					
					System.out.println("Yellow win?? = " + game.win(playerGrid, player));
					
					player = 2;
					
					
		
				}
			}
			
	
			
	//	}while(true);
			
	
		
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

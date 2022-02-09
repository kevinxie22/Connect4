import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;


public class Grid extends JPanel implements MouseListener{
	JFrame frame;
	private static int ROWS = 7;
	private static int COLS = 7;
	private int startX = 10;
	private int startY = 10;
	private int cellWidth = 40;
	private int ovalWidth = 20;
	private int ovalHeight = 10;
	
	Color[][] gridColor = new Color[ROWS][COLS];
	
	
	public void drawGrid() {
		frame = new JFrame("Connect Four");
		frame.setSize(700,600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setPreferredSize(frame.getSize());
		
		paintComponent(frame.getGraphics());
	
		frame.pack();
		frame.setVisible(true);
		

	
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				gridColor[i][j] = new Color(255,255,255);
			}
		}
		

		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		

		startX = 0;
		startY =0;
		
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				//g2d.setColor(gridColor[i][j]);
				g2d.setColor(new Color(0,0,0));
				g2d.fillRect(startX,startY,cellWidth,cellWidth);
				g2d.setColor(new Color(255,255,255));
				g2d.fillOval(startX,startY,cellWidth, cellWidth);
				startX = startX + cellWidth;
		
			}
			startX = 0;
			startY = startY + cellWidth;
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

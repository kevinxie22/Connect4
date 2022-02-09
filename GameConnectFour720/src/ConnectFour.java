import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;


public class ConnectFour extends JFrame {

		private static int column;
		private static int player1 = 1, player2 = 2;
		private static int player = player1; 
	 
		private static Scanner input = new Scanner(System.in);
		
	    public ConnectFour() {
	        initUI();
	    }
	    
		
	    private void initUI() {
	    	
 	        
 	        this.setTitle("Connect Four");
 	        this.setSize(500, 500);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setPreferredSize(getSize());
	        this.add(new Grid(this.getSize(), this.getGraphics()));

	        pack();
	        setLocationRelativeTo(null);
	        
	       	        
	    }
	 
		public static void main(String[] args) {
	 
			var connect4 = new ConnectFour();
	        connect4.setVisible(true);
	        
			
		}
}

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

	        add(new Grid());

	        setTitle("Connect Four");
	        setDefaultCloseOperation(EXIT_ON_CLOSE);

	        setSize(480, 640);
	        setLocationRelativeTo(null);
	    }
	 
		public static void main(String[] args) {
	 
	        var ex = new ConnectFour();
            ex.setVisible(true);

			
		//	Grid grid = new Grid();

		//	grid.drawGrid();
			
			Core game = new Core();
			
			// continue until tie or somebody won
			while (game.tie() == true && game.getWin() == 0) {
	 
				while (true) {
					System.out.print("Drop a " + (player == 1 ? "red" : "yellow")
							+ " disk at column (0-6): ");
					column = input.nextInt();
					if(!game.placeNext(column, player)) {
						break;
					}
						
				}
	 
				// players change the turn 
				if (player == player1) {
					player = player2;
				} else {
					player = player1;
				}

			}
		}
}

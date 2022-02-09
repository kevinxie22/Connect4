import java.awt.BorderLayout;
import javax.swing.JFrame;

public class ConnectFour extends JFrame {
 
		private Grid gameBoard;
		
	    public ConnectFour() {
	        initUI();
	    }
	    
	    private void initUI() {
	    	
  	        this.setTitle("Connect Four");
 	        this.setSize(296, 320);
 	        this.setResizable(false);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setPreferredSize(getSize());
	        this.setLayout(new BorderLayout());
	        
	        gameBoard = new Grid( this.getGraphics());
	        
	        this.add(gameBoard,BorderLayout.CENTER);
	        pack();
	        setLocationRelativeTo(null);
 
	      	        
	    }
	 
		public static void main(String[] args) {
	 
			ConnectFour connect4 = new ConnectFour();
	        connect4.setVisible(true);
	        
			
		}


}

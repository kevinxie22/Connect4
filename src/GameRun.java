import java.awt.Color;

public class GameRun {
	
	private int rows = 7;
	private int cols = 7;
	private int[][] grid = new int[rows][cols];
	Grid matrix;


	
	public GameRun(int rows, int cols, Grid grid){
		this.rows = rows;
		this.cols = cols;
		matrix = grid;
		
	}
	

	public boolean win(int[][] playerGrid, int player) {
		
		
		for (int i = 0; i < 7; i++) {   	
			for (int j=0 ; j < 4 ; j++){

				if(playerGrid[i][j] == playerGrid[i][j+1] && playerGrid[i][j+1] == playerGrid[i][j+2] &&
				playerGrid[i][j+2] == playerGrid[i][j+3] && playerGrid[i][j+3] == player)
				{
					return true;
				}
				else if (playerGrid[j][i] == playerGrid[j+1][i] && playerGrid[j+1][i] == playerGrid[j+2][i]
						&& playerGrid[j+2][i] == playerGrid[j+3][i]&& playerGrid[j+3][i] == player ) {
					return true;

				}
			}
            
		}
	
		
		for (int i = 0; i < 4; i++) {   	
			for (int j = 0 ; j < 4 ; j++){
				if (playerGrid[i][j] == playerGrid[i+1][j+1] && playerGrid[i+1][j+1] == playerGrid[i+2][j+2]
	            		&& playerGrid[i+2][j+2] == playerGrid[i+3][j+3] && playerGrid[i+3][j+3] == player) {
	            	return true;
	            }
				if (playerGrid[i][6-j] == playerGrid[i+1][5-j] && playerGrid[i+1][5-j] == playerGrid[i+2][4-j]
	            		&& playerGrid[i+2][4-j] == playerGrid[i+3][3-j] && playerGrid[i+3][3-j] == player) {
	            	return true;
	            }
			}
		}
		return false;

	}	

	public boolean tie(int[][] playerGrid) {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (playerGrid[i][j] != 0) {
					return true;
				}
			}
		}
		System.out.println("Y and R tie.");
		return false;
	}


		
	//check if the place available for next player
	/*
	 * public boolean placeNext(int col, int player) { if (col < 0 || col > cols-1
	 * || grid[0][col] != 0) { System.out.println("Input Error! Please re-enter.");
	 * return true; } for (int i = 6; i >= 0; i--) { //for (int i = 0; i >= 6; i++)
	 * { if (grid[i][col] == 0) { grid[i][col] = player; drawGrid(); win(grid,
	 * player); return false; } }
	 * 
	 * return true; }
	 */
	/*
	 * private void drawGrid() {
	 * 
	 * for (int i = 0; i < 7; ++i) { for (int j = 0; j < 7; ++j) {
	 * System.out.print("|" + (grid[i][j] == 0 ? " " : (grid[i][j] == 1 ? "Y" :
	 * "R")) + ""); if (j == 6) { System.out.println("|"); } } }
	 * System.out.println("---------------");
	 * 
	 * }
	 */


}

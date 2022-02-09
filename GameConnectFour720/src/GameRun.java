import java.awt.Color;

public class GameRun {
	
	private int rows = 7;
	private int cols = 7;
	private int[][] grid = new int[rows][cols];
	Grid matrix;

	private int win  = 0;
	
	/**
	 * @return the win
	 */
	public GameRun(int rows, int cols, Grid grid){
		this.rows = rows;
		this.cols = cols;
		matrix = grid;
		
	}
	
	public int getWin() {
		return win;
	}

	
//	public void win(int row, int col, int player) {
//		int[] count = {0,0,0,0};
//		
//		//check if 4 connected in the column
//		for (int i = 0; i < rows; i++) {
//			if (grid[row][i] == player) {
//				count[0]++;
//			} else if (count[0] < 4) {
//				count[0] = 0;
//			}
//		}
//		
//		//check if 4 connected in the row
//		for (int i = 0; i < cols; i++) {
//			if (grid[i][col] == player) {
//				count[1]++;
//			} else if (count[1] < 4) {
//				count[1] = 0;
//			}
//		
//		}
//		
//		if (row < 4 && col > 2) {
//			for (int i = row, j = col; i < 7; i++, j--) {
//				System.out.println("case 2 ----i=" + i + " j=" + j + " player=" + player + "grid[i][j]" + grid[i][j]);
//				if (grid[i][j] == player) {
//					count[2]++;
//				} else {
//					count[2] = 0;
//				}
//			}
//			
//		}
//		
//		if (row < 4 && col < 4) {
//			for (int i = row, j = col; i < 6; i++, j++) {
//				System.out.println("case3 ---i=" + i + " j=" + j + " player=" + player + "grid[i][j]" + grid[i][j]);
//				if (grid[i][j] == player) {
//					count[3]++;
//				} else {
//					count[3] = 0;
//				}
//			}
//		
//		}
// 
//
//		for (int i=0; i< count.length; i++)	{
//			if (count[i] >= 4) {
//				System.out.println((player == 1 ? "red" : "yellow") + " win.");
//				win = 1;
//			}
//		}
//		
//		
//		System.out.println("count0=" + count[0]);
//		System.out.println("count1=" + count[1]);
//		System.out.println("count2=" + count[2]);
//		System.out.println("count3=" + count[3]);
//		
//		drawGrid();
//
//	}
//	
	
	public boolean win(int[][] playerGrid, int player) {
		
		
		for (int i = 0; i < 7; i++) {   	
			for (int j=0 ; j < 4 ; j++){
				//System.out.println(playerGrid[i][j]+" " +  playerGrid[i][j+1] +" " +  playerGrid[i][j+2]+ " " + playerGrid[i][j+3]);
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

	public boolean tie() {
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (grid[i][j] == 0) {
					return true;
				}
			}
		}
		System.out.println("Y and R tie.");
		return false;
	}


		
	//check if the place available for next player
	public boolean placeNext(int col, int player) {
		if (col < 0 || col > cols-1 || grid[0][col] != 0) {
			System.out.println("Input Error! Please re-enter.");
			return true;
		}
		for (int i = 6; i >= 0; i--) {
		//for (int i = 0; i >= 6; i++) {
			if (grid[i][col] == 0) {
				grid[i][col] = player;
				drawGrid();
				win(grid, player);
				return false;
			}
		}
		
		return true;
	}

	private void drawGrid() {
		
		for (int i = 0; i < 7; ++i) {
			for (int j = 0; j < 7; ++j) {
				System.out.print("|"
						+ (grid[i][j] == 0 ? " " : (grid[i][j] == 1 ? "Y"
								: "R")) + "");
				if (j == 6) {
					System.out.println("|");
				}
			}
		}
		System.out.println("---------------");

	}



}

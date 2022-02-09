
public class Core {
	
	private int rows = 7;
	private int cols = 7;
	private int[][] grid = new int[rows][cols];

	private int win = 0;
	
	/**
	 * @return the win
	 */
	public int getWin() {
		return win;
	}

	
	
	public void win(int row, int col, int player) {
		int[] count = {0,0,0,0};
		
		//check if 4 connected in the row
		for (int i = 0; i < rows; i++) {
			if (grid[row][i] == player) {
				count[0]++;
			} else if (count[0] < 4) {
				count[0] = 0;
			}
		}
		
		//check if 4 connected in the column
		for (int i = 0; i < cols; i++) {
			if (grid[i][col] == player) {
				count[1]++;
			} else if (count[1] < 4) {
				count[1] = 0;
			}
		}
		
		if (row < 4 && col > 2) {
			
			for (int i = row, j = col; i < 7; i++, j--) {
				if (grid[i][j] == player) {
					count[2]++;
				} else {
					count[2] = 0;
				}
			}
		}
		
		if (row < 4 && col < 4) {
			for (int i = row, j = col; i < 7; i++, j++) {
				if (grid[i][j] == player) {
					count[3]++;
				} else {
					count[3] = 0;
				}
			}
		}
 

		for (int i=0; i<4; i++)	{
			if (count[i] >= 4) {
				System.out.println((player == 1 ? "red" : "yellow") + " win.");
				win = 1;
			}
		}


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
			if (grid[i][col] == 0) {
				grid[i][col] = player;
				drawGrid();
				win(i, col, player);
				return false;
			}
		}
		
		return true;
	}

	private void drawGrid() {
		
		for (int i = 0; i < 7; ++i) {
			for (int j = 0; j < 7; ++j) {
				System.out.print("|"
						+ (grid[i][j] == 0 ? " " : (grid[i][j] == 1 ? "R"
								: "Y")) + "");
				if (j == 6) {
					System.out.println("|");
				}
			}
		}
		System.out.println("---------------");

	}

}

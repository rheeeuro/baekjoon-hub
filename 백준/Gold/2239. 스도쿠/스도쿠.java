

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[][ ] sudoku;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = line.charAt(j) - '0';
			}
		}
		fill(0);
	}
	
	public static void fill(int n) {
		int a = n / 9;
		int b = n % 9;
		
		if (n == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		} 
		
		if (sudoku[a][b] != 0) fill(n+1);
		if (sudoku[a][b] == 0) {
			for (int d = 1; d <= 9; d++) {
				boolean valid = true;
				for (int i = 0; i < 9; i++) {
					int sx = ((int)a/3) * 3 + (((int)i/3));
					int sy = ((int)b/3) * 3 + (i%3);
					if (sudoku[a][i] == d || sudoku[i][b] == d || sudoku[sx][sy] == d) {
						valid = false;
						break;
					}
				}
				
				if (!valid) continue;
				
				sudoku[a][b] = d;
				fill(n+1);
				sudoku[a][b] = 0;
			}
		}
		
	}
}

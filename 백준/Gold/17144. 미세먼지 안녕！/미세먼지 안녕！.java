

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int r, c, t;
	static int[][] map;
	static int up;
	static int down;
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rct = br.readLine().split(" ");
		r = Integer.parseInt(rct[0]);
		c = Integer.parseInt(rct[1]);
		t = Integer.parseInt(rct[2]);
		
		map = new int[r][c];
		up = -1;
		down = -1;
		for (int i = 0; i < r; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] == -1) {
					if (up == -1) {
						up = i;
					} else {
						down = i;
					}
				}
			}
		}
		
		for (int i = 0; i < t; i++) {
			spread();
			wind();
			map[up][0] = -1;
			map[down][0] = -1;
		}
		
		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] != -1) {
					result += map[i][j];					
				}
			}
		}
		System.out.println(result);
		
	}

	private static void wind() {
		int[][] newmap = new int[r][c];
		int i;
		for (i = 0; i < r; i++) {
			Arrays.fill(newmap[i], -9);
		}
		for (i = 0; i < c-1; i++) {
			newmap[up][i+1] = map[up][i];
		}
		for (i = up; i > 0; i--) {
			newmap[i-1][c-1] = map[i][c-1];
		}
		for (i = c-1; i > 0; i--) {
			newmap[0][i-1] = map[0][i];
		}
		for (i = 0; i < up-1; i++) {
			newmap[i+1][0] = map[i][0];
		}
		
		for (i = 0; i < c-1; i++) {
			newmap[down][i+1] = map[down][i];
		}
		for (i = down; i < r-1; i++) {
			newmap[i+1][c-1] = map[i][c-1];
		}
		for (i = c-1; i > 0; i--) {
			newmap[r-1][i-1] = map[r-1][i];
		}
		for (i = r-1; i > down+1; i--) {
			newmap[i-1][0] = map[i][0];
		}
		
		

	
		
		for (int j = 0; j < r; j++) {
			for (int j2 = 0; j2 < c; j2++) {
				if (newmap[j][j2] != -9) {
					map[j][j2] = newmap[j][j2];
				}
			}
		}
	}

	private static void spread() {
		int[][] newmap = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					int count = 4;
					for (int[] d : direction) {
						int newI = i + d[0];
						int newJ = j + d[1];
						if (newI >= r || newJ >= c || newI < 0 || newJ < 0) {
							count -= 1;
							continue;
						} else if (map[newI][newJ] == -1) {
							count -= 1;
							continue;
						}
						newmap[newI][newJ] += map[i][j] / 5;
					}
					newmap[i][j] += map[i][j] - (map[i][j] / 5) * count;
				}
			}
		}
		map = newmap;
	}
	
}

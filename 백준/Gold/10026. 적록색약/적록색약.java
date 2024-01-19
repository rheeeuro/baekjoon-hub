import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static char[][] pic;
	static boolean[][] visited;
	static int count = 0;
	static int count2 = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pic = new char[n][n];
		visited = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				pic[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					count += 1;
					dfs(i, j);
				}
			}
		}
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					count2 += 1;
					dfs2(i, j);
				}
			}
		}
		
		
		System.out.println(count + " " + count2);
		
		

	}
	
	private static void dfs(int i, int j) {
		for (int[] d : direction) {
			int newI = i + d[0];
			int newJ = j + d[1];
			if (!isValid(newI, newJ) || visited[newI][newJ]) continue;
			if (pic[newI][newJ] == pic[i][j]) {
				visited[newI][newJ] = true;
				dfs(newI, newJ);
			}
		}		
	}
		
	private static void dfs2(int i, int j) {
		for (int[] d : direction) {
			int newI = i + d[0];
			int newJ = j + d[1];
			if (!isValid(newI, newJ) || visited[newI][newJ]) continue;
			if (pic[newI][newJ] == pic[i][j] || 
					(pic[newI][newJ] == 'R' && pic[i][j] == 'G') ||
					(pic[newI][newJ] == 'G' && pic[i][j] == 'R')
					) {
				visited[newI][newJ] = true;
				dfs2(newI, newJ);
			}
		}		
	}
	
	
	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < n;
	}

}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n, m;
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int[][] map;
	static int[][] dp;

	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n][m];
		dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);			
		}
		
		dp[n-1][m-1] = 1;
		dfs(0, 0);
		
		
		System.out.println(dp[0][0]);
	}

	private static int dfs(int i, int j) {
		if (i == n-1 && j == m-1) return 1;
		if (dp[i][j] >= 0) return dp[i][j];
		
		int route = 0;
		for (int[] d : direction) {
			int newI = i + d[0];
			int newJ = j + d[1];
			if (!isValid(newI, newJ)) continue;
			if (map[i][j] > map[newI][newJ]) {
				route += dfs(newI, newJ);
			}
			
		}
		return dp[i][j] = route;
		
	}





	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}

}

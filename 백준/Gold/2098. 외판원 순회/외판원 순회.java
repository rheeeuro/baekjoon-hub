
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] arr;
	static int[][] dp;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dp = new int[n][1<<n];
		
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE>>2);
			
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
//				if (arr[i][j] != 0) {
//					dp[j][(1<<i) + (1<<j)] = arr[i][j];					
//				}
			}
		}
		
		System.out.println(dfs((1<<n)-1 , 0));
		
	}
	
	static int dfs(int flag, int cur) {
		
		flag -= 1 << cur;
		if (flag == 0) {
			return arr[0][cur] == 0 ? Integer.MAX_VALUE>>4 : arr[0][cur];
		}
		if (dp[cur][flag] != Integer.MAX_VALUE>>2) return dp[cur][flag];
		for (int i = 0; i < n; i++) {
			if (i == cur) continue;
			if (arr[i][cur] > 0 && (flag & (1 << i)) != 0) {
				dp[cur][flag] = Math.min(dp[cur][flag], arr[i][cur] + dfs(flag, i));
			}
		}
		return dp[cur][flag];
	}
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main  {
	static int n;
	static int[][] w;
	static int[] nums;
	static boolean[] visited;
	static int min;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		nums = new int[n];
		visited = new boolean[n];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		perm(0, 0);
		System.out.println(min);

	}


	private static void perm(int cnt, int flag) {
		if (cnt == n) {
			if (w[nums[n-1]][nums[0]] > 0) {
				int c = getCost();
				min = Math.min(min, c);				
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if ((flag & 1 << i) != 0) continue;
			if (cnt > 0 && w[nums[cnt-1]][i] == 0) continue;
			nums[cnt] = i;
			perm(cnt+1, flag | 1 << i);
		}
		
		
	}


	private static int getCost() {
		int cost = 0;
		for (int i = 0; i < n; i++) {
			cost += w[nums[i]][nums[(i+1)%n]];
		}
		return cost;
		
	}
	

}

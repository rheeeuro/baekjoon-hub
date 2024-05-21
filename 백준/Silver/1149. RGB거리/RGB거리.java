
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	
	static int[][] cost;
	static int[][] min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		cost = new int[n][3];
		min = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(str[0]);
			cost[i][1] = Integer.parseInt(str[1]);
			cost[i][2] = Integer.parseInt(str[2]);	
		}
		
		
		min[0][0] = cost[0][0];
		min[0][1] = cost[0][1];
		min[0][2] = cost[0][2];
		for (int i = 1; i < n; i++) {
			min[i][0] = Math.min(min[i-1][1], min[i-1][2]) + cost[i][0];
			min[i][1] = Math.min(min[i-1][2], min[i-1][0]) + cost[i][1];
			min[i][2] = Math.min(min[i-1][0], min[i-1][1]) + cost[i][2];
		}
	
		
		System.out.println(Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]));



	}
}



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int[][] arr;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int testcase = 0; testcase < t; testcase++) {
			n = Integer.parseInt(br.readLine());
			arr = new int [n+2][2];
			map = new int [n+2][n+2];
			for (int i = 0; i < n+2; i++) {
				String[] line = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(line[0]);
				arr[i][1] = Integer.parseInt(line[1]);
			}
			
			
			for (int i = 0; i < n+2; i++) {
				for (int j = 0; j < i; j++) {
					if (i == j) continue;
					int dist = Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]);
					dist = dist > 1000 ? Integer.MAX_VALUE >> 2 : dist;
					map[i][j] = dist;
					map[j][i] = dist;
				}
			}
			
			
			for (int k = 0; k < n+2; k++) {					// 경유지
				for (int i = 0; i < n+2; i++) {				// 출발지
					if (i == k) continue;					// 경유지가 출발지와 같은 경우, n^2만큼 비교가 된다.
					int d1 = Math.abs(arr[k][0] - arr[i][0]) + Math.abs(arr[k][1] - arr[i][1]);
					for (int j = 0; j < n+2; j++) {	// 도착지
					// 출발지와 도착지가 같은 경우, 도작지와 경유지가 같은 경우		n^3만큼 비교가 된다.
						int d2 = Math.abs(arr[k][0] - arr[j][0]) + Math.abs(arr[k][1] - arr[j][1]);
						if (i == j || k == j) continue;
						if (map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = map[i][k] + map[k][j];
						}
					}
				}
			}

			
			System.out.println(map[0][n+1] == Integer.MAX_VALUE >> 2 ? "sad" : "happy");
		}
		
		
		
		
	}
	
}

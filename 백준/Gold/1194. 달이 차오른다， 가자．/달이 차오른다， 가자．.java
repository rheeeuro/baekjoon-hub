

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int n, m;
	static char[][] arr;
	static boolean[][][] visited;
	static List<Character> keys = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
	static List<Character> doors = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');
	static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		arr = new char[n][m];
		visited = new boolean[n][m][64];
		Queue<int[]> q = new LinkedList<>();
		int[] start = null;
		
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = line.charAt(j);
				if (arr[i][j] == '0') {
					start = new int[] {i, j};
				}
			}
		}
		
		visited[start[0]][start[1]][0] = true;
		q.offer(new int[] {start[0], start[1], 0, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			for (int[] d : direction) {
				int newI = cur[0] + d[0];
				int newJ = cur[1] + d[1];
				int flag = cur[2];
				
				if (!isValid(newI, newJ)) continue;
				
				if (doors.contains(arr[newI][newJ]) && (flag & 1 << doors.indexOf(arr[newI][newJ])) == 0) {
					continue;
				}
				if (keys.contains(arr[newI][newJ])) {
					flag |= 1 << keys.indexOf(arr[newI][newJ]);
				}
				
				if (!visited[newI][newJ][flag]) {
					visited[newI][newJ][flag] = true;
					q.offer(new int[] {newI, newJ, flag, cur[3]+1});
					if (arr[newI][newJ] == '1') {
						System.out.println(cur[3]+1);
						System.exit(0);	
					}
				}
			}
		}
		System.out.println(-1);
		
	}
	
	public static boolean isValid(int i, int j) {
		return 0 <= i && i < n && 0 <= j && j < m && arr[i][j] != '#';
	}
}

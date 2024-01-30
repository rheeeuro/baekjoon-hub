
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	
	static int n;
	static int[][] cost;
	static boolean[][] checked;
	static int[][] dist;
	static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static class Node implements Comparable<Node> {
		int i, j, w;
		public Node(int i, int j, int w) {
			this.i = i;
			this.j = j;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = -1;
		int testcase = 1;
		while(n != 0) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			dist = new int[n][n];
			cost = new int[n][n];
			checked = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					cost[i][j] = Integer.parseInt(line[j]);
				}
			}

			
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.add(new Node(0, 0, cost[0][0]));
			checked = new boolean[n][n];
			dist[0][0] = cost[0][0];
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				
				if(checked[cur.i][cur.j]) {
					continue;
				}
				checked[cur.i][cur.j] = true;
				
				for(int[] d : direction) {
					int newI = cur.i + d[0];
					int newJ = cur.j + d[1];
					
					if (newI >= n || newJ >= n || newI < 0 || newJ < 0) continue;
					if(dist[newI][newJ] > dist[cur.i][cur.j] + cost[newI][newJ]) {
						dist[newI][newJ] = dist[cur.i][cur.j] + cost[newI][newJ];
						q.add(new Node(newI, newJ, dist[newI][newJ]));
					}
				}
			}
			System.out.println("Problem " + testcase++ + ": " + dist[n-1][n-1]);
		}
		
		
		
		
	}
	
}

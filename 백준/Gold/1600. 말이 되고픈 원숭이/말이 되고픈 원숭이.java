


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main  {

	static int k, w, h;
	static boolean[][][] map;
	static int[][] minK;
	static int[][] direction = new int[][] {
		{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	static int[][] kDirection = new int[][] {
		{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
		{2, -1}, {2, 1}, {1, -2}, {1, 2},
	};

	static class Node {
		int i, j;
		int k;
		int count;
		public Node(int i, int j, int k, int count) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
			this.count = count;
		}
		@Override
		public String toString() {
			return "Node [i=" + i + ", j=" + j + ", k=" + k + ", count=" + count + "]";
		}
		

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		String[] wh = br.readLine().split(" ");
		w = Integer.parseInt(wh[0]);
		h = Integer.parseInt(wh[1]);
		map = new boolean[h][w][k+1];

		for (int i = 0; i < h; i++) {
			String line = br.readLine();
			for (int j = 0; j < w; j++) {
				if (line.charAt(2 * j) =='1') {
					for (int j2 = 0; j2 < k+1; j2++) {
						map[i][j][j2] = true;
					}
				}
			}
		}
		

		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(0, 0, 0, 0));

		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Node curNode = q.poll();

			if (curNode.i == h-1 && curNode.j == w-1) {
				min = curNode.count;
				break;
			}

			for (int[] d : direction) {
				int newI = curNode.i + d[0];
				int newJ = curNode.j + d[1];
				if (!isValid(newI, newJ)) continue;
				if (map[newI][newJ][curNode.k] == true) continue;

				q.offer(new Node(newI, newJ, curNode.k, curNode.count + 1));
				map[newI][newJ][curNode.k] = true;
			}
			
			if (curNode.k < k) {
				for (int[] kd : kDirection) {
					int newI = curNode.i + kd[0];
					int newJ = curNode.j + kd[1];
					if (!isValid(newI, newJ)) continue;
					if (map[newI][newJ][curNode.k+1] == true) continue;

					q.offer(new Node(newI, newJ, curNode.k + 1, curNode.count + 1));
					map[newI][newJ][curNode.k + 1] = true;
				}
			}
			
		}
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < h && j < w;
	}
}

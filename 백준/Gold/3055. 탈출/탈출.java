
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int r;
	static int c;
	static char[][] map;
	static boolean[][] visited;
	static int[][] count;
	static Node start;
	static int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	
	
	static class Node {
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		map = new char[r][c];
		visited = new boolean[r][c];
		
		LinkedList<Node> queue = new LinkedList<>();	
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == '*') {
					queue.addFirst(new Node(i, j, -1));
				} else if (map[i][j] == 'S') {
					queue.offer(new Node(i, j, 0));
					map[i][j] = '.';
				}
			}
		}
		
		boolean find = false;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			if (cur.count >= 0) {
				// 고슴도치
	
				for (int[] d : direction) {
					int newI = cur.x + d[0];
					int newJ = cur.y + d[1];
					if (!isValid(newI, newJ)) continue;
					if (map[newI][newJ] == 'D' && !visited[newI][newJ]) {
						System.out.println(cur.count + 1);
						find = true;
						System.exit(0);
					}
					if (map[newI][newJ] == '.' && !visited[newI][newJ]) {
						visited[newI][newJ] = true;
						queue.offer(new Node(newI, newJ, cur.count + 1));
					}
				}
			} else  {
				// 물
				for (int[] d : direction) {
					int newI = cur.x + d[0];
					int newJ = cur.y + d[1];
					
					if (!isValid(newI, newJ)) continue;
					if (map[newI][newJ] == '.') {
						queue.offer(new Node(newI, newJ, -1));
						map[newI][newJ] = '*';
					}
				}
			}
			
		}
		
		if (!find) {
			System.out.println("KAKTUS");
		}

	}

	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < r && j < c;
	}
	
	
	
}

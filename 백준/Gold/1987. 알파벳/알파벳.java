import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main  {
	static int r, c;
	static char[][] map;
	static int max;
	static int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");

		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);

		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		dfs(0, 0, 1 << (map[0][0] - 'A'), 1);

		System.out.println(max);
	}

	private static void dfs(int i, int j, int flag, int count) {
		for (int[] d : direction) {
			int newI = i + d[0];
			int newJ = j + d[1];
			if (!isValid(newI, newJ) || (flag & 1 << (map[newI][newJ] - 'A')) != 0) continue;
			dfs(newI, newJ, flag | 1 << (map[newI][newJ] - 'A'), count+1);
		}
		max = Math.max(max, count);
	}

	private static boolean isValid(int i, int j) {
		return i>=0 && j>= 0 && i<r && j<c;
	}
}


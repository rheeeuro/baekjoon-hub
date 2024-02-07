import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n, m, d;
	static int[] numbers;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		d = Integer.parseInt(str[2]);

		numbers = new int[3];
		map = new int[n][m];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		comb(0, 0);
		
		System.out.println(max);
	}

	private static void comb(int cnt, int start) {
		if(cnt == 3) {
			int result = run();
			if (result > max) {
				max = result;
			}
			return;
		}

		for (int i = start; i < m; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i+1);
		}
	}

	private static int run() {
		int count = 0;
		int[][] delete;
		int[] min;
		int[][] mapCopy = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			mapCopy[i] = map[i].clone();
		}

		for (int t = 0; t < n; t++) {
			min = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
			delete = new int[][] {{-1, -1}, {-1, -1}, {-1, -1}};
			
			for (int a = 0; a < 3; a++) {
				for (int j = 0; j < m; j++) {
					for (int i = 0 ; i < n-t ; i++) {
						
						if (mapCopy[i][j] != 1) continue;
						int dist = Math.abs(numbers[a]-j) + Math.abs(n-t-i);
						if (dist <= d && dist < min[a]) {
							delete[a][0] = i;
							delete[a][1] = j;
							min[a] = dist;
						}
					}
				}
			}
			
			for (int[] d : delete) {
				if (d[0] == -1 || d[1] == -1) continue;
				if (mapCopy[d[0]][d[1]] == 1) {
					count += 1;
					mapCopy[d[0]][d[1]] = 0;
				}
				
			}
		}
		return count;
	}
}

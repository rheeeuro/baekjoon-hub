
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main  {

	static int[][][][] cctvDir = new int[][][][] {
		{
			{{0, 1}},
			{{1, 0}},
			{{0, -1}},
			{{-1, 0}},
		},
		{
			{{0, -1}, {0, 1}},
			{{-1, 0}, {1, 0}},
		},
		{
			{{-1, 0}, {0, 1}},
			{{0, 1}, {1, 0}},
			{{1, 0}, {0, -1}},
			{{0, -1}, {-1, 0}},
		},
		{
			{{0, -1}, {-1, 0}, {0, 1}},	
			{{-1, 0}, {0, 1}, {1, 0}},	
			{{0, 1}, {1, 0}, {0, -1}},	
			{{1, 0}, {0, -1}, {-1, 0}},	
		},
		{
			{{-1, 0}, {1, 0}, {0, -1}, {0, 1}},					
		}

	};
	static int n, m;
	static int[][] map;
	static List<Cctv> cctvs;
	static int min = Integer.MAX_VALUE;
	
	static class Cctv {
		public int i;
		public int j;
		public int type;
		public Cctv(int i, int j, int type) {
			super();
			this.i = i;
			this.j = j;
			this.type = type;
		}		
	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		cctvs = new ArrayList<Cctv>();

		map = new int[n][m];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctvs.add(new Cctv(i, j, map[i][j]));
				}
				if (map[i][j] == 0) {
					count += 1;
				}
			}
		}
		
		if (cctvs.size() > 0) {
			watch(0, map);			
		} else {
			min = count;
		}
		System.out.println(min);

	}


	private static void watch(int idx, int[][] original) {
		int[][] mapCopy = new int[n][m];
		
		int dirIdx = cctvs.get(idx).type - 1;
		for (int i = 0; i < cctvDir[dirIdx].length; i++) {
			
			for (int row = 0; row < n; row++) {
				mapCopy[row] = original[row].clone();
			}
		
			for (int j = 0; j < cctvDir[dirIdx][i].length; j++) {
				int[] d = cctvDir[dirIdx][i][j];
				int curI = cctvs.get(idx).i + d[0];
				int curJ = cctvs.get(idx).j + d[1];
				while(isValid(curI, curJ) && map[curI][curJ] != 6) {
					if (mapCopy[curI][curJ] == 0) {
						mapCopy[curI][curJ] = 7;
					}
					curI += d[0];
					curJ += d[1];
				}
			}
			
			
			if (idx == cctvs.size() - 1) {
				int count = 0;
				for (int a = 0; a < n; a++) {
					for (int b = 0; b < m; b++) {
						if (mapCopy[a][b] == 0) {
							count += 1;
						}
					}
				}
				if (count < min) {
					min = count;
				}
			} else {
				watch(idx+1, mapCopy);
			}
		}
		
	}
	
	private static boolean isValid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}


}

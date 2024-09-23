
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n;
	static int[][] result;
	static int[] order;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = new int[n][9];
		order = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(line[j]);
			}
		}
		do {
			max = Math.max(max, getScore());
		} while(np());
		
		System.out.println(max);
	}
	
	private static int getScore() {
		int[] playerIdx = new int[9];
		boolean[] map = new boolean[3];
		
		for (int i = 0; i < 9; i++) {
			if (i < 3) playerIdx[i] = order[i];
			else if (i == 3) playerIdx[i] = 0;
			else playerIdx[i] = order[i-1];
		}
		
		int count = 0;
		int score = 0;
		int outCount;
		
		for (int i = 0; i < n; i++) {
			outCount = 0;
			map = new boolean[3];
			
			while (outCount < 3) {
				int idx = playerIdx[count % 9];
				
				int action = result[i][idx];
				if (action == 0) outCount += 1;
				for (int a = 0; a < action; a++) {
					if (map[2]) score += 1;
					map[2] = map[1];
					map[1] = map[0];
					map[0] = a == 0;
				}
				
				count += 1;
			}
		}
		return score;
	}

	static boolean np() {
		int n = order.length;
		
		int i = n-1;
		while(i > 0 && order[i-1] >= order[i]) i--;
		if (i == 0) return false;
		
		int j = n-1;
		while(order[i-1] >= order[j]) j--;
		swap(i-1, j);
		
		int k = n-1;
		while(i < k) swap(i++, k--);
		return true;
		
	}
	
	static void swap(int a, int b) {
		int temp = order[a];
		order[a] = order[b];
		order[b] = temp;
	}

}

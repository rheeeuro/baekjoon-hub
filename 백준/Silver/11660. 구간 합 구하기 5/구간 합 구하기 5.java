import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		int[][] arr = new int[N+1][N+1];
		int[][] sums = new int[N+1][N+1];
		

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			String[] line = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(line[j-1]);
				sum += num;
				
				sums[i][j] = sums[i-1][j] + sum;
				
			}
		}

		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(" ");
			int x1 = Integer.parseInt(line[0]);
			int y1 = Integer.parseInt(line[1]);
			int x2 = Integer.parseInt(line[2]);
			int y2 = Integer.parseInt(line[3]);
			
		
			System.out.println(sums[x2][y2] - sums[x1-1][y2] - sums[x2][y1-1] + sums[x1-1][y1-1]);

		}

	}
}

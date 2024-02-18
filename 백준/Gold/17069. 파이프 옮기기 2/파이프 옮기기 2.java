
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int N;
	static int[][] direction = {{1, 0}, {1, 1}, {0, 1}};
	static boolean[][] arr;
	static long[][][] min; // 가로, 세로, 대각선
	static int count = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		min = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (str[j].charAt(0) == '1') {
					arr[i][j] = true;					
				}
			}
		}


		min[0][1][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (arr[i][j]) continue;
				
				min[i][j][0] = min[i][j-1][0] + min[i][j-1][2];	
				if (i > 0) {
					min[i][j][1] = min[i-1][j][1] + min[i-1][j][2];								
				}
				if ((i>0 && j>0) && !arr[i-1][j] && !arr[i][j-1]) {
					min[i][j][2] = min[i-1][j-1][0] + min[i-1][j-1][1] + min[i-1][j-1][2];					
				}
			}
		}


		System.out.println(min[N-1][N-1][0]+min[N-1][N-1][1]+min[N-1][N-1][2]);
	}

}

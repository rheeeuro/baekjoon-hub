
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static int[][] direction = {{1, 0}, {1, 1}, {0, 1}};
	static boolean[][] arr;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (str[j].charAt(0) == '1') {
					arr[i][j] = true;					
				}
			}
		}
		
		run(0, 1, 0);
		
		System.out.println(count);
	}
	
	private static void run(int i, int j, int status) {
		if (i < 0 || j < 0 || i >= N || j >= N) return;
		
		if (arr[i][j]) return;
		if (status == 1 && (arr[i][j] || arr[i-1][j] || arr[i][j-1])) return;
		
		if (i == N-1 && j == N-1) {
			count += 1;
			return;
		}
		
		if (status == 0) {
			run(i, j+1, 0);
			run(i+1, j+1, 1);
		} else if (status == 1) {
			run(i, j+1, 0);
			run(i+1, j+1, 1);
			run(i+1, j, 2);
		} else if (status == 2) {
			run(i+1, j+1, 1);
			run(i+1, j, 2);
		}
	}
}

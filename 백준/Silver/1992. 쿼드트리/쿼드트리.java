
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static int N;
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		System.out.println(zip(0, N, 0, N, N));
	}
	
	static String zip(int startX, int endX, int startY, int endY, int size) {
		int zeroCount = 0;
		int oneCount = 0;
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if (arr[i][j] == '0') {
					zeroCount++;
				} 
				if (arr[i][j] == '1') {
					oneCount++;					
				} 
			}
		}
		if (zeroCount == size*size) {
			return "0";
		} else if (oneCount == size*size) {
			return "1";
		} else {
			return "("
					+ zip(startX, endX - size/2, startY, endY-size/2, size/2)
					+ zip(startX, endX - size/2, startY + size/2, endY, size/2)
					+ zip(startX + size/2, endX, startY, endY-size/2, size/2)
					+ zip(startX + size/2, endX, startY + size/2, endY, size/2)
					+ ")";
		}
	}
}

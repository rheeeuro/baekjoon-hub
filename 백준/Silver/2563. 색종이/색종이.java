
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean colored[][] = new boolean[100][100];
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int X = Integer.parseInt(str[0]);
			int Y = Integer.parseInt(str[1]);
			
			for (int x = X; x < X+10; x++) {
				for (int y = Y; y < Y+10; y++) {
					colored[x][y] = true;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (colored[i][j]) count += 1;
			}
		}
		
		System.out.println(count);



	}
}

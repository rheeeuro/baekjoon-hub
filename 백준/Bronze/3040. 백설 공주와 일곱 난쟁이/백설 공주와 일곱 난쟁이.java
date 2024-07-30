
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N = 9;
	static int M = 7;
	static int[] all;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		all = new int[N];
		numbers = new int[M];
		
		for (int i = 0; i < N; i++) {
			all[i] = Integer.parseInt(br.readLine());
		}
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			int total = 0;
			for (int i = 0; i < M; i++) {
				total += numbers[i];
			}
			if (total == 100) {
				for (int number : numbers) {
					System.out.println(number);
				}
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = all[i];
			combination(cnt+1, i+1);
		}
		
	}

}

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static int N, M;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		numbers = new int[M];
		
		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			for (int n : numbers) {
				System.out.print(n + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			numbers[cnt] = i+1;
			combination(cnt+1, i+1);
		}
		
	}
}

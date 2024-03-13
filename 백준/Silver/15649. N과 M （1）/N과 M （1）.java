
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int M;
	static int[] num;
	static int count;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		num = new int[M];
		
		permutation(0, 0);
	}
	
	public static void permutation(int cnt, int flag) {
		if (cnt == M) {
			for (int n : num) {
				System.out.print(n + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < N; i++) {
				if ((flag & 1<<i) != 0) continue;
				num[cnt] = i+1;
				permutation(cnt+1, flag|1<<i);
			}
			
			
		}
	}
}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		int[] numbers = new int[N+1];
		int[] sums = new int[N+1];
		int sum = 0;
		
		for (int i = 1; i <= N; i++) {
			int num = scan.nextInt();
			sum += num;
			numbers[i] = num;
			sums[i] = sum;
		}
		
		for (int i = 0; i < M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			System.out.println(sums[to] - sums[from-1]);
		}
		
		
	}
}

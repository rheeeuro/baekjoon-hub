
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main  {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n+2];
		
		arr[1] = 0;
		arr[2] = 1;
		for (int i = 3; i <= n; i++) {
			int a = i % 2 == 0 ? arr[i/2]: Integer.MAX_VALUE;
			int b = i % 3 == 0 ? arr[i/3]: Integer.MAX_VALUE;
			int c = arr[i-1];
			arr[i] = Math.min(a,  c);
			arr[i] = Math.min(arr[i],  b);
			arr[i] += 1;
		}
		
		System.out.println(arr[n]);

	}
}

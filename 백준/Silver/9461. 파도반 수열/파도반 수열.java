import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static long[] arr;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for (int testcase = 0; testcase < t; testcase++) {
			n = Integer.parseInt(br.readLine());
			System.out.println(padoban(n));
		}
		
	}
	
	static long padoban(int i) {
		if (arr[i] != 0) return arr[i];
		else return arr[i] = padoban(i-1) + padoban(i-5);
	}
	
}

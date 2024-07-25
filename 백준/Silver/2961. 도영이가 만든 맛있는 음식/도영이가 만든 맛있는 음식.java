
import java.util.Scanner;
/**
 * 
 * @author 
 * 시간 복잡도 2^n
 *
 */
public class Main {
	static int N;
	static int[][] input;
	static boolean[] isSelected;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		input = new int[N][2];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}
		
		generateSubset(0);
		System.out.println(min);
	}
	
	private static void generateSubset(int cnt) {
		if(cnt == N) {
			int taste = getTaste();
			if (taste < min) {
				min = taste;
			}
			return ;
		}
		
		// 부분집합에 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		// 부분집합에 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
	}
	
	private static int getTaste() {
		int sour = 1;
		int bitter = 0;
		boolean empty = true;
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) {
				empty = false;
				sour *= input[i][0];
				bitter += input[i][1];
			}
		}
		
		if (empty) {
			return Integer.MAX_VALUE;
		} else {
			return Math.abs(sour - bitter);			
		}
	}
}


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[] directionY = {-1, 0, 1};
	static char[][] arr;
	static int r, c;
	static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		
		arr = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		for (int i = 0; i < r; i++) {
			run(i, 0, new int[c]);
//			if (isOver()) break;
		}
		
		System.out.println(count);
	}
	
	private static boolean run(int i, int j, int[] nums) {
		if (j == c-1) {
			count += 1;
			return true;
		}
		for (int d : directionY) {
			int newI = i+d;
			int newJ = j+1;
			if (isValid(newI, newJ) && arr[newI][newJ] == '.') {
				int[] newNums = new int[c];
				newNums = nums.clone();
				newNums[newJ] = newI;
				arr[newI][newJ] = 'x';
				if (run(newI, newJ, newNums)) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	private static boolean isValid(int i, int j) {
		return i>=0 && j>=0 && i<r && j<c;
	}
//	
//	private static boolean isOver() {
//		boolean flag = true;
//		for (int i = 0; i < c; i++) {
//			flag = true;
//			for (int j = 0; j < r; j++) {
//				if (arr[j][i] == '.') flag = false;
//			}
//		}
//		return flag;
//	}
}

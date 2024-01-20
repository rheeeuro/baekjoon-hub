
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	
	static int N, r, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		r = Integer.parseInt(str[1]);
		c = Integer.parseInt(str[2]);
		

//		System.out.println(getZ(N)[r][c]);
		System.out.println(getValue(r, c, (int) Math.pow(2, N)));
	}
	
	public static int getValue(int r, int c, int size) {
		int[][] arr = new int[][] {{0, 1}, {2, 3}};
		if (size == 2) {
			return arr[r][c];
		} else {
			int half = (int) size / 2;
			int[] add = new int[] {0, 0};
			if (half <= r) {
				add[0] += 1;
			}
			if (half <= c) {
				add[1] += 1;
			}
			
			
			return getValue(r - add[0]*half, c - add[1]*half, size/2) + arr[add[0]][add[1]] * half*half;
		}
	}
	
//	public static int[][] getZ(int n) {
//		int[][] newArr;
//		if (n == 1) {
//			newArr = new int[][] {{0, 1}, {2, 3}};
//		} else {
//			int size = (int) Math.pow(2, n);
//			newArr = new int[size][size];
//			for (int i = 0; i < size; i++) {
//				for (int j = 0; j < size; j++) {
//					if (i > r || j > c) break;
//					int[][] previous = getZ(n-1);
//					int half = (int) size/2;
//					int add = half * half;
//					if (i < half && j < half) {
//						newArr[i][j] = previous[i][j];
//					} else if (i >= half && j < half) {
//						newArr[i][j] = previous[i-half][j] + add*2;
//					} else if (j >= half && i < half) {
//						newArr[i][j] = previous[i][j-half] + add;
//					} else if(i >= half && j >= half) {
//						newArr[i][j] = previous[i-half][j-half] + add*3;
//					}
//				}
//			}
//		}
//		return newArr;
//	}
	
	
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main  {
	static int n, m, k;
	static int[][] arr;
	static int[][] exps;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);
		
		arr = new int[n][m];
		exps = new int[k][3];
		numbers = new int[k];
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			} 
		}
		
	
		for (int i = 0; i < k; i++) {
			String[] line = br.readLine().split(" ");
			exps[i][0] = Integer.parseInt(line[0]);
			exps[i][1] = Integer.parseInt(line[1]);	
			exps[i][2] = Integer.parseInt(line[2]);	
		}
		
		permutation(0, 0);
		
		System.out.println(min);
	}
	
	private static void permutation(int cnt , int flag) {
		if (cnt == k) {
			int[][] newArr = arr;
			for (int i = 0; i < k; i++) {
				int[] exp = exps[numbers[i]];
				newArr = turn(newArr, exp[0]-exp[2]-1, exp[0]+exp[2]-1, exp[1]-exp[2]-1, exp[1]+exp[2]-1);
			}
			int newMin = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++) {
					sum += newArr[i][j];			
				}
				if (sum < newMin) newMin = sum;
			}
			if (newMin < min) min = newMin;
			return;
		}
		for (int i = 0; i < k; i++) {
			if ((flag & 1 << i) != 0) continue;
			numbers[cnt] = i;
			permutation(cnt+1, flag | 1 << i);
		}
	}
	
	private static int[][] turn(int[][] arr, int startX, int endX, int startY, int endY) {
		if (endX - startX < 1 || endY - startY < 1) {
			return arr;
		}

		
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> updateQueue = new LinkedList<int[]>();
		int[][] updatedArr = new int[n][m];
		for (int i = 0; i < n; i++) {
			updatedArr[i] = arr[i].clone();
		}
		
		
		for (int i = startY; i <= endY; i++) {
			int[] idx = {startX, i};
			queue.add(idx);
			updateQueue.add(idx);
		}
		for (int i = startX + 1; i <= endX; i++) {
			int[] idx = {i, endY};
			queue.add(idx);
			updateQueue.add(idx);
		}
		for (int i = endY-1; i >= startY; i--) {
			int[] idx = {endX, i};
			queue.add(idx);
			updateQueue.add(idx);
		}
		for (int i = endX-1; i >= startX+1; i--) {
			int[] idx = {i, startY};
			queue.add(idx);
			updateQueue.add(idx);
		}
		
		queue.add(queue.poll());

		while(queue.size() > 0) {
			int[] originalIdx = queue.poll();
			int[] updateIdx = updateQueue.poll();
			updatedArr[originalIdx[0]][originalIdx[1]] = arr[updateIdx[0]][updateIdx[1]];
		}
		
		
		return turn(updatedArr, startX+1, endX-1, startY+1, endY-1);
	}
}

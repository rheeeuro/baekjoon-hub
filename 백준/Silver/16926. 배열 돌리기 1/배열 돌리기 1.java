
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static int M;
	static int R;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);
		
		int[][] arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		
		int[][] newArr = turn(arr, 0, N-1, 0, M-1);

		 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(newArr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] turn(int[][] arr, int startX, int endX, int startY, int endY) {
		if (endX - startX < 1 || endY - startY < 1) {
			return arr;
		}

		
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> updateQueue = new LinkedList<int[]>();
		int[][] updatedArr = new int[N][M];
		for (int i = 0; i < N; i++) {
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
		
		for (int i = 0; i < R; i++) {
			updateQueue.add(updateQueue.poll());
		}
		
		while(queue.size() > 0) {
			int[] originalIdx = queue.poll();
			int[] updateIdx = updateQueue.poll();
			updatedArr[originalIdx[0]][originalIdx[1]] = arr[updateIdx[0]][updateIdx[1]];
		}
		
		
		return turn(updatedArr, startX+1, endX-1, startY+1, endY-1);
	}
	
	
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int n;
	static int m;
	static int[][] arr;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;
	static List<int[]> chickenHousePosition;
	static int[][] selectedChickenHousePosition;
	static List<int[]> housePosition;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int[n][n];
		chickenHousePosition = new ArrayList<>();
		selectedChickenHousePosition = new int[m][2];
		housePosition = new ArrayList<>(13);
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				if (arr[i][j] == 2) {
					int[] idx = {i, j};
					chickenHousePosition.add(idx);
				} else if (arr[i][j] == 1) {
					int[] idx = {i, j};
					housePosition.add(idx);
				}
			}
		}
		
		combination(0, 0);
		System.out.println(min);
	}

	private static void combination(int cnt, int start) {
		if (cnt == m) {
			int chickenRoad = getChickenRoad();
			if (min > chickenRoad) {
				min = chickenRoad;
			}
			return;
		}
		
		for (int i = start; i < chickenHousePosition.size(); i++) {
			selectedChickenHousePosition[cnt] = chickenHousePosition.get(i);
			combination(cnt+1, i+1);
		}
		
	}
	
	private static int getChickenRoad() {
		int sum = 0;
		for (int[] pos : housePosition) {
			int minRoad = Integer.MAX_VALUE;
			for (int[] chickenPos : selectedChickenHousePosition) {
				int road = (Math.abs(pos[0]-chickenPos[0]) + Math.abs(pos[1]-chickenPos[1]));
				if (minRoad > road) {
					minRoad = road;
				}
			}
			sum += minRoad;
		}
		return sum;
	}

}

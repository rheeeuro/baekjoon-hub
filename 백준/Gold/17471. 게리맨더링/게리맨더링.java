
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main  {
	static int n;
	static int[] population;
	static int totalPopulation;
	private static ArrayList<Integer>[] list;
	private static boolean[] selected;
	private static List<Integer> firstTemp;
	private static List<Integer> secondTemp;
	private static int min = -1;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		selected = new boolean[n];
		population = new int[n];
		
		String[] populations = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			population[i] = Integer.parseInt(populations[i]);
			totalPopulation += population[i];
		}
		
		int node, ad;
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			int size = Integer.parseInt(line[0]);
			list[i] = new ArrayList<>(size);
			for (int j = 0; j < size; j++) {
				list[i].add(Integer.parseInt(line[j+1])-1);
			}
		}
		
		subset(0);
		
		System.out.println(min);

	}
	
	private static void subset(int cnt) {
		if(cnt == n) {
			List<Integer> selectedIdx = new ArrayList<>();
			List<Integer> unSelectedIdx = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				if (selected[i]) {
					selectedIdx.add(i);
				} else {
					unSelectedIdx.add(i);
				}
			}
			if (selectedIdx.size() == 0 || unSelectedIdx.size() == 0) return;
			
			
			int selectedSum = getSum(selectedIdx);
			int unSelectedSum = getSum(unSelectedIdx);
			
			if (selectedSum + unSelectedSum == totalPopulation) {
				int diff = Math.abs(selectedSum - unSelectedSum);
				if (diff < min || min == -1) {
					min = diff;
				}
			}
			
			return;
		}
		
		selected[cnt] = true;
		subset(cnt+1);
		
		selected[cnt] = false;
		subset(cnt+1);
	}
	
	private static int getSum(List<Integer> selectedIdx) {
		int sum = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n];
		int cur = selectedIdx.get(0);
		q.offer(cur);
		visited[cur] = true;
		
		while (!q.isEmpty()) {
			cur = q.poll();
			sum += population[cur];
			for (int i = 0; i < list[cur].size(); i++) {
				int ad = list[cur].get(i);
				if (!visited[ad] && selectedIdx.contains(ad)) {
					visited[ad] = true;
					q.offer(ad);
				}
			}			
		}
		return sum;
		
	}
}

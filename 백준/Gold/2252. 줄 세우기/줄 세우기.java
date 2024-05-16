
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main  {
	static int n, m;
	static int[][] map;
	static int[] degrees;
	static Node[] adjList;

	static class Node {
		int vertex;
		Node next;

		public Node(int vertext, Node next) {
			super();
			this.vertex = vertext;
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [vertext=" + vertex + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		adjList = new Node[n+1];
		degrees = new int[n+1];

		for (int i = 0; i < m; i++) {
			String [] line = br.readLine().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);
			adjList[from] = new Node(to, adjList[from]);
			degrees[to] += 1;
		}
		ArrayList<Integer> orderList = topologySort();
		
		if(orderList.size() == n) {
			StringBuilder sb = new StringBuilder();
			for (int o : orderList) {
				sb.append(o).append(" ");
			}
			System.out.println(sb);
		}else {
			System.out.println("cycle");
		}

	}
	
	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			if(degrees[i] == 0) queue.offer(i);
		}
		 
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			orderList.add(cur);
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(--degrees[temp.vertex] == 0) queue.offer(temp.vertex);
			}
		}
		return orderList;
	}
}

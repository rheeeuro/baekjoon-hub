
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		
		int count = 0;
		while(queue.size() > 0) {
			count += 1;
			if (count == k) {
				result.add(queue.poll());
				count = 0;
			} else {
				queue.add(queue.poll());				
			}
		}
		
		
		System.out.println(result.toString().replace("[", "<").replace("]", ">"));
		 


	}

}

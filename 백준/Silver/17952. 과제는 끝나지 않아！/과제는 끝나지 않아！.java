import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int n;
	static int score;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			
			// 일이 주어진 경우 스택에 [A, T]의 형식으로 추가한다.
			if (input.startsWith("1"))  {
				String[] inputs = input.split(" ");
				stack.add(new int[] {Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2])});
			}
			if (stack.size() == 0) continue;
			// 스택에서 마지막에 주어진 일을 꺼내 일을 한다.
			int[] cur = stack.pop();
			cur[1] -= 1;
			
			// 일을 끝마친 경우 score에 A를 더해주고, 마치지 못한 경우 스택에 다시 넣어준다.
			if (cur[1] == 0) {
				score += cur[0];
			} else {
				stack.add(cur);
			}
		}
		
		System.out.println(score);
	}
}

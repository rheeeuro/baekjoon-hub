
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class Tower {
	
	public Tower(int height, int index) {
		super();
		this.height = height;
		this.index = index;
	}
	int height;
	int index;
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		Stack<Tower> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(arr[i]);
			while(stack.size() != 0 && stack.peek().getHeight() < height) {
				stack.pop();
			}

			int receiveIndex = stack.size() == 0 ? 0 : stack.peek().getIndex();
			System.out.print(receiveIndex + " ");
			stack.add(new Tower(height, i+1));
		}
		
		
	}
}

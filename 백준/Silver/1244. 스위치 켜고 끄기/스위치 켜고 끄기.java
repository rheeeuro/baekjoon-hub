
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(br.readLine()); 
		int[] switches = new int[switchNum + 1];
		
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < switchNum; i++) {
			switches[i + 1] = Integer.parseInt(str[i]);
		}
		
		int sutdentNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < sutdentNum; i++) {
			String[] studentStr = br.readLine().split(" ");
			int gender = Integer.parseInt(studentStr[0]);
			int index = Integer.parseInt(studentStr[1]);
			
			if (gender == 1) {
				for (int j = 1; j <= switchNum; j++) {
					if (j % index == 0) {
						switches[j] = toggle(switches[j]);
					}
				}
			} else if (gender == 2) {
				boolean flag = true;
				int count = 0;
				while(flag) {
					if (count == 0) {
						switches[index] = toggle(switches[index]);
					} else {
						if (isValid(index + count, switchNum) 
								&& isValid(index - count, switchNum) 
								&& (switches[index + count] == switches[index - count])) {
							switches[index + count] = toggle(switches[index + count]);
							switches[index - count] = toggle(switches[index - count]);							
						} else {
							flag = false;
						}
					}
					count += 1;
				}
			}
		}
		for (int i = 1; i <= switchNum; i++) {
			if (i % 20 == 0) {
				System.out.println(switches[i]);								
			} else {
				System.out.print(switches[i] + " ");				
			}
		}
	}
	
	public static int toggle(int n) {
		if (n == 1) return 0;
		else return 1;
	}
	
	public static boolean isValid(int index, int switchNum) {
		return index >= 1 && index <= switchNum;
	}
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main  {
	static int l, c;
	static char[] inputs;
	static char[] chars;
	static List<Character> m = Arrays.asList(new Character[] {'a', 'e', 'i', 'o', 'u'});



	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");

		l = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		chars = new char[l];
		inputs = new char[c];
		
		String [] inputLine = br.readLine().split(" ");
		for (int i = 0; i < c; i++) {
			inputs[i] = inputLine[i].charAt(0);
		}
		Arrays.sort(inputs);
		comb(0, 0);

	}
	
	private static void comb(int cnt, int start) {
		if(cnt == l) {
			
			int mCount = 0;
			for (char c : chars) {
				if (m.contains(c)) mCount += 1;
			}
			if (mCount >= 1 && (l-mCount) >= 2) {
				for (char c : chars) {
					System.out.print(c);
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < c; i++) {
			chars[cnt] = inputs[i];
			comb(cnt+1, i+1);
		}
	}
}

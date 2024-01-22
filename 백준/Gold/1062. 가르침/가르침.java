
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int n;
	static int k;
	static Character[] selectedLetters;
	static List<Character> fundamental;
	static List<Character> letters;
	static String[] words;
	static int max = 0;
	static int count;
	

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);
		
		
		letters = new ArrayList<>();
		words = new String[n];
		
		fundamental = new ArrayList<>();
		fundamental.add('a');
		fundamental.add('n');
		fundamental.add('t');
		fundamental.add('i');
		fundamental.add('c');
		
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			for (char c : words[i].toCharArray()) {
				if (!letters.contains(c) && !fundamental.contains(c)) {
					letters.add(c);
				}
			}
		}
		
		if (k >= 5) {
			selectedLetters = new Character[k-5];
			if (k-5 > letters.size()) {
				max = words.length;
			} else {
				combination(0, 0);				
			}
		}
		
		System.out.println(max);

		
		
		
	}

	private static void combination(int cnt, int start) {
		if (cnt == k-5) {
			int count = countWords();
			if (max < count) {
				max = count;
			}
			return;
		}
		
		for (int i = start; i < letters.size(); i++) {
			selectedLetters[cnt] = letters.get(i);
			combination(cnt+1, i+1);
		}
		
	}

	private static int countWords() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean read = true;
			List<Character> selectedList = Arrays.asList(selectedLetters);
			for (char c : words[i].toCharArray()) {
				if (!(selectedList.contains(c) || fundamental.contains(c))) {
					read = false;
					break;
				}
			}
			if (read) {
				count += 1;
			}
		}
		return count;
	}
	

}

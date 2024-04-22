
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main  {

 	
	static class Shark {
		public int i;
		public int j;
		public int speed;
		public int dir;
		public int size;
		public int currentI;
		public int currentJ;
		
		public Shark() {}
		
		public Shark(int i, int j, int speed, int dir, int size) {
			super();
			this.i = i;
			this.j = j;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.currentI = i;
			this.currentJ = j;
		}
		
		public void getPosition(int t) {
			int curI = i;
			int curJ = j;
			
			if (dir == 1 && curI == 1) dir = 2;
			if (dir == 2 && curI == r) dir = 1;
			if (dir == 3 && curJ == c) dir = 4;
			if (dir == 4 && curJ == 1) dir = 3;
			
			if (t != 0) {
				int len = this.speed * t;
				if (dir == 4) {
					curJ -= (len % (2*c - 2));
					if (curJ < 1) {
						curJ = 2-curJ;
					}
				} else if (dir == 3) {
					curJ += (len % (2*c - 2));
					if (curJ > c) {
						curJ = c -(curJ-c);
					}
				} else if (dir == 1) {
					curI -= (len % (2*r - 2));
					if (curI < 1) {
						curI = 2-curI;
					}
				} else if (dir == 2) {
					curI += (len % (2*r - 2));
					if (curI > r) {
						curI = r -(curI-r);
					}
				}
				if (curJ < 1) {
					curJ = 2-curJ;
				}
				if (curJ > c) {
					curJ = c -(curJ-c);
				}
				if (curI < 1) {
					curI = 2-curI;
				}
				if (curI > r) {
					curI = r -(curI-r);
				}
			}
			
			currentI = curI;
			currentJ = curJ;
		}

		@Override
		public String toString() {
			return "Shark [i=" + i + ", j=" + j + ", speed=" + speed + ", dir=" + dir + ", size=" + size + ", currentI="
					+ currentI + ", currentJ=" + currentJ + "]";
		}

		
	}
	static int r, c, m;
	static List<Shark> sharks;
	static int sum;
	static Shark[][] exist;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String [] str = br.readLine().split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);
		m = Integer.parseInt(str[2]);
		
		sharks = new ArrayList<Shark>();
		
		for (int a = 0; a < m; a++) {
			String[] inputs = br.readLine().split(" ");
			int i = Integer.parseInt(inputs[0]);
			int j = Integer.parseInt(inputs[1]);
			int s = Integer.parseInt(inputs[2]);
			int d = Integer.parseInt(inputs[3]);
			int z = Integer.parseInt(inputs[4]);
			sharks.add(new Shark(i, j, s, d, z));
		}
		
		exist = new Shark[r+1][c+1];
		for (Shark shark : sharks) {
			exist[shark.currentI][shark.currentJ] = shark;
		}
		
		for (int t = 1; t <= c; t++) {
			for (int i = 1; i <= r; i++) {
				if (exist[i][t] != null) {
//					System.out.println(t + " " + exist[i][t]);
					sum += exist[i][t].size;
					sharks.remove(exist[i][t]);
					break;
				}
			}
			
			for (Shark shark : sharks) {
				shark.getPosition(t);
			}
			
			Shark[] sharkArray = (Shark[]) sharks.toArray(new Shark[sharks.size()]);
			Arrays.sort(sharkArray, (a, b) -> b.size - a.size);
			exist = new Shark[r+1][c+1];
			for (int i = 0; i < sharkArray.length; i++) {
				if (exist[sharkArray[i].currentI][sharkArray[i].currentJ] != null) {
//					exist[sharkArray[i].currentI][sharkArray[i].currentJ].size += sharkArray[i].size;
					sharks.remove(sharkArray[i]);
				} else {
					exist[sharkArray[i].currentI][sharkArray[i].currentJ] = sharkArray[i];					
				}
			}		

		}
		
		System.out.println(sum);
		

	}

}

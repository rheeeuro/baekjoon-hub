

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int n, m, k;
	static int[][] arr;
	static List<Fireball> fireballs;
	static int[][] direction = {
			{-1, 0},
			{-1, 1},
			{0, 1},
			{1, 1},
			{1, 0},
			{1, -1},
			{0, -1},
			{-1, -1},
	};
	static List<Fireball>[][] visited;
	
	static class Fireball {
		private int r;
		private int c;
		private int m;
		private int s;
		private int d;
		
		public Fireball() {
		}
		

		public Fireball(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}


		public int getR() {
			return r;
		}

		public int getC() {
			return c;
		}

		public int getM() {
			return m;
		}

		public int getS() {
			return s;
		}

		public int getD() {
			return d;
		}

		public void setR(int r) {
			this.r = r;
		}

		public void setC(int c) {
			this.c = c;
		}

		public void setM(int m) {
			this.m = m;
		}

		public void setS(int s) {
			this.s = s;
		}

		public void setD(int d) {
			this.d = d;
		}


		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Fireball [r=").append(r).append(", c=").append(c).append(", m=").append(m).append(", s=")
					.append(s).append(", d=").append(d).append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int k = Integer.parseInt(inputs[2]);
		
		arr = new int[n][n];
		visited = new List[n][n];

		fireballs = new ArrayList<Fireball>();
		
		for (int i = 0; i < m; i++) {
			String[] line = br.readLine().split(" ");
			Fireball newFireball = new Fireball();
			newFireball.setR(Integer.parseInt(line[0])-1); // ri
			newFireball.setC(Integer.parseInt(line[1])-1); // ci
			newFireball.setM(Integer.parseInt(line[2])); // mi
			newFireball.setS(Integer.parseInt(line[3])); // si
			newFireball.setD(Integer.parseInt(line[4])); // di
			
			fireballs.add(newFireball);
		}
		
		for (int i = 0; i < k; i++) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					visited[a][b] = new ArrayList<Fireball>();
				}
			}
			for (Fireball fireball : fireballs) {

				for (int j = 0; j < fireball.getS(); j++) {
					int newR = fireball.getR() + direction[fireball.getD()][0];
					int newC = fireball.getC() + direction[fireball.getD()][1];
					
					if (newR < 0) newR = (newR + n) % n;
					if (newC < 0) newC = (newC + n) % n;
					if (newR >= n) newR %= n;
					if (newC >= n) newC %= n;
					fireball.setR(newR);
					fireball.setC(newC);
					
				}
				visited[fireball.getR()][fireball.getC()].add(fireball);
			}
	
			
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (visited[a][b].size() > 1) {
						int size = visited[a][b].size();
						int sumM = 0;
						int sumS = 0;
						
						int[] count = new int[2];
						
						for (Fireball fireball : visited[a][b]) {
							sumM += fireball.getM();
							sumS += fireball.getS();
							if (fireball.getD() % 2 == 0) count[0] += 1;
							else count[1] += 1;
							fireballs.remove(fireball);
						}
						
						if (Math.floor(sumM/5) > 0) {
							if(count[0] == 0 || count[1] == 0) {
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 0));
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 2));
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 4));
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 6));															
							} else {
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 1));							
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 3));							
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 5));							
								fireballs.add(new Fireball(a, b, sumM/5, sumS/size, 7));														
							}
							
						}
					}
				}
			}
		}
		
		int result = 0;
		for (Fireball fireball : fireballs) {
			result += fireball.getM();
		}
		System.out.println(result);
	}
	
}

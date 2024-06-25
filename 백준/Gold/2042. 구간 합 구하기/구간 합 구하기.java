
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static long arr[];		// 원소를 장하는 배열
	static long tree[];		// SGtree


	/**
	 * 원소를 이용해서 SGTree를 구성하는 함수
	 * @param node		Tree의 node 번호
	 * @param start		원소의 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 start index
	 * @param end		원소의 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @return			node에 저장된 값을 리턴한다.	단말 노드면 원소ㅢ 값이고, 중간 노드면 관리하고 있는 중간 값.
	 */
	static long init(int node, int start, int end) {
		if (start == end) {		// 단말 노드
			return tree[node] = arr[start];		// 원소의 값을 노드에 저장한다.
		} else {								// 중간 노드
			// 하위 노드의 값을 더해서 저장
			// int mid = (start + end) / 2;
			int mid = (start + end) >> 1;
			int nn = node * 2;
			return tree[node] = init(nn, start, mid) + init(nn+1, mid+1, end);
		}

	}

	/**
	 * 구간 합을 구하는 함수
	 * @param node		Tree의 node 번호
	 * @param start		원소의 저장된 배열의 start index => node가 저장하고 있는 중간값에 대한 start index
	 * @param end		원소의 저장된 배열의 end index => node가 저장하고 있는 중간값에 대한 end index
	 * @param left		구간합을 구할 start index
	 * @param right		구간합을 구할 end index
	 * @return			arr의 index가 구간합을 구할 index의 범위 밖이면 0을 리턴하고 
	 * 					범위 내의 index인 경우 단말 노드면 원소 값을 리턴하고
	 * 					중간 노드면 하위노드를 sum한 값을 리턴한다.
	 */
	static long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) {		// 구간 합을 구할 범위 밖
			return 0;
		}

		// start ~ end 범위 내에 속하는 원소

		// 단말 노드라면
		if (left <= start && end <= right) {
			return tree[node];
		}
		// 하위 노드의 sum값을 구한다.
		int mid = (start + end) >> 1;
		int nn = node * 2;
		return sum(nn, start, mid, left, right) + sum(nn+1, mid+1, end, left, right);
	}

	static long update(int node, int start, int end, int index, long diff) {
		if (start <= index && index <= end) {
			if (start == index && end == index) {
				tree[node] = diff;
			} else {
				int mid = (start + end) >> 1;
				int nn = node * 2;
				tree[node] = update(nn, start, mid, index, diff) + update(nn+1, mid+1, end, index, diff);
			}
		}
		return tree[node];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());		// 원소 수
		int M = Integer.parseInt(st.nextToken());		// 구간합 구할 횟수
		int K = Integer.parseInt(st.nextToken());		// update 횟수

		arr = new long[N+1];
		tree = new long[N << 2];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(in.readLine());
		}

		init(1, 1, N);
		for (int i = 0, end = M+K; i < end; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			if (command == 1) {			// 변경
				update(1, 1, N, a, b);
			} else {					// sum
				out.write(sum(1, 1, N, a, (int)b) + "\n");
			}
		}
		in.close();
		out.close();
	}
}
/*
12 1 0
1
9
3
8
4
5
5
9
10
3
4
5
2 1 4
 */
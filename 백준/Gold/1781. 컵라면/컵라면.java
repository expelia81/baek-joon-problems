
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		// 마감일 기준
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

		// 컵라면 기준
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> a-b);


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new int[]{a,b});
		}
		pq2.add(pq.poll()[1]);
		while (!pq.isEmpty()) {
			int[] a = pq.poll();
			// 현재 꺼낸 큐의 마감일은 "반드시" 안의 모든 컵라면보다 마감일이 늦거나 같다.
			// 따라서, 현재 꺼낸 문제는 반드시 다른 컵라면을 대체할 수 있다.
			// 일수의 경과는 현재까지 푼 문제의 갯수이다.

			int deadline = a[0];
			int ramen = a[1];

			pq2.add(ramen);
			if (deadline < pq2.size()) {
				// 데드라인일이 현재 푼 문제보다 많다면 하나를 지운다.
				pq2.poll();
			}
		}
		long result = 0;
		while (!pq2.isEmpty()) {
			result += pq2.poll();
		}


		bw.write(String.valueOf(result));

		bw.flush();
		bw.close();
		br.close();
	}
}

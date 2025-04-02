
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

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				if (pq.size() > n) {
					throw new IllegalArgumentException("n is too big");
				}
				int temp = Integer.parseInt(st.nextToken());
				if (pq.size() < n) {
					pq.add(temp);
				} else if (pq.peek() < temp) {
					pq.poll();
					pq.add(temp);
				}
			}
		}

		bw.write(String.valueOf(pq.peek()));

		bw.flush();
		bw.close();
		br.close();
	}
}

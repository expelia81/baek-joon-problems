
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static int[] visited;
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new int[n+1];


		for (int i = 1; i <= n; i++) {
			visited[i] = 1;
			find(1, i+"", bw);
			visited[i] = 0;
		}


		bw.flush();
		bw.close();
		br.close();
	}

	private static String find(int depth, String value, BufferedWriter bw) throws IOException {
		if (depth == m) {
			bw.write(value + "\n");
			return value;
		}
		for (int i = 1; i <= n; i++) {
//			if (visited[i] == 0) {
//				visited[i] = 1;
//				visited[i] = 0;
//			}
				find(depth + 1, value +" "+ i, bw);
		}
		return value;
	}
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static List<Integer> lis;
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		arr = new int[n][2];
		lis = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = arr[i][0];
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (arr[i][0] < arr[j][0]) {
					arr[j][1] = Math.max(arr[i][1]+arr[j][0], arr[j][1]);
				}
			}
			max = Math.max(max, arr[i][1]);
		}



		bw.write(String.valueOf(max));


		bw.flush();
		bw.close();
		br.close();
	}


	private static void log() {
		for (int i : lis) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
	private static void log(String exp, int temp) {
		System.out.printf(exp, temp);
	}
}


/*
25
10 12 14 11 15 22 1 21 8 24 8 20 3 2 5 6 17 7 16 25 19 23 18 13 3

25
12 10 14 11 15 22 1 21 8 24 8 20 3 2 5 6 17 7 16 25 19 23 18 13 23
 */
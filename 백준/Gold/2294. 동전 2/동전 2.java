
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," " );
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[k+1];
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i]=Integer.parseInt(br.readLine());
		}

		Arrays.fill(arr, 1000000);
		arr[0]=0;

		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				int nextValue = i+coins[j];
				if (nextValue <= k) {
					arr[nextValue] = Math.min(arr[i]+1,arr[nextValue]);
				}
			}
		}

		String result = arr[k]==1000000 ? "-1" : String.valueOf(arr[k]);
		bw.write(result);




		bw.flush();
		bw.close();
		br.close();
	}
}

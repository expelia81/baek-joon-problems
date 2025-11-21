
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int et = Integer.parseInt(st.nextToken());
			int tar = Integer.parseInt(st.nextToken());
			int[] eaters = new int[et];
			int[] targets = new int[tar];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < et; i++) {
				eaters[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < tar; i++) {
				targets[i] = Integer.parseInt(st.nextToken());
			}
//			Arrays.sort(eaters);
			Arrays.sort(targets);
			int sum = 0;
			for (int i = 0; i < eaters.length; i++) {
				sum+=findLeft(eaters[i],targets);
			}
			bw.write(String.valueOf(sum));
			bw.write("\n");
		}




		bw.flush();
		bw.close();
		br.close();
	}
	private static int findLeft(int eater, int[] arr) {
		int start =0;
		int end = arr.length;

		while (start < end) {
			int mid = start + (end-start)/2;

			if(eater > arr[mid]) {
				start = mid+1;
			} else {
				end = mid;
			}
		}

		return start;
	}
}

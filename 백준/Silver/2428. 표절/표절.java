
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		// start = i, end=n-1 로 하는 이분탐색 실행

		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int left = findLeft(i,n,arr);
//			System.out.printf("out i(%d) : %d\n",i,left);
			sum += (left-i);
		}

		bw.write(String.valueOf(sum));



		bw.flush();
		bw.close();
		br.close();
	}
	private static int findLeft(int i, int n, int[] arr) {

		int start = i+1;
		int end = n;
		while (start < end) {
			//   0 (0 0 0 0 0)
			int mid = start+(end-start)/2;
			int targetValue = arr[mid]*9;

//			System.out.printf("i(%d) : %d / %d / %d\n",i,start,mid,end);
			if (targetValue>arr[i]*10) { // 0.9배가 더 클 경우에만 통과된다.
				// 아닐 경우, mid를 제외하고 당겨야하므로 -1을 해준다.
				end = mid;
			} else {
				// 더 클 경우, 탐색 범위가 조정된다. mid까지는 확정적인 값이므로.
				start = mid +1;
			}
		}
		return start-1;
	}
}

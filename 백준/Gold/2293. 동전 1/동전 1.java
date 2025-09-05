
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		int[] values = new int[k+1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
//			if (arr[i] <= k) {
//				values[arr[i]]=1;
//			}
		}
		Arrays.sort(arr);
		values[0]=1;
		for (int i = 0; i<n;i++) {
			for (int j = arr[i]; j <= k; j++) {
				values[j] += values[j-arr[i]];
			}
//			for (int j = 1; j <= k; j++) {
//				System.out.print(values[j]);
//				System.out.printf(" ");
//			}
//			System.out.println();
		}
		long result = 0;
		for (int i = 1; i <= k; i++) {
			result += values[i];
		}
		bw.write(String.valueOf(values[k]));


		/*

		1 -> 1
		2 -> 1 1, 2
		3 -> 1 1 1, 1 2
		4 -> 1 1 1 1, 1 1 2, 2 2
		5 -> 1 1 1 1 1, 1 2 2, 1 1 1 2, 5
		6 -> 1 1 1 1 1 1, 1 1 2 2, 2 2 2, 1 1 1 1 2, 1 5


		 */





		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean find(int[] arr, int target) {

		int value =  arr[target];

		int left = 0;
		int right = arr.length-1;

		while (right > left) {
			if (right==target) {
				right--; continue;
			} if(left==target) {
				left++;continue;
			}
			int temp = arr[left]+arr[right];
			if (temp==value) return true;

			if (temp>value) right--;
			else left++;
		}
		return false;
	}
}

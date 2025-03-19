
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[501][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			arr[left][0] = right;
			arr[left][1] = 1;
		}

		int max = 0;
		for (int i = 1; i <= 500; i++) {
			int value = arr[i][0];
			max = Math.max(max, arr[i][1]);
			if (arr[i][0] > 0){
				for (int j = i+1; j <= 500; j++) {
					if (arr[j][0]>value) {
						arr[j][1]  = Math.max(arr[j][1], arr[i][1]+1);
					}
				}
			}
		}

//		for (int i = 0; i < 11; i++) {
//			System.out.println(i + " : " + arr[i][0]+ " : " +arr[i][1]);
//		}
//
//		System.out.printf("max : %d\n",max);

		bw.write(n-max+"");



		bw.flush();
		bw.close();
		br.close();
	}
}

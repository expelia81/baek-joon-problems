
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int n = s.length();

		int[] arr = new int[n+1];
		arr[0]=0;
		for (int i = 0; i < n; i++) {
			arr[i+1] = Integer.parseInt(s.charAt(i)+"");
		}
		int[] dp = new int[n + 1];

		/*
		  dp[n] = dp[n-1] * n-1번째 수와 현재 수로 만드는 경우의 수
		 */

		dp[0]=1;
		dp[1]=1;
//		dp[n] = dp[n-1] + dp[n-2] * (n-1과 n이 만드는 경우의 수)
		// 즉, n-1,n이 이루는 값이 26 이하라면.

		if (isAlphabet(0,arr[1]) == -1) {
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();
			return;
		} else {
			for (int i = 2; i <= n; i++) {
				switch (isAlphabet(arr[i-1],arr[i])) {
					case 1 : {
						if (arr[i-1]==0) {
							dp[i] = dp[i-1];
						} else {
							dp[i] = dp[i-1] + dp[i-2];
						}
						break;
					}

					case -1 : {
						bw.write("0");
						bw.flush();
						bw.close(); br.close();
						return;
					}
					case 2 : {
						dp[i] = dp[i-2];
						dp[i-1] = 0;
						break;
					}

					default: {
						dp[i] = dp[i-1];


					}
				}
//				System.out.printf("dp[%d] : %d  (target : %d)\n",i,dp[i],arr[i-1]*10+arr[i]);

				if (dp[i]>1000000) dp[i] = dp[i]%1000000;
			}
		}

		/*
		1 = 1  // 2
		2 = 2   // 2+5, 25
		3 = 2   // 51 -> 2+5+1, 25+1, 2+51 (x)
		4 = 4    // 11 ->
		5 = 6    // 14 ->
		 */

		bw.write(dp[n]+"");


		bw.flush();
		bw.close();
		br.close();
	}

	private static int isAlphabet(int x, int y) {
		int temp = x*10 + y;
		if (temp==0 || (x>2 && y==0)) {
			return -1;
		}

		if (y==0) {
			return 2;
		}
		if (temp <= 26 && temp > 0) {
			return 1;
		}
		return 0;
	}
}


import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String left = br.readLine();
		String right = br.readLine();

		dp = new int[left.length()+1][right.length()+1];

		for (int i = 1; i < left.length() + 1; i++) {
			for (int j = 1; j < right.length()+1; j++) {
				if (left.charAt(i-1)==right.charAt(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				} else {
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}


		bw.write(dp[left.length()][right.length()]+"");

		bw.flush();
		bw.close();
		br.close();
	}
	private static int[][] dp;
	private static int dp(int x,int y,String left, String right) {
		if (x==0 || y==0) {
			return 0;
		}
//		if (dp[x][y]!=-1) {
//			return dp[x][y];
//		}

		if (left.charAt(x-1) == right.charAt(y-1)) {
			return dp(x-1,y-1,left,right)+1;
		}

		return Math.max(dp(x-1,y,left,right),dp(x,y-1,left,right));

	}
}

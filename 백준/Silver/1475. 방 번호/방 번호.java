
import java.io.*;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[10];

		while(n > 0) {
			arr[n % 10]++;
			n /= 10;
		}

		int max = 0;
		for (int i = 0; i < 10; i++) {
			int value = arr[i];
			int result = value;
			if (i == 6 || i == 9) {
				value = arr[6] + arr[9];
				result = value / 2 + value % 2;
			}
			max = Math.max(max, result);
		}
		bw.write(max + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}

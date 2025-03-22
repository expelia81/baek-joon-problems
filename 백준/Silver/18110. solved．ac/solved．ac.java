
import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int minus = (int) Math.round(n *0.15);

		Arrays.sort(arr);

		Double result = 0.0;
		for (int i = minus; i < n-minus; i++) {
			result+=arr[i];
		}

		double t = n-minus-minus;

		result = result/t;


		bw.write((int)Math.round(result)+"");

		bw.flush();
		bw.close();
		br.close();
	}
}


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;
	private static List<Integer> lis;
	public static void main(String [] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " " );

		arr = new int[n];
		lis = new ArrayList<>();

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		/*
		  마지막 수보다 크다면, 단순하게 lis에 추가된다.
		  마지막 수보다 작다면, 이분 탐색을 통해 lis에 투입될 숫자를 찾는다.
			-> 그럼 히스토리 추적은 어떻게 하는가....?
		 */

		lis.add(arr[0]);
		for (int i = 1; i < n; i++) {
			int last = lis.get(lis.size()-1);
//			log("now : %d\n",arr[i]);
			if (last < arr[i]) {
				lis.add(arr[i]);
			} else {
				int start = 0;
				int end = lis.size()-1;
				int mid=0;
				int now = arr[i];
				while (start<end) {
					mid = start + (end-start)/2;
					int target = lis.get(mid);
//					System.out.printf("이번 이분탐색 : %d ~ %d (mid : %d) (target : %d)\n",start,end,mid,target);
					if (target>=now) {
						end = mid;
					} else {
						start = mid+1;
					}
				}
//				log("insert : %d\n" ,mid);
				if (lis.get(mid) > now) {
					lis.set(mid,now);
				} else if (lis.get(mid) < now){
					lis.set(mid+1,now);
				}
			}
//			log();
		}

		bw.write(lis.size()+"");



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
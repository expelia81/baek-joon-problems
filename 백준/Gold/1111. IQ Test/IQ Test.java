import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (n==1) {
            bw.write("A\n");
        } else if (n==2) {
            if (arr[0]==arr[1]) {
                bw.write(String.valueOf(arr[0]));
            } else {
                bw.write("A\n");
            }
        } else {
            // f(x) = f(x-1)*a+b

            int x0 = arr[0];
            int x1 = arr[1];
            int x2 = arr[2];

            int temp = x2-x1;
            int aV = x1-x0;  // -> 이게 어떻게 0이 될 수 있지?
            if (aV==0) {
                for (int i=1;i<n;i++) {
                    if (arr[0]!=arr[i]) {
                        bw.write("B\n");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
                bw.write(String.valueOf(arr[0]));
                bw.flush();
                bw.close();
                br.close();
                return;
            }
            int a = temp/aV;
            int b = x1-a*x0;
            if(temp%aV!=0) {
                bw.write("B\n");
            } else {
//                System.out.println(a+" / "+b);
                for(int i=2;i<n;i++) {
                    if (!f(arr,i,a,b)) {
                        bw.write("B\n");
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
                bw.write(String.valueOf(a*arr[arr.length-1]+b));
            }



        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void f(int[] arr) {
        int x0 = arr[0];
        int x1 = arr[1];
        int x2 = arr[2];

        int temp = x2-x1;
        int aV = x1-x0;
        int a = temp/aV;

        // 1번째와 2번째에 절대값의 차이가 1이라도 존재하는 경우, a가 절대로 100을 초과할 수 없다?
        // 100-98, 200-98

        // 5 = 6a + b
        // 4 = 5a + b
        // 1 = a  -> a=1   a가 정해지면, b도 정해진다. 이제 모든 항에 대해 a,b를 연산해서 틀리면 B를 보낸다.

        // -8 = 16a + b
        // 4 = -8a +b
        // -12 = 24a
        // a=-0.5???   a가 정수가 아니면 B로 판정한다.  a가

        // 12 = -12a+b
        // -36 = 12a+b
        // 48 = -24a
        // a=-2
        // b=-12
    }

    public static boolean f(int[] arr, int x, int a, int b) {
        int target = a*arr[x-1]+b;
        if ( arr[x]!=target) {
//            System.out.println("x="+x+" a="+a+" b="+b+" target="+target);
            return false;
        }
        return true;
    }
}
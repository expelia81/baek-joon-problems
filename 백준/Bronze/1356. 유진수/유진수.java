import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i,j;
		String str = br.readLine();
		boolean chk = false;
		for(i=0;i<str.length()-1;i++) {
			int a = 1, b =1;
			
			for(j = 0;j <= i;j++){
			  a *= str.charAt(j)-'0';  
			}
			
			for(j = i+1; j < str.length();j++){
			  b *= str.charAt(j)-'0';  
			}
			
			if(a == b) {
				chk = true;
				break;
			}
			
		}
		
		System.out.println(chk?"YES":"NO");
		
	}
}
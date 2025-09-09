import java.util.*;

class Solution {
    
    static Set<String> map = new HashSet<>();
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        

		Arrays.sort(phone_book, (s1,s2) -> s1.length() - s2.length());
		
		for(String s : phone_book) {
            boolean result = check(s);
            if(result) {
                return false;
            } else {
                map.add(s);
            }
		}
		
        return answer;
    }
    
    public boolean check(String s) {
        for(int i=0;i<s.length();i++) {
            String temp = s.substring(0,i+1);
            if(map.contains(temp)) {
                return true;
            }
        }
        return false;
    }
}
import java.util.*;
class Solution {
    public String solution(String[] part, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : completion) {
            if(map.containsKey(s)) {
                map.put(s,map.get(s)+1);
            } else {
                map.put(s,1);
            }
        }
        
        for(String s : part) {
            if(map.containsKey(s)) {
                if(map.get(s)==1){
                    map.remove(s);
                } else {
                    map.put(s,map.get(s)-1);
                }
            } else {
                return s;
            }
        }
            
        
        return answer;
    }
}
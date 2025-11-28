import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        
        for(int i=progresses.length-1;i>=0;i--) {
            int temp = (100-progresses[i])/speeds[i] + ((100-progresses[i])%speeds[i]==0 ? 0:1);
            stack.add(temp);
        }
        List<Integer> result = new ArrayList<>();
        
        while(!stack.isEmpty()) {
            int value = stack.pop();
            int size = 1;
            while(!stack.isEmpty()) {
                int target = stack.pop();
                if(target <= value) {
                    size++;
                } else {
                    stack.add(target);
                    break;
                }
            }
            result.add(size);
        }
        answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i]=result.get(i);
        }
        return answer;
    }
}
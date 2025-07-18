import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int mid = 0;
        
        int left = 1;
        int right = 100000;
        
        while(left < right) {
            mid = (right+left)/2;
            long value = solveAll(mid,diffs,times);
            
            // System.out.println("called : mid : "+mid + " value : "+value);
            if(limit < value) {
                // 이 경우에는, 문제를 풀지 못했으므로 레벨을 올린다.
                left = mid+1;
            } else {
                right = mid;
            }
        }
        
        
        return right;
    }
    
    public long solveAll(int level, int[] diffs, int[] times) {
        long sum = solve(level,diffs[0],0,times[0]);
        
        for(int i=1;i<diffs.length;i++) {
            sum+=solve(level,diffs[i],times[i-1],times[i]);
        }
        return sum;
    }
    
    public int solve(int level, int diff, int prev, int cur) {
        if(diff<=level) {
            return cur;
        }
        return (diff-level)*(prev+cur) +cur;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Deque<Integer> stack = new ArrayDeque<>();
        int young = 1;
        
        for(int o : order) {
            if(!stack.isEmpty() && stack.peek() == o) {
                stack.pop();
                answer++;
                continue;
            }
            
            // 종료 조건 
            if(young > o) {
                break;
            }
            
            while(young < o) {
                stack.push(young);
                young++;
            }
            
            if(young == o) {
                answer++;
                 young++;
            }
        }
        
        return answer;
    }
}
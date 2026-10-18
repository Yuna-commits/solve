import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++) {
            // 주식가격이 떨어졌으면 그 위치부터 인덱스 계산
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
                
            // 인덱스 저장
            stack.push(i);
        }
        
        // 스택에 남아있는 인덱스 처리
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - 1 -idx;
        }
        
        return answer;
    }
}
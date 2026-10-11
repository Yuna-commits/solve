import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int num : arr) {
            // 스택이 비어있으면 현재 숫자 삽입
            if(stack.isEmpty()) {
                stack.push(num);
            }
            // 스택의 맨 위 숫자가 현재 숫자와 다른 경우
            if(stack.peek() != num) {
                result.add(stack.pop());
                stack.push(num);
            }
        }
        
        // 스택에 남아 있는 숫자 처리
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            // 여는 괄호면 스택에 삽입
            if(c == '(') {
                stack.push(c);
            }
            // 닫는 괄호면
            else {
                // 짝이 되는 괄호가 없으면 false
                if(stack.isEmpty()) {
                    return false;
                }
                // 여는 괄호 하나 제거
                stack.pop();
            }
        }

        // 스택이 비어 있어야 모든 괄호의 짝이 맞음
        return stack.isEmpty();
    }
}
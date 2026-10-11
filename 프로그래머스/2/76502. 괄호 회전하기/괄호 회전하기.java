import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        String doubled = s + s;
        
        // 회전 시작 위치를 하나씩 이동
        for(int i=0; i<len; i++) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean isValid = true;
            
            // 시작 위치부터 기존 문자열 길이만큼 괄호 검사
            for(int j=i; j<i+len; j++) {
                char c = doubled.charAt(j);
                
                // 여는 괄호면 push
                if(c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    // 닫는 괄호인데 스택이 비어있으면
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    
                    char open = stack.pop();
                    
                    // 괄호 짝이 맞는지 검사
                    if((c == ')' && open != '(') || 
                        (c == '}' && open !='{') ||
                        (c == ']' && open !='[')) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            // 올바른 괄호 문자열인 경우
            if(isValid && stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
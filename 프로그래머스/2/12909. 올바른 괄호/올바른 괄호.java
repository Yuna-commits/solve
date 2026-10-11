import java.util.*;

class Solution {
    boolean solution(String s) {
        int count = 0;
        
        for(char c : s.toCharArray()) {
            // 여는 괄호면 count 증가, 닫는 괄호면 count 감소
            count+=(c == '(' ? 1 : -1);
            
            // 닫는 괄호가 여는 괄호보다 많으면 count 음수
            if(count < 0 ) {
                return false;
            }
        }

        // 괄호 짝이 맞으면 count == 0
        return count == 0;
    }
}
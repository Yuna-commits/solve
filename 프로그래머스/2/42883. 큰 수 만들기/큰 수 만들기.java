import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        int targetLength = number.length() - k;
        
        for(int i=0; i<number.length(); i++) {
            char ch = number.charAt(i);
            
            while(!deque.isEmpty() && k>0 && deque.peekLast() < ch) {
                deque.pollLast();
                k--;
            }
            
            deque.addLast(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while(sb.length() < targetLength) {
            sb.append(deque.pollFirst());
        }
        
        return sb.toString();
    }
}
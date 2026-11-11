import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>(); // 변환 가능한 단어 저장
        boolean[] visited = new boolean[words.length];
        
        // 변환할 수 없는 경우
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        queue.offer(begin);
        
        while(!queue.isEmpty()) {
            for(int i=0; i<queue.size(); i++) {
                String current = queue.poll();
                
                if(current.equals(target)) {
                    return answer;
                }
                
                for(int j=0; j<words.length; j++) {
                    if(!visited[j] && canConvert(current, words[j])) {
                        visited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
            answer++;
        }
        
        return 0;
    }
    
    // 문자 하나 차이인지 확인 
    private boolean canConvert(String s1, String s2) {
        int diffCount = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
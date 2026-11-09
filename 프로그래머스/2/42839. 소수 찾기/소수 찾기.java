import java.util.*;

class Solution {
    boolean[] visited = new boolean[7];
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }
        
        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(String numbers, String tmp, int length) {
        // 만든 숫자를 셋에 추가
        if(tmp.length() == length) {
            set.add(Integer.parseInt(tmp));
        }
        
        // 탐색
        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp += numbers.charAt(i); // 숫자 생성
                dfs(numbers, tmp, length);
                visited[i] = false;
                tmp = tmp.substring(0, tmp.length() - 1); // 복구
            }
        }
    }
    
    // 소수 판별
    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // (s, e)에서 e를 기준으로 정렬 -> 가장 먼저 범위가 끝나는 위치에서 요격한다면?
        Arrays.sort(targets, (a, b) -> 
            Integer.compare(a[1], b[1])
        );
        
        int lastEnd = -1; // 마지막 요격 범위의 끝
        
        for(int[] tg : targets) {
            int start = tg[0];
            int end = tg[1];
            // 현재 시작점이 lastEnd 범위 바깥이면 새로운 범위 갱신
            if(start >= lastEnd) {
                lastEnd = end;
                answer++;
            }    
        }
        
        return answer;
    }
}
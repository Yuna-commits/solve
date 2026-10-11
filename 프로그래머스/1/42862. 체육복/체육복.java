import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] clothes = new int[n+2];
        Arrays.fill(clothes, 1); // 1로 초기화
        
        // 도난
        for(int i : lost) {
            clothes[i]--;
        }
        
        // 여벌
        for(int i : reserve) {
            clothes[i]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(clothes[i] == 2) {
                // 앞쪽
                if(i>1 && clothes[i-1]==0) {
                    clothes[i] = 1;
                    clothes[i-1] = 1;
                }
                // 뒷쪽
                else if(i<n && clothes[i+1]==0) {
                    clothes[i] = 1;
                    clothes[i+1] = 1;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(clothes[i] >= 1) {
                answer++;
            }
        }
        
        return answer;
    }
}
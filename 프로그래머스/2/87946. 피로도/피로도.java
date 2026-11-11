import java.util.*;

class Solution {
   
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        // 해당 던전 집합을 탐험하고 남길 수 있는 최대 피로도
        int[] dp = new int[1 << n]; // 비트1을 n칸 이동
        
        Arrays.fill(dp, -1);
        dp[0] = k;
        
        for(int mask=0; mask < (1<<n); mask++) {
            if(dp[mask] == -1) continue;
            // 다음 던전 탐색
            for(int d=0; d<n; d++) {
                // 이미 탐험한 던전이면 건너뛰기
                if((mask & (1 << d)) != 0) continue;
                
                // 최소 필요 피로도를 만족하는지 확인
                if(dp[mask] >= dungeons[d][0]) {
                    // 다음 마스크 계산
                    int nextMask = mask | (1 << d);
                    // 다음 상태의 최대 남은 피로도 갱신
                    dp[nextMask] = Math.max(dp[nextMask], dp[mask] - dungeons[d][1]);
                }
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int mask = 0; mask < (1<<n); mask++) {
            if(dp[mask] == -1) continue;
            answer = Math.max(answer, Integer.bitCount(mask));
        }
        
        return answer;
    }
}
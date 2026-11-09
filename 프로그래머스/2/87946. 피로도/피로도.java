import java.util.*;

class Solution {
    boolean[] visited;
    int maxCount = 0;
    
    private void dfs(int[][] dungeons, int fatigue, int count) {
        maxCount = Math.max(maxCount, count);
        
        for(int d=0; d<dungeons.length; d++) {
            // 피로도 >= 최소 필요 피로도
            if(!visited[d] && fatigue >= dungeons[d][0]) {
                visited[d] = true;
                dfs(dungeons, fatigue-dungeons[d][1], count+1);
                visited[d] = false;
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return maxCount;
    }
}
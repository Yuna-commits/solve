import java.util.*;

class Solution {
    int[] subtree;
    List<List<Integer>> graph; // 인접리스트
    
    public int solution(int n, int[][] wires) {
        subtree = new int[n+1];
        graph = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 연결관계 저장
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        // 루트 노드 1번
        dfs(1, 0);
        
        // 모든 노드의 서브트리 크기 계산
        for(int node=2; node<=n; node++) {
            // 분리된 서브트리 크기 차이
            int difference = Math.abs(n - 2 * subtree[node]);
            // 최소 크기 찾기
            answer = Math.min(answer, difference);
        }
        
        return answer;
    }
    
    private int dfs(int current, int parent) {
        int size=1; // 현재 노드 포함
        
        for(int next : graph.get(current)) {
            if(next == parent) continue;
            // 현재 노드를 부모로 두는 서브 트리 찾기
            size += dfs(next, current); 
        }
        
        subtree[current] = size;
        return size;
    }
}
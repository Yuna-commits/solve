import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 인접리스트
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 연결
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // 거리 기록 (0번 사용 x)
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        
        // bfs - 1번과 다른 노드 사이 거리
        Queue<Integer> queue = new  ArrayDeque<>();
        queue.add(1); 
        distance[1] = 0;
        
        int maxDistance = 0;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next : graph.get(current)) {
                // 아직 방문 안 한 노드인 경우
                if(distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                    maxDistance = Math.max(maxDistance, distance[next]);
                }
            }
        }
        
        // 최대 거리를 가진 노드 개수 세기
        int answer = 0;
        for(int i=2; i<=n; i++) {
            if(distance[i] == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }
}
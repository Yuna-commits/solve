import java.util.*;

class Solution {
    
    class Edge {
        // from에서 to로 연결되는 비용 cost
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    int n;
    int[][] area; // 영역
    List<Edge> edges; // 간선 리스트
    int[] parent; // 대표값
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] land, int height) {
        n = land.length;
        
        // 사다리 없이 이동할 수 있는 영역 묶기
        area = new int[n][n];
        for(int[] row : area) {
            Arrays.fill(row, -1);
        }
        
        int type = 1;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(area[i][j] == -1) {
                    bfs(land, i, j, height, type);
                    type++;
                }
            }
        }
        
        // 서로 다른 영역 사이의 사다리 설치 비용 구하기
        edges = new ArrayList<>();        
        calculateEdge(land);
        
        // 영역 간 간선을 비용 오름차순으로 정렬
        edges.sort((a, b) -> Integer.compare(a.cost, b.cost));
        
        // 유니온파인드
        parent = new int[type];
        for(int i=0; i<type; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        
        // 크루스칼 알고리즘(비용이 적은 간선부터 확인)
        for(Edge e : edges) {
            int root1 = find(e.from);
            int root2 = find(e.to);
            // 연결되지 않은 영역인 경우
            if(root1 != root2) {
                union(e.from, e.to);
                answer += e.cost;
            }
        }
        
        return answer;
    }
    
    private void bfs(int[][] land, int x, int y, int height, int type) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x, y});
        area[x][y] = type;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                
                int differ = Math.abs(land[cx][cy] - land[nx][ny]);
                
                if(area[nx][ny] == -1 && differ <= height) {
                    area[nx][ny] = type;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    private void calculateEdge(int[][] land) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    
                    if(area[i][j] != area[nx][ny]) {
                        int t1 = area[i][j];
                        int t2 = area[nx][ny];
                        
                        // 사다리 설치 비용
                        int cost = Math.abs(land[i][j] - land[nx][ny]);
                        
                        // 최소 비용 저장
                        edges.add(new Edge(t1, t2, cost));
                    }
                }
            }
        }
    }
    
    // x가 속한 대표 노드 찾기
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 영역 합치기
    private void union(int t1, int t2) {
        int root1 = find(t1);
        int root2 = find(t2);
        
        if(root1 != root2) {
            parent[root2] = root1;
        }
    }
}
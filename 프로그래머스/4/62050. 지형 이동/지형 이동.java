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
    
    int size;
    int[][] region; // 각 칸이 속한 영역 번호
    int regionCount; // 전체 영역 개수
    int[] parent; // 유니온파인드 대표값
    List<Edge> edges; // 사다리 설치 후보 비용

    int[] dr = {0, 0, -1, 1};
    int[] dc = {-1, 1, 0, 0};
    
    public int solution(int[][] land, int height) {
        size = land.length;
        
        // 1. BFS로 사다리 없이 이동할 수 있는 영역 묶기
        region = new int[size][size];
        for(int[] row : region) {
            Arrays.fill(row, -1);
        }
        
        int regionCount = 0;
        
        for(int r=0; r<size; r++) {
            for(int c=0; c<size; c++) {
                if(region[r][c] == -1) {
                    regionCount++;
                    labelRegion(land, height, r, c, regionCount);
                }
            }
        }
        
        // 영역이 하나면 사다리 필요 x
        if(regionCount == 1) {
            return 0;
        }
        
        // 2. 서로 다른 영역 사이의 사다리 설치 비용 구하기
        edges = new ArrayList<>();        
        buildEdges(land);
        
        // 사다리 설치 비용 오름차순으로 정렬
        edges.sort((a, b) -> Integer.compare(a.cost, b.cost));
        
        // 3. 유니온파인드
        parent = new int[regionCount + 1];
        for(int i=1; i<=regionCount; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        
        // 4. 크루스칼 알고리즘(최소 사다리 설치 비용 계산)
        int totalCost = 0;
        int selectedEdges = 0;
        
        for(Edge e : edges) {
            // 연결되지 않은 영역인 경우
            if(union(e.from, e.to)) {
                totalCost += e.cost;
                selectedEdges++;
                
                if (selectedEdges == regionCount - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
    
    private void labelRegion(int[][] land, int height, int sr, int sc, int id) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        region[sr][sc] = id;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];
            
            for(int d=0; d<4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 범위 밖
                if(nr < 0 || nr >= size || 
                   nc < 0 || nc >= size) {
                    continue;
                }
                
                // 이미 영역이 지정된 경우
                if(region[nr][nc] != -1) {
                    continue;
                }
                
                int differ = Math.abs(land[cr][cc] - land[nr][nc]);
                
                if(differ <= height) {
                    region[nr][nc] = id;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
    
    private void buildEdges(int[][] land) {
        // 중복 제거를 위해 오른쪽, 아래쪽만 탐색
        int[] edgeDr = {0, 1};
        int[] edgeDc = {1, 0};
        
        for(int r=0; r<size; r++) {
            for(int c=0; c<size; c++) {
                for(int d=0; d<2; d++) {
                    int nr = r + edgeDr[d];
                    int nc = c + edgeDc[d];
                    
                    if(nr >= size || nc >= size) {
                        continue;
                    }
                    
                    int from = region[r][c];
                    int to = region[nr][nc];
                    
                    if(from == to) {
                        continue;
                    }
                    
                    // 사다리 설치 비용
                    int cost = Math.abs(land[r][c] - land[nr][nc]);
                        
                    // 최소 비용 저장
                    edges.add(new Edge(from, to, cost));
                }
            }
        }
    }
    
    // x가 속한 대표 노드 찾기
    private int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 영역 합치기(이미 합쳐져 있으면 false)
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if(rootA == rootB) {
            return false;
        }
        
        parent[rootB] = rootA;
        
        return true;
    }
}
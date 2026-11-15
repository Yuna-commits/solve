import java.util.*;

class Solution {
    
    class Node {
        int x, y, cost;
        
        public Node(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
    int n, m;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    char[][] map;
    
    Node start, end, lever;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        
        // 지도 초기화
        for(int i=0; i<n; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        // 위치 저장
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 'S') {
                    start = new Node(i, j, 0);
                } else if(map[i][j] == 'E') {
                    end = new Node(i, j, 0);
                } else if(map[i][j] == 'L') {
                    lever = new Node(i, j, 0);
                }
            }
        }
        
        // 레버까지 최단거리
        int startToLever = bfs(start, lever);
        // 출구까지 최단거리
        int leverToEnd = bfs(lever, end);
        
        if(startToLever == -1 || leverToEnd == -1) {
            return -1;
        } else {
            return startToLever + leverToEnd;
        }
    }
    
    // n1 -> n2
    private int bfs(Node n1, Node n2) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(n1);
        
        boolean[][] visited = new boolean[n][m];
        visited[n1.x][n1.y] = true;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 목적지인지 확인
            if(current.x == n2.x && current.y == n2.y) {
                return current.cost;
            }
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 범위 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                // 벽이 아니고 방문한 적 없는 곳
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.cost + 1));
                }
            }
        }
        
        return -1;
    }
}
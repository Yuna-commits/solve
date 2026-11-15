import java.util.*;

class Solution {
    class Point {
        int x, y, count;
        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    int n, m;
    char[][] map;
    boolean[][] visited;
        
    // 상하좌우
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        map = new char[n][m];
        visited = new boolean[n][m];
        
        // 시작점
        int startX = 0;
        int startY = 0;
        
        // 지도 초기화
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        return bfs(startX, startY);
    }
    
    private int bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x, y, 0));
        
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Point current = queue.poll();
            
            if(map[current.x][current.y] == 'G') {
                return current.count;
            }
            
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 벽 또는 장애물과 만날 때까지 이동
                while(nx >= 0 && nx < n && 
                      ny >= 0 && ny < m && 
                      map[nx][ny] != 'D') {
                    nx += dx[i];
                    ny += dy[i];
                }
                
                // 범위 안쪽으로 재이동
                nx -= dx[i];
                ny -= dy[i];
                
                // 현재 위치에서 이동할 수 없는 경우
                if(nx == current.x && ny == current.y) {
                    continue;
                }
                
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, current.count + 1));
                }
            }
        }
        
        return -1;
    }
}
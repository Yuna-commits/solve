import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int cost;
        
        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 목적지에 도착한 경우
            if(current.x == n-1 && current.y == m-1) {
                return current.cost;
            }
            
            // 동서남북 이동
            for(int i=0; i<4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 범위 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                
                if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.cost+1));
                }
            }
        }
        
        return -1;
    }
}
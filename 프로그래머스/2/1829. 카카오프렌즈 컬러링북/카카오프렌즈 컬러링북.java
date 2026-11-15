import java.util.*;

class Solution {
    boolean[][] visited;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    int row, col;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        row = m;
        col = n;
   
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture[i][j], picture));
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    
    private int bfs(int x, int y, int color, int[][] picture) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int count = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 범위확인
                if(nx < 0 || nx >= row || ny < 0 || ny >= col) {
                    continue;
                }
                
                // 색상 확인
                if(picture[nx][ny] != color) {
                    continue;
                }
                
                if(visited[nx][ny]) {
                    continue;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                count++;
            }
        }
        
        return count;
    }
}
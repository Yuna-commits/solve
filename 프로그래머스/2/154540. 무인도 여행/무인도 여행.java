import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    int row, col;
    char[][] charMap;
    boolean[][] visited;

    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();

        charMap = new char[row][col];
        visited = new boolean[row][col];
        
        // 지도 초기화
        for(int i=0; i<row;i++) {
            for(int j=0; j<col; j++) {
                charMap[i][j] = maps[i].charAt(j);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(charMap[i][j]!='X'&&!visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }
        
        if(result.isEmpty()) {
            return new int[]{-1};
        }
        
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 시작 좌표 추가
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        
        int sum = 0;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int cx = current[0];
            int cy = current[1];
            
            sum += charMap[cx][cy] - '0';
            
            for(int i=0; i<4; i++) {
                int mx = cx + dx[i];
                int my = cy + dy[i];
                
                if(mx<0 || mx>=row || my<0 || my>=col) {
                    continue;
                }
                
                if(charMap[mx][my]!='X'&&!visited[mx][my]) {
                    visited[mx][my] = true;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        
        return sum;
    }
}
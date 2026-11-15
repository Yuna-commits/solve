import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};
    int row, col;
    char[][] charMap;
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        row = maps.length;
        col = maps[0].length();
        
        visited = new boolean[row][col];
        charMap = new char[row][col];
        
        // 초기화
        for(int i=0; i<row; i++) {
            String s = maps[i];
            for(int j=0; j<col; j++) {
                charMap[i][j] = s.charAt(j);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                // x가 아니고 방문한 적 없는 곳일 때
                if(charMap[i][j] != 'X' && !visited[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        }
        
        if(result.size() == 0) return new int[] {-1};
        
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        Arrays.sort(answer);
     
        return answer;
    }
    
    private int dfs(int x, int y) {
        visited[x][y] = true; // 방문 표시
        int sum = charMap[x][y] - '0';
        
        // 상하좌우 이동
        for(int i=0; i<4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            
            if(mx<0 || mx>=row || my<0 || my>=col) {
                continue;
            }
            
            if(charMap[mx][my] != 'X' && !visited[mx][my]) {
                sum += dfs(mx, my);
            }
        }
        
        return sum;
    }
}
import java.util.*;

class Solution {
    class Rect {
        int x1, x2, y1, y2;
        public Rect(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
    
    List<Rect> rectList;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표를 2배로
        int[][] map = new int[102][102];
        rectList = new ArrayList<>();
        
        for(int i=0; i<rectangle.length; i++) {
            int startX = rectangle[i][0] * 2;
            int startY = rectangle[i][1] * 2;
            int endX = rectangle[i][2] * 2;
            int endY = rectangle[i][3] * 2;
            
            for(int y=startY; y<=endY; y++) {
                for(int x=startX; x<=endX; x++) {
                    map[y][x] = -1;
                }
            }
            
            rectList.add(new Rect(startX, endX, startY, endY));
        }
        
        int answer = bfs(map, characterX*2, characterY*2, itemX*2, itemY*2);
        
        return answer;
    }
    
    private int bfs(int[][] map, int x, int y, int ix, int iy) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y, 1});
        map[y][x] = 1;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int move = current[2];
            
            // 좌표를 2배 처리했기 때문에 실제 반환은 나누기 2
            if(cx == ix && cy == iy) {
                return move/2;
            }
            
            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || nx >= map[0].length || 
                    ny < 0 || ny >= map.length) {
                    continue;
                }
                
                // 아직 이동하지 않았고 영역 내에 있는 경우
                if(map[ny][nx] < 0 && isBoundary(nx, ny)) {
                    map[ny][nx] = move+1;
                    queue.offer(new int[]{nx, ny, move+1});
                }
            }
        }
        
        return -1;
    }
    
    // 어떤 사각형에 있는지
    private boolean isBoundary(int x, int y) {
        for(Rect r :rectList) {
            if(r.x1 < x && r.y1 < y && r.x2 > x && r.y2 > y) {
                return false;
            }
        }
        return true;
    }
}
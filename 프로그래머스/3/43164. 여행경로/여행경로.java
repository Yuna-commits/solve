import java.util.*;

class Solution {
    
    boolean[] visited;
    ArrayList<String> routes;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        routes = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        // 알파벳순으로 정렬
        Collections.sort(routes);
  
        return routes.get(0).split(" ");
    }
    
    private void dfs(String start, String path, String[][] tickets, int count) {
        // 모든 티켓을 다 쓴 경우
        if(count == tickets.length) {
            // 가능한 경로를 리스트에 넣기
            routes.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            // 현재 시작점과 일치하고 아직 티켓을 쓰지 않은 경우
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], path + " " + tickets[i][1], tickets, count+1);
                visited[i] = false; // 복구
            }
        }
    }
}
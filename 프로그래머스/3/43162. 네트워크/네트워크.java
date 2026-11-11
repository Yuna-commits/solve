class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;    
        boolean[] visited = new boolean[n];
        // dfs 종료 == 하나의 네트워크 연결
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int[][] computers, boolean[] visited, int current) {
        visited[current] = true; // 방문 처리
        for(int i=0; i<computers.length; i++) {
            // 아직 방문하지 않았고, 나와 연결된 노드
            if(!visited[i] && computers[current][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}
class Solution {
    public int[] solution(int n) {
        // 1~(n*(n+1)/2)까지의 수가 채워짐
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];
        
        int x = -1;
        int y = 0;
        
        int num = 1;
        
        // i%3 => 0: 아래로 1: 오른쪽으로 2: 왼쪽대각선
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-i; j++) {
                if(i%3==0) {
                    x++;
                } else if(i%3==1) {
                    y++;
                } else if(i%3==2) {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }
        
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                answer[idx++] = matrix[i][j];
            }
        }
        
        return answer;
    }
}
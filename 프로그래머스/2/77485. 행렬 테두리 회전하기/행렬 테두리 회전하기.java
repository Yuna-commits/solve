class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];
        
        int index = 0;
        
        // rows x columns init
        for(int r=0; r<rows; r++) {
            for(int c=0; c<columns; c++) {
                matrix[r][c] = (r * columns) + c + 1;
            }
        }
        
        // 회전
        for(int[] query : queries) {
            int x1 = query[0] - 1; // x1
            int y1 = query[1] - 1; // y1
            int x2 = query[2] - 1; // x2
            int y2 = query[3] - 1; // y2
            
            int tmp = matrix[x1][y2]; // 누락되는 숫자 저장
            int min = tmp;
            
            // (상단) 오른쪽으로
            for(int i=y2-1; i>=y1; i--) {
                min = Math.min(min, matrix[x1][i]);
                matrix[x1][i+1] = matrix[x1][i];
            }
            
            // (좌측) 위쪽으로
            for(int i=x1+1; i<=x2; i++) {
                min = Math.min(min, matrix[i][y1]);
                matrix[i-1][y1] = matrix[i][y1];
            }
            
            // (하단) 왼쪽으로
            for(int i=y1+1; i<=y2; i++) {
                min = Math.min(min, matrix[x2][i]);
                matrix[x2][i-1] = matrix[x2][i];
            }
            
            // (우측) 아래쪽로
            for(int i=x2-1; i>=x1; i--) {
                min = Math.min(min, matrix[i][y2]);
                matrix[i+1][y2] = matrix[i][y2];
            }
            
            // 누락된 숫자 다시 채우기
            matrix[x1+1][y2] = tmp;
            answer[index++] = min;
        }
        
        return answer;
    }
}
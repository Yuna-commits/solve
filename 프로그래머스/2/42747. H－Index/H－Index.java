import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 오름차순 정렬
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i=0; i<n; i++) {
            // i번째 수 이상으로 인용된 논문 개수
            int h = n - i;
            
            if(citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}
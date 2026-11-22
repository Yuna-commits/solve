class Solution {
    public int solution(String name) {
        int length = name.length();
        
        // 문자 이동 횟수(누적)
        int chMove = 0;
        // 커서의 최소 이동 횟수
        int minMove = length - 1; // 오른쪽으로만 이동한 경우
        
        for(int i=0; i<length; i++) {
            char ch = name.charAt(i);
            chMove+=Math.min(ch-'A', 'Z'-ch+1);
            
            int next = i+1;  // 연속된 A 구간이 끝난 직후의 인덱스
            while(next<length && name.charAt(next) == 'A') next++;
            
            // 오른쪽으로 i까지 이동 -> 시작점으로 복귀 -> 왼쪽으로 next까지 이동
            minMove = Math.min(minMove, i*2+(length-next));
            
            // 왼쪽으로 next까지 이동 -> 시작점으로 복귀 -> 오른쪽으로 i까지 이동
            minMove = Math.min(minMove, (length-next)*2+i);
        }
        
        return chMove+minMove;
    }
}
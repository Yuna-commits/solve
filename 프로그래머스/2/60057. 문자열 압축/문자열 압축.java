class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<=s.length()/2; i++) {
            StringBuilder sb = new StringBuilder();
            
            String base = s.substring(0, i);
            int cnt = 1;
            
            // base와 나머지 문자열(i단위) 비교
            for(int j=i; j<s.length(); j+=i) {
                int endIdx = Math.min(j+i, s.length());
                String cmp = s.substring(j, endIdx);
                
                if(base.equals(cmp)) {
                    cnt++;
                }
                // base와 cmp가 달라지는 순간에 base를 sb에 추가
                else {
                    if(cnt >= 2) {
                        sb.append(cnt);
                    }
                    sb.append(base);
                    
                    base = cmp; // 다음 기준으로 갱신
                    cnt = 1;
                }
            }
            
            // 마지막 그룹이 남은 경우 처리 
            if(cnt >= 2) {
                sb.append(cnt);
            }
            sb.append(base);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
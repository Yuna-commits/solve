import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // <의상 종류, 의상 개수>
        Map<String, Integer> comb = new HashMap<>();
        
        for(String[] clo : clothes) {
            comb.put(clo[1], comb.getOrDefault(clo[1], 0) + 1);
        }
        
        for(String key : comb.keySet()) {
            // 착용하지 않는 경우도 포함
            answer *= (comb.get(key) + 1);
        }
        
        // 아무것도 착용하지 않는 경우 제외
        return answer-1;
    }
}
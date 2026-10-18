import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // <제품명, 제품 개수>
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 처음 10일 할인 제품 저장
        Map<String, Integer> dcnt = new HashMap<>();
        for(int i=0; i<10; i++) {
            dcnt.put(discount[i], dcnt.getOrDefault(discount[i], 0) + 1);
        }
        
        for(int i=0; i<=discount.length-10; i++) {
            boolean flag = true;
            // 비교
            for(String key : wantMap.keySet()) {
                if(!dcnt.containsKey(key) || !wantMap.get(key).equals(dcnt.get(key))) {
                    flag = false;
                }
            }
            
            if(flag) {
                answer++;
            }
            
            if(i+10 < discount.length) {
                // 윈도우 이동 (앞 제품 빼고, 뒤 제품 추가)
                dcnt.put(discount[i], dcnt.get(discount[i]) - 1);
                dcnt.put(discount[i+10], dcnt.getOrDefault(discount[i+10], 0) + 1);
            }
        }
        
        return answer;
    }
}
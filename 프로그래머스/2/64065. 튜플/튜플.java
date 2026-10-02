import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.replaceAll("[{}]", "").split(",");
        
        // 숫자, 빈도수
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String str : split) {
            int num = Integer.parseInt(str);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
    
        // 빈도가 많은 순으로 정렬
        int[] array = map.keySet().stream()
            .sorted((o1, o2) -> map.get(o2).compareTo(map.get(o1)))
            .mapToInt(Integer::intValue)
            .toArray();
        
        return array;
    }
}
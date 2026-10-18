import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // <이름, 참조시간>
        Map<String, Integer> cache = new HashMap<>();
        int time = 0;
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for(String city : cities) {
            city =  city.toLowerCase();
            
            // 캐시에 존재하는 경우
            if(cache.containsKey(city)) {
                // 캐시 히트
                answer+=1;
            } 
            // 캐시에 존재하지 않는 경우
            else {
                // 캐시 미스
                answer+=5;
                
                // 캐시에 공간이 없는 경우
                if(cache.size() >= cacheSize) {
                    // 가장 오랫동안 참조되지 않은 키 제거
                    String least = "";
                    int min = Integer.MAX_VALUE;
                    for(String key : cache.keySet()) {
                        if(cache.get(key) < min) {
                            least = key;
                            min = cache.get(key);
                        }
                    }
                    cache.remove(least);
                }
            }
            
            cache.put(city, time);
            time++;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 유형별 점수 map
        Character[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: type) {
            map.put(c, 0);
        }
        
        for(int i=0; i<survey.length; i++) {
            int value = choices[i];
            
            if(value == 4) {
                continue;
            } 
            // 동의
            else if(value > 4) {
                char ch = survey[i].charAt(1);
                map.put(ch, map.get(ch) + (value - 4));
            }
            // 비동의
            else {
                char ch = survey[i].charAt(0);
                map.put(ch, map.get(ch) + (4 - value));
            }
        }
        
        // 유형별 점수 비교, 동일하면 알파벳순
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<type.length; i+=2) {
            if(map.get(type[i]) >= map.get(type[i+1])) {
                answer.append(type[i]);
            } else {
                answer.append(type[i+1]);
            }
        }
        
        return answer.toString();
    }
}
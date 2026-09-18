import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> map = Map.ofEntries(
            Map.entry("zero", "0"),
            Map.entry("one", "1"),
            Map.entry("two", "2"),
            Map.entry("three", "3"),
            Map.entry("four", "4"),
            Map.entry("five", "5"),
            Map.entry("six", "6"),
            Map.entry("seven", "7"),
            Map.entry("eight", "8"),
            Map.entry("nine", "9")
        );
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            // 숫자인 경우
            if(Character.isDigit(ch)) {
                result.append(ch);
            } 
            // 문자인 경우
            else {
                tmp.append(ch);
                if(map.containsKey(tmp.toString())) {
                    result.append(map.get(tmp.toString()));
                    tmp.setLength(0);
                }
            }
        }
        
        return Integer.parseInt(result.toString());
    }
}
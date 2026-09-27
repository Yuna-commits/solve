import java.util.*;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        
        Arrays.sort(split, (s1, s2) -> Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2)));
        
        return String.join(" ", split[0], split[split.length-1]);
    }
}
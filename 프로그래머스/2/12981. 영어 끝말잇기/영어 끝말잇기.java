import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);

        // 두 번째 사람부터 시작
        for(int i=1; i<words.length; i++) {
            int num = i % n + 1;
            int cnt = i / n + 1;
            
            String prev = words[i-1];
            String now = words[i];
                        
            // 끝말잇기인지? 처음 나온 단어인지?
            if(prev.charAt(prev.length() - 1) != now.charAt(0) || set.contains(now)) {  
                return new int[]{num, cnt};
            }
            set.add(words[i]);
        }

        return new int[]{0, 0};
    }
}
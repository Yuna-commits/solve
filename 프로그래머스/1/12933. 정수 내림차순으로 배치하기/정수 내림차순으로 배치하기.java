import java.util.*;

class Solution {
    public long solution(long n) {
        String[] array = String.valueOf(n).split("");
        Arrays.sort(array, Collections.reverseOrder());
        long answer = Long.parseLong(String.join("", array));
        return answer;
    }
}
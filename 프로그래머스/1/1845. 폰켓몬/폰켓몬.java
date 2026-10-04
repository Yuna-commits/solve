import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        int cnt = set.size();
        int answer = cnt > nums.length / 2 ? nums.length / 2 : cnt;
        
        return answer;
    }
}
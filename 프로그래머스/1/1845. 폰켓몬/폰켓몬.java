import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        
        // 포켓몬 종류 size가 N/2보다 많으면 최대 N/2 사용 가능, 적으면 size 사용 가능
        int answer = Math.min(set.size(), nums.length/2);
        
        return answer;
    }
}
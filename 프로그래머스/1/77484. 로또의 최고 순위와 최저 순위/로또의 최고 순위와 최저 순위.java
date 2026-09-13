import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        
        List<Integer> lotto = Arrays.stream(lottos).boxed().toList();
        List<Integer> win = Arrays.stream(win_nums).boxed().toList();
        
        int zero = Collections.frequency(lotto, 0);
        
        for(int num : lotto) {
            if(win.contains(num)) {
                match++;
            }
        }
        
        int max = Math.min(7 - (match + zero), 6);
        int min = Math.min(7 - match, 6);
        
        return new int[] {max, min};
    }
}
import java.util.*;

class Solution {
    private int getRank(int match) {
        switch(match) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6;
        }
    }
    
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
        
        int max = getRank(match + zero);
        int min = getRank(match);
        
        return new int[] {max, min};
    }
}
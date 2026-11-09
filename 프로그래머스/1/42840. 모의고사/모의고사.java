import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == patterns[0][i % patterns[0].length]) {
                score[0]++;
            }
            if(answers[i] == patterns[1][i % patterns[1].length]) {
                score[1]++;
            }
            if(answers[i] == patterns[2][i % patterns[2].length]) {
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            if(score[i] == max) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
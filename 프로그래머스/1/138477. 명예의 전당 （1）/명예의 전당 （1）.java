import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> rank = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            // 점수 추가
            rank.add(score[i]);
            
            // 리스트 길이가 k보다 크면 가장 낮은 점수 제거
            if(rank.size() > k) {
                rank.remove(Collections.min(rank));
            }
            
            // 명예의 전당에서 가장 낮은 점수를 answer에 담기
            answer[i] = Collections.min(rank);
        }
        
        return answer;
    }
}
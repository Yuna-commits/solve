import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(int i=0; i<score.length; i++) {
            minHeap.add(score[i]);
            
            // k를 초과하면 가장 낮은 점수 제거
            if(minHeap.size() > k) {
                minHeap.poll();
            }
            
            // 발표용 가장 낮은 점수
            answer[i] = minHeap.peek();
        }
        return answer;
    }
}
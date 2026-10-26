import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works) {
            maxHeap.offer((long) w);
        }
        
        while(n > 0) {
            if(maxHeap.peek() == 0) {
                return 0;
            }
            long work = maxHeap.poll();
            maxHeap.offer(work - 1);
            n--;
        }
        
        while(!maxHeap.isEmpty()) {
            long work = maxHeap.poll();
            answer += work * work;
        }
        
        return answer;
    }
}
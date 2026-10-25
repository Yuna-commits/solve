import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] split = op.split(" ");
            
            switch(split[0]) {
                case "I":
                    int value = Integer.parseInt(split[1]);
                    minHeap.offer(value);
                    maxHeap.offer(value);
                    break;
                case "D":
                    if(minHeap.isEmpty() && maxHeap.isEmpty()) {
                        continue;
                    }
                    
                    switch(split[1]) {
                        case "1" :
                            minHeap.remove(maxHeap.poll());
                            break;
                        case "-1":
                            maxHeap.remove(minHeap.poll());
                            break;
                    }
                    break;
            }
        }
        
        return (minHeap.isEmpty() && maxHeap.isEmpty() 
                ? new int[] {0, 0} 
                : new int[] {maxHeap.peek(), minHeap.peek()});
    }
}
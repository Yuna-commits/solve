import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        // 값이 클수록 우선순위가 높도록 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 대기큐에는 인덱스, 우선순위 큐에는 우선순위 저장
        for(int i=0; i<priorities.length; i++) {
            queue.offer(i);
            pq.offer(priorities[i]);
        }
        
        while(!queue.isEmpty()) {
            // 현재 인덱스와 우선순위를 꺼냄
            int idx = queue.poll();
            int pri = priorities[idx];
            
            // 현재 프로세스가 가장 높은 우선순위이면 실행
            if(pri == pq.peek()) {
                pq.poll();
                answer++;
                // 찾고 싶은 프로세스의 위치인 경우
                if(idx == location) {
                    break;
                }
            } else {
                queue.offer(idx);
            }
        }
        
        return answer;
    }
}
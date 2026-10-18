import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) {
            // 남은 날짜가 속도로 나누어 떨어지면 당일 배포 가능
            if((100 - progresses[i]) % speeds[i] == 0) {
                queue.offer((100 - progresses[i]) / speeds[i]);
            }
            // 나누어 떨어지지 않으면 다음날 배포
            else {
                queue.offer((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        
        // 첫 번째 배포 날짜
        int now = queue.poll();
        // 같이 배포하는 기능 개수
        int count = 1;
        
        while(!queue.isEmpty()) {
            // 현재 배포 날짜가 다음 배포 날짜 이상이면 같이 배포
            if(now >= queue.peek()) {
                count++;
                queue.poll();
            }
            // 현재 배포 날짜가 다음 배포 날짜보다 작으면 먼저 배포
            else {
                result.add(count);
                count = 1;
                now = queue.poll();
            }
        }
        
        // 마지막 count 저장
        result.add(count);
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
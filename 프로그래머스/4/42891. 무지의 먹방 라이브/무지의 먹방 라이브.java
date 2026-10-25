import java.util.*;

class Food implements Comparable<Food> {
    int time; // 음식의 원래 섭취 시간
    int idx; // 음식 번호
    
    public Food(int time, int idx) {
        this.time = time;
        this.idx = idx;
    }
    
    @Override
    public int compareTo(Food other) {
        // 섭취 시간 기준 오름차순 (최소 힙)
        return Integer.compare(this.time, other.time);
    }
    
}

class Solution {
    public int solution(int[] food_times, long k) {
        // 전체 음식을 먹는 데 필요한 시간 계산
        long totalTime = 0;
        
        for(long time : food_times) {
            totalTime += time;
        }
        
        // 총 섭취 시간이 K보다 작거나 같으면 더 먹을 것이 없음
        if(totalTime <= k) {
            return -1;
        }
        
        // 섭취 시간이 짧은 음식부터 관리하는 최소 힙
        PriorityQueue<Food> pq = new PriorityQueue<>();
        
        // 우선순위 큐에 {섭취 시간, 음식 번호} 저장
        for(int i=0; i<food_times.length; i++) {
            pq.offer(new Food(food_times[i], i+1));
        }
        
        long previousTime = 0; // 이전 단계까지 각 음식에서 먹은 시간
        long remainingCount = food_times.length; // 남은 음식 개수
        
        // 남은 모든 음식을 한 번씩 먹는 데 걸리는 시간 = 남은 음식의 개수
        
        // 남은 시간 동안 peek의 음식을 다 먹을 수 있는지?
        // current - previous = 원래 섭취 시간 - 직전까지 먹은 시간 = 다 먹는 데 남은 시간
        while(!pq.isEmpty()) {
            long currentTime = pq.peek().time;
            
            // 현재 음식을 다 먹을 때까지 필요한 시간
            long timeToSpend = (currentTime - previousTime) * remainingCount;
            
            // 남은 시간 동안 음식을 다 먹을 수 없으면 중단
            if(timeToSpend > k) {
                break;
            }
            
            // 이번 단계에서 사용한 시간만큼 빼기
            k -= timeToSpend;
            
            // 소진된 음식 제거
            pq.poll();
            
            remainingCount--;
            previousTime = currentTime;
        }
        
        // 남은 음식들을 번호 순으로 정렬 -> 새 정렬 기준 구현
        List<Food> remainingFoods  = new ArrayList<>();
        while(!pq.isEmpty()) {
            remainingFoods.add(pq.poll());
        }
        
        remainingFoods.sort(
            Comparator.comparingInt(food -> food.idx)
        );
        
        // 다음에 먹을 음식 결정
        int nextIdx = (int) (k % remainingCount);
        
        return remainingFoods.get(nextIdx).idx;
    }
}
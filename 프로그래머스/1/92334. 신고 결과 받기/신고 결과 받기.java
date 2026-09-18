import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        // reported [신고자][신고당한사람]
        boolean[][] reported = new boolean [n][n];
        
        // 이름 -> 인덱스 매핑
        Map<String, Integer> index = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            index.put(id_list[i], i);
        }
        
        // 신고 관계
        for(String r : report) {
            String[] line = r.split(" ");
            reported[index.get(line[0])][index.get(line[1])] = true;
        }
        
        // 신고 횟수
        int[] count = new int[n];
        
        for(int from=0; from<n; from++) {
            for(int to=0; to<n; to++) {
                if(reported[from][to]) {
                    count[to]++;
                }
            }
        }
        
        // 메일 발송
        for(int to=0; to<n; to++) {
            if(count[to] >= k) {
                for(int from=0; from<n; from++) {
                    if(reported[from][to]) {
                        answer[from]++;
                    }
                }
            }
        }
        
        return answer;
    }
}
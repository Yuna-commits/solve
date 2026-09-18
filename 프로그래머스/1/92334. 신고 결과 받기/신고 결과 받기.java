import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        int[] answer = new int[n];
        
        // 이름 -> 순서 매핑
        Map<String, Integer> index = new HashMap<>();
        // 신고당한 사람 -> {신고한 사람 목록}
        Map<String, Set<String>> reporters = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            index.put(id_list[i], i);
            reporters.put(id_list[i], new HashSet<>());
        }
        
        for(String r : report) {
            String[] split = r.split(" ");
            // split[1]을 신고한 사람을 목록에 추가
            reporters.get(split[1]).add(split[0]);
        }
        
        // 신고 횟수가 k 이상이면 신고한 모든 사람에게 메일 전송
        for(String userId : id_list) {
            // 신고한 사람 목록 set
            Set<String> set = reporters.get(userId);
            if(set.size() >= k) {
                for(String r : set) {
                    answer[index.get(r)]++;
                }
            }
        }
        
        return answer;
    }
}
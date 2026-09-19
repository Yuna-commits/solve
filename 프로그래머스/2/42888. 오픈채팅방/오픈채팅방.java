import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // key: uid, value: nickname
        Map<String, String> nickname = new HashMap<>();
        
        // 각 uid의 입퇴장 관리
        List<String[]> actions = new ArrayList<>();
        
        // 값 저장
        for(String rec : record) {
            String[] split = rec.split(" ");
            String actType = split[0];
            String uid = split[1];
            
            switch(actType) {
                case "Enter":
                    nickname.put(uid, split[2]);
                    actions.add(new String[]{actType, split[1]});
                    break;
                    
                case "Leave":
                    actions.add(new String[]{actType, split[1]});
                    break;
                    
                case "Change":
                    nickname.replace(uid, split[2]);
                    break;
            }
        }
        
        // 조회
        String[] answer = new String[actions.size()];
        
        for(int i=0; i<actions.size(); i++) {
            String actType = actions.get(i)[0];
            String uid = actions.get(i)[1];
            String nick = nickname.get(uid);
            
            answer[i] = nick + (actType.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.");
        }
        
        return answer;
    }
}
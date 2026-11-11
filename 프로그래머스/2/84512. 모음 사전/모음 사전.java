import java.util.*;
class Solution {
    List<String> list = new ArrayList<>();
    String[] vowel = {"A", "E", "I", "O", "U"};
    
    public int solution(String word) {
        dfs(0, "");
        return list.indexOf(word);
    }
    
    // 만들 수 있는 모든 문자를 리스트에 넣기
    private void dfs(int length, String tmp) {
        list.add(tmp);
        if(length == 5) {
            return;
        }
        for(String v : vowel) {
            dfs(length+1, tmp+v);
        }
    }
}
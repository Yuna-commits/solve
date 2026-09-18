class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        
        answer = answer.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9._-]", "");
        answer = answer.replaceAll("\\.+", ".");
        answer = answer.replaceAll("^\\.|\\.$", "");
        answer = answer.length() == 0 ? "a" : answer;
        answer = answer.length() > 15 
            ? answer.substring(0, 15).replaceFirst("\\.$", "") 
            : answer;
        
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() -1);
        }
        
        return answer;
    }
}
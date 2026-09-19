class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        
        for(char ch : s.toCharArray()) {
            if(ch == ' ') {
                idx = 0;
                sb.append(ch);
                continue;
            } 
            sb.append(idx++ % 2 == 0 ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
        }
        
        return sb.toString();
    }
}
import java.util.*;

class Solution {
    public String solution(int[] numbers) {   
        String[] numToStr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            numToStr[i] = String.valueOf(numbers[i]);
        }
        
        // 앞자리부터 내림차순
        Arrays.sort(numToStr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 합쳤을 때 더 큰 수가 앞으로 가도록
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        // 모든 원소가 0인 경우
        if(numToStr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String str : numToStr) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}
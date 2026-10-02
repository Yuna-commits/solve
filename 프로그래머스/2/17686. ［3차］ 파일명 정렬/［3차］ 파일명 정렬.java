import java.util.*;

class Solution {
    private String extractHead(String str) {
        int i = 0;

        while(i < str.length() && !Character.isDigit(str.charAt(i))) {
            i++;
        }
        
        return str.substring(0, i);
    }
    
    private int extractNumber(String str, int startIdx) {
        int i = startIdx;
        
        StringBuilder sb = new StringBuilder();
        
        while(i < str.length() && Character.isDigit(str.charAt(i)) && sb.length() < 5) {
            sb.append(str.charAt(i));
            i++;
        }
        
        // 012 -> 12로 자동 변환
        return Integer.parseInt(sb.toString());
    }
    
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
           // 1. 사전 순 정렬 2. 숫자 순 정렬
            @Override
            public int compare(String o1, String o2) {
                // 헤드 추출
                String head1 = extractHead(o1);
                String head2 = extractHead(o2);
                
                // 넘버 추출
                int num1 = extractNumber(o1, head1.length());
                int num2 = extractNumber(o2, head2.length());
                
                // 1. 사전 순 정렬 (대소문자 무시)
                int headCmp = head1.compareToIgnoreCase(head2);
                if(headCmp != 0) {
                    return headCmp;
                }
                
                // 2. 숫자 순 정렬 (헤드가 같은 경우)
                return Integer.compare(num1, num2);
            }
        });
        
        return files;
    }
}
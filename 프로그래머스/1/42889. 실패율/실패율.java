import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] rate = new double[N][2]; // [스테이지번호][실패율]
        
        for(int stNum=1; stNum<=N; stNum++) {
            double challenge = 0;
            double fail = 0;
           
            for(int usrNum : stages) {
                if(usrNum >= stNum) {
                    challenge++;
                }
                if(stNum == usrNum) {
                    fail++;
                }
            }
            
            // 스테이지 실패율 저장
            rate[stNum - 1][0] = stNum; 
            rate[stNum - 1][1] = challenge == 0 ? 0 : fail/challenge;
        }
        
        // 실패율 내림차순 정렬
        Arrays.sort(rate, new Comparator<double[]>() {
            @Override
            public int compare(double[] a, double[] b) {
                int compareRate = Double.compare(b[1], a[1]);
                
                if(compareRate != 0) {
                    return compareRate;
                }
            
                // 실패율이 같으면 스테이지 번호 오름차순 정렬
                return Double.compare(a[0], b[0]);
            }
        });
        
        for(int i=0; i<N; i++) {
            answer[i] = (int)rate[i][0];
        }
        
        return answer;
    }
}
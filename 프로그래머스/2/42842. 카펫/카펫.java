class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        
        // 가로 x 세로 = total 카펫
        for(int height=3; height <= total; height++){
            // 나누어 떨어져야 세로로 사용 가능
            if(total%height!=0) {
                continue;
            }
            int width = total/height;
            // 노란색 격자 크기 계산
            if((width-2)*(height-2)==yellow) {
                return new int[]{width, height};
            }
        }
        
        return null;
    }
}
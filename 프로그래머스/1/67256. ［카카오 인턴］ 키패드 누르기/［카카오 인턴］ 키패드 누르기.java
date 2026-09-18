class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int left = 10; // 왼손 시작 위치
        int right = 12; // 오른손 시작 위치
        
        for(int i : numbers) {
            if(i == 1 || i == 4 || i == 7) {
                left = i;
                sb.append("L");
            } else if(i == 3 || i == 6 || i == 9) {
                right = i;
                sb.append("R");
            } else {
                // 거리 계산
                if(i == 0) {
                    i = 11;
                }
                
                // 행 = idx / 열의 개수, 열 = idx % 열의 개수
                // 거리 = | 행1 - 행2 | + | 열1 - 열2 |
                int leftDist = (Math.abs(i - left) / 3) + (Math.abs(i - left) % 3);
                int rightDist = (Math.abs(i - right) / 3) + (Math.abs(i - right) % 3);
                
                if(leftDist == rightDist) {
                    if(hand.equals("right")) {
                        right = i;
                        sb.append("R");
                    } else {
                        left = i;
                        sb.append("L");
                    }
                } else if(leftDist > rightDist) {
                    right = i;
                    sb.append("R");
                } else {
                    left = i;
                    sb.append("L");
                }
            }
        }
        
        return sb.toString();
    }
}
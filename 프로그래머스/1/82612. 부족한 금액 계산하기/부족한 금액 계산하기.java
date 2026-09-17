class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        while(count > 0) {
            answer += (count * price);
            count--;
        }

        return (answer - money < 0 ? 0 : answer - money);
    }
}
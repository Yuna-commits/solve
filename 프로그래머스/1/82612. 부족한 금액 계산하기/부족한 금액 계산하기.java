class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        
        while(count > 0) {
            answer -= (count * price);
            count--;
        }

        return (answer > 0 ? 0 : -answer);
    }
}
class Solution {
    // 소수 판정
    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) {
                return false;
            }
        }
        return true;
    }
    
    // 재귀
    private int recursive(int[] nums, int start, int sum, int depth) {
        if(depth == 3) {
            return isPrime(sum) ? 1 : 0;
        }
        int answer = 0;
        for(int i=start; i<nums.length; i++) {
            answer += recursive(nums, i + 1, sum + nums[i], depth + 1);
        }
        return answer;
    }
    
    public int solution(int[] nums) {
        return recursive(nums, 0, 0, 0);
    }
}
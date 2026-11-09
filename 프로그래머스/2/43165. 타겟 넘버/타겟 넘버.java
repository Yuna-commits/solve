class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int total) {
        if(idx == numbers.length) {
            return total == target ? 1 : 0;
        }
        return dfs(numbers, target, idx+1, total + numbers[idx]) 
            + dfs(numbers, target, idx+1, total - numbers[idx]);
    }
}
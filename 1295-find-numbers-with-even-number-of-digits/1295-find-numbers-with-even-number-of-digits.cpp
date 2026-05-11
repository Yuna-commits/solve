class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int answer = 0;
        
        for(int num : nums) {
            int cnt = 0;
            
            while(num > 0) {
                num/=10;
                cnt++;
            }
            
            if(!(cnt&1)) {
                answer++;
            }
        }
        return answer;
    }
};
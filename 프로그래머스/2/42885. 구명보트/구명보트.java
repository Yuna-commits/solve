import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        
        while(left<=right) {
            // 두 명이 함께 탈 수 있는 경우
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            } 
            // 두 명이 함께 탈 수 없는 경우 -> 무거운 사람만 혼자
            else {
                right--;
            }
            answer++;
        }
        
        return answer;
    }
}
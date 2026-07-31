#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int left, int right) {
    int answer = 0;
    for(int num = left; num <= right; num++) {
        int cnt = 0;
        for(int i = 1; i <= sqrt(num); i++) {
            if(num % i == 0) {
                cnt += (i * i == num ? 1 : 2);
            }
        }
        answer += (cnt % 2 ? -1 * num : num);
    }
    return answer;
}
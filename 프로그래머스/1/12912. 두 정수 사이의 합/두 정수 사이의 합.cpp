#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    for(int n = min(a, b); n <= max(a,b); n++) {
        answer += n;
    }
    return answer;
}
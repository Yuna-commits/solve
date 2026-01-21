#include <cmath>
#include <set>

using namespace std;

int solution(int n) {
    set<int> s;
    for(int i=1;i<=sqrt(n);i++) {
        if(n%i==0) {
            s.insert(i);
            s.insert(n/i);
        }
    }
    set<int>::iterator iter;
    int answer = 0;
    for(iter=s.begin();iter!=s.end();iter++) {
        answer += (*iter);
    }
    return answer;
}
#include <cmath>
#include <set>

using namespace std;

int solution(int n) {
    // n=1이면 answer=2, n=4이면 answer=9가 나온다.
    // answer에 i와 n/i를 한번에 더하면 (1, 1), (1, 2, 2, 4)로 중복된 값이 합해진다.
    // set을 사용해서 중복된 값을 없앤다.
    set<int> s;
    set<int>::iterator iter;

    int answer = 0;
    
    for(int i=1;i<=sqrt(n);i++) {
        if(n%i==0) {
            s.insert(i);
            s.insert(n/i);
        }
    }
    
    for(iter=s.begin();iter!=s.end();iter++) {
        answer += (*iter);
    }
    
    return answer;
}

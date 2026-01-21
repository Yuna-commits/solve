#include <cmath>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> v;
    
    while(n>0) {
        v.push_back(n%10);
        n/=10;
    }
    
    sort(v.begin(), v.end());
    
    while(!v.empty()) {
        answer += (v.back()) * pow(10, v.size()-1);
        v.pop_back();
    }
    
    return answer;
}
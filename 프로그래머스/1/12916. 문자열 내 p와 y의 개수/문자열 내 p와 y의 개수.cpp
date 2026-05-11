#include <string>
#include <algorithm>

using namespace std;

bool solution(string s)
{
    bool answer = true;

    int p = count_if(s.begin(), s.end(), [](char ch) {
        return ch == 'p' || ch == 'P';
    });
    
    int y = count_if(s.begin(), s.end(), [](char ch) {
        return ch == 'y' || ch =='Y';
    });
    
    if(p != y) {
        return false;
    }
    
    return answer;
}
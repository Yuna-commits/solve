#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int center = s.length()/2;
    string answer = string(1, s[center]);
    
    return (s.length()&1 ? answer : string(1, s[center-1]).append(answer));
}
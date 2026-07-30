#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int center = s.length()/2;

    return (s.length()&1 ? s.substr(center, 1) : s.substr(center-1, 2));
}
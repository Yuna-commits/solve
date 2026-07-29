#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    int index = min_element(arr.begin(), arr.end()) - arr.begin();
    arr.erase(arr.begin() + index);
    if(arr.size() == 0) {
        arr.push_back(-1);
    }
    return arr;
}
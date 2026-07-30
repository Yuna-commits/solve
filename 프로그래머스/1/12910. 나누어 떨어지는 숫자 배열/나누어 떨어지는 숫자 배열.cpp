#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr, int divisor) {
    for(auto it=arr.begin(); it!=arr.end();) {
        if((*it)%divisor != 0) {
            it = arr.erase(it);
        } else {
            it++;
        }
    }
    
    sort(arr.begin(), arr.end());
    
    if(arr.empty()) {
        arr.push_back(-1);
    }
    
    return arr;
}
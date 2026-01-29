#include <cmath>
#include <iostream>

using namespace std;

long long solution(long long n) {
    // n = 3 
    // -> (int)sqrt(3) = 1
    // -> sqrt(3) = 1.73205
    if((int)sqrt(n) == sqrt(n)) {
        return pow(sqrt(n) + 1, 2);
    }
    return -1;
}
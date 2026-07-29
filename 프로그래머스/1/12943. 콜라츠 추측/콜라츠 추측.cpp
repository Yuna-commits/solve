#include <string>
#include <vector>

using namespace std;

long solution(int num) {
    long tmp = num;
    for(int i=0; i<500; i++) {
        if(tmp == 1) {
            return i;
        }
        tmp = (tmp & 1 ? (tmp * 3 + 1) : tmp / 2);
    }
    return -1;
}
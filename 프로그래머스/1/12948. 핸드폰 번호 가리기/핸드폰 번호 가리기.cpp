#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string phone_number) {
    for(auto i = 0; i<phone_number.length() - 4; i++) {
        phone_number.replace(i, 1, "*");
    }
    return phone_number;
}
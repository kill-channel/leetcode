#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool canJump(vector<int> &nums) {
        int start = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > start)
                return false;
            start = max(start, i + nums[i]);
        }
        return true;
    }
};

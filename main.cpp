#include <iostream>
#include<string>
#include <vector>

using namespace std;

class Solution {
private:
    int number;
    string res;

    void backword(string ans, vector<int> nums) {
        if (--number == 0) {
            res = ans;
            return;
        }
        for(int i = 0;i < nums.size();i ++){
            ans += nums[i];
        }
    }

public:
    string getPermutation(int n, int k) {
        number = k;
        vector<int> nums(n);
        string ans = "";
        for (int i = 0; i < nums.size(); i++) {
            nums[i] = i + 1;
        }
        backword(ans, nums);
        return res;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

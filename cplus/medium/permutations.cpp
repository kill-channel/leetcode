#include <iostream>
#include <vector>

using namespace std;

class Solution {
private:
    vector<vector<int>> ans;

    bool isElementInVector(vector<int> nums, int element) {
        vector<int>::iterator it;
        it = find(nums.begin(), nums.end(), element);
        return it != nums.end();

    }

    void backword(vector<int> &nums, vector<int> temp) {
        if (temp.size() == nums.size()) {
            ans.push_back(temp);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (not isElementInVector(temp, nums[i])) {
                temp.push_back(nums[i]);
                backword(nums, temp);
                temp.pop_back();
            }
        }
    }

public:
    vector<vector<int>> permute(vector<int> &nums) {
        vector<int> temp;
        backword(nums, temp);
        return ans;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

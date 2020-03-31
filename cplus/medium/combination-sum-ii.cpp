#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
        private:
        vector<vector<int>> res;

        void backword(vector<int> &candidates, int target, vector<int> temp, int start) {
            if (target == 0) {
                res.push_back(temp);
                return;
            }
            for (int i = start; i < candidates.size(); i++) {
                if (i > start && candidates[i - 1] == candidates[i])
                    continue;
                if (target >= candidates[i]) {
                    temp.push_back(candidates[i]);
                    backword(candidates, target - candidates[i], temp, i + 1);
                    temp.pop_back();
                }
            }

        }

        public:
        vector<vector<int>> combinationSum2(vector<int> &candidates, int target) {
            vector<int> temp;
            sort(candidates.begin(), candidates.end());
            backword(candidates, target, temp, 0);
            return res;
        }
};
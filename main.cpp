#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int left = 0, right = n - 1, up = 0, low = n - 1;
        int current = 1;
        vector<vector<int>> ans;
        while (true) {
            for (int i = left; i <= right; i++)
                ans[i][up] = current++;
            if (++up >= low)
                return ans;

            for (int i = up; i <= low; i++)
                ans[right][i] = current++;
            if (--right <= left)
                return ans;

            for (int i = right; i >= left; i--)
                ans[i][low] = current++;
            if (--low <= up)
                return ans;

            for (int i = low; i >= up; i--)
                ans[i][left] = current++;
            if (++left >= right)
                return ans;
        }
    }
};
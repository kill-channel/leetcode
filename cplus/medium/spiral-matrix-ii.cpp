#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int left = 0, right = n - 1, up = 0, low = n - 1;
        int current = 1;
        vector<vector<int>> ans(n, vector<int>(n));;
        while (true) {
            for (int i = left; i <= right; i++)
                ans[up][i] = current++;
            if (++up > low)
                return ans;

            for (int i = up; i <= low; i++)
                ans[i][right] = current++;
            if (--right < left)
                return ans;

            for (int i = right; i >= left; i--)
                ans[low][i] = current++;
            if (--low < up)
                return ans;

            for (int i = low; i >= up; i--)
                ans[i][left] = current++;
            if (++left > right)
                return ans;
        }
    }
};
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        vector<int> ans;
        if (matrix.empty())
            return ans;
        int upperBound = 0;
        int bottomBound = matrix.size() - 1;
        int rightBound = matrix[0].size() - 1;
        int leftBound = 0;

        while (true) {
            for (int i = leftBound; i <= rightBound; i++)
                ans.push_back(matrix[upperBound][i]);
            if(++upperBound > bottomBound)
                return ans;
            for(int i = upperBound;i <= bottomBound;i++)
                ans.push_back(matrix[i][rightBound]);
            if(--rightBound < leftBound)
                return ans;
            for(int i = rightBound;i >= leftBound;i --)
                ans.push_back(matrix[bottomBound][i]);
            if(--bottomBound < upperBound)
                return ans;
            for(int i = bottomBound;i >= upperBound;i --)
                ans.push_back(matrix[i][leftBound]);
            if(++leftBound > rightBound)
                return ans;
        }
    }
};

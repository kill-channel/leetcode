#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    bool isValidSudoku(vector<vector<char>> &board) {
        int xsp[9][9] = {0};
        int ysp[9][9] = {0};
        int zsp[9][9] = {0};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (++xsp[board[i][j] - '1'][i] > 1)
                    return false;
                if (++ysp[board[i][j] - '1'][j] > 1)
                    return false;
                if (++zsp[board[i][j] - '1'][(i / 3) * 3 + j / 3] > 1)
                    return false;
            }
        }
        return true;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

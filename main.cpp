#include <iostream>
#include <vector>

using namespace std;
static int a[101][101] = {0};

class Solution {
private:
    vector<vector<int>> &grid;

    int dfs(int x, int y) {
        if (grid[x][y] == 1)
            return 0;
        if (x == 1 || y == 1)
            return 1;
        if (x == 2)
            return y;
        if (y == 2)
            return x;

        if (a[x][y] > 0)
            return a[x][y];
        a[x - 1][y] = dfs(x - 1, y);
        a[x][y - 1] = dfs(x, y - 1);
        a[x][y] = a[x - 1][y] + a[x][y - 1];
        return a[x][y];
    }

public:
    int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        grid = obstacleGrid;
        return dfs(obstacleGrid.size(), obstacleGrid[0].size());
    }
};
//leetcode submit region end(Prohibit modification and deletion)

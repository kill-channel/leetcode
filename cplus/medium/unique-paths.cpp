#include <iostream>
#include <vector>

using namespace std;
static int a[101][101] = {0};

class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (m == 2)
            return n;
        if (n == 2)
            return m;

        if (a[m][n] > 0)
            return a[m][n];

        a[m - 1][n] = uniquePaths(m - 1, n);
        a[n][m - 1] = a[m - 1][n];
        a[m][n - 1] = uniquePaths(m, n - 1);
        a[n - 1][m] = a[m][n - 1];

        a[m][n] = a[m - 1][n] + a[m][n - 1];
        return a[m][n];
    }
};
//leetcode submit region end(Prohibit modification and deletion)

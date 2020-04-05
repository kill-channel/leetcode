class Solution {
public:
    string getPermutation(int n, int k) {
        string s(n, '0');
        string result;
        for (int i = 0; i < n; i++) {
            s[i] += i + 1;
        }
        return kth_permutation(s, k);
    }

private:
    int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    string kth_permutation(string &s, int k) {
        const int n = s.size();
        string result;

        int base = factorial(n - 1);
        --k;
        for (int i = n - 1; i > 0; k = k % base, base /= i, --i) {
            auto a = s.begin() + k / base;
            result.push_back(*a);
            s.erase(a);
        }
        result.push_back(s[0]);
        return result;
    }
};

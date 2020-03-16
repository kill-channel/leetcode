//Given a string s, find the longest palindromic substring in s. You may assume
//that the maximum length of s is 1000.
//
// Example 1:
//
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
//Input: "cbbd"
//Output: "bb"
//
// Related Topics String Dynamic Programming


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int i = 0;
        while (i < s.length()) {
            int left = i;
            int right = i;
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1))
                right += 1;
            i = right + 1;
            String ans = findLongestSubstring(s, left, right);
            if (ans.length() > result.length())
                result = ans;
        }
        return result;
    }

    private String findLongestSubstring(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1;
            right += 1;
        }
        return s.substring(left + 1, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

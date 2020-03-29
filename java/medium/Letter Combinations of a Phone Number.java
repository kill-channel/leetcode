//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given b
//elow. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be i
//n any order you want.
// Related Topics String Backtracking


import com.sun.tools.javac.util.List;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final char[][] map = {
            {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    private List<String> ans = new ArrayList<>();

    private void backtrack(String digits, StringBuilder string, int index) {
        if (index == digits.length())
            ans.add(string.toString());
        else {
            int current = Character.getNumericValue(digits.charAt(index));
            for (char ch : map[current]) {
                string.append(ch);
                backtrack(digits, string, index + 1);
                string.deleteCharAt(string.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0)
            backtrack(digits, new StringBuilder(), 0);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

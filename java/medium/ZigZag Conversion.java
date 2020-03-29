//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
//f rows like this: (you may want to display this pattern in a fixed font for bett
//er legibility)
//
//
//P   A   H   N
//A P L S I I G
//Y   I   R
//
//
// And then read line by line: "PAHNAPLSIIGYIR"
//
// Write the code that will take a string and make this conversion given a numbe
//r of rows:
//
//
//string convert(string s, int numRows);
//
// Example 1:
//
//
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
//
//
// Example 2:
//
//
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// Related Topics String


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<List<Character>> charrows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            charrows.add(new ArrayList<>());
        }
        int maxRow = charrows.size() - 1, minRow = 0, curRow = 0;
        boolean sign = true;
        for (int i = 0; i < s.length(); i++) {
            charrows.get(curRow).add(s.charAt(i));
            sign = curRow == maxRow ? false : curRow == minRow ? true : sign;
            curRow += sign ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character>chars : charrows){
            for (Character c : chars){
                sb.append(c.charValue());
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

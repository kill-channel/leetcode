//Given a string, find the length of the longest substring without repeating cha
//racters.
//
//
// Example 1:
//
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//
//
//
// Example 2:
//
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence
// and not a substring.
//
//
//
//
// Related Topics Hash Table Two Pointers String Sliding Window


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0,maxLength = 0;
        HashMap<Character,Integer>hashmap = new HashMap<>();
        for(int i = 0;i < s.length();i ++){
            Character ch = s.charAt(i);
            if(hashmap.containsKey(ch) && start <= hashmap.get(ch)){
                start = hashmap.get(ch) + 1;
            }
            else{
                maxLength = Math.max(maxLength,i-start+1);
            }
            hashmap.put(ch,i);
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

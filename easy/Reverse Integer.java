//Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
//
//Input: 123
//Output: 321
//
//
// Example 2:
//
//
//Input: -123
//Output: -321
//
//
// Example 3:
//
//
//Input: 120
//Output: 21
//
//
// Note:
//Assume we are dealing with an environment which could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this pro
//blem, assume that your function returns 0 when the reversed integer overflows.
// Related Topics Math


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long sum = 0;
        do{
            int current = x % 10;
            sum = sum * 10 + current;
            x /= 10;
            if(sum<Integer.MIN_VALUE || sum>Integer.MAX_VALUE){
                return 0;
            }
        }while (x != 0);
        return (int)sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

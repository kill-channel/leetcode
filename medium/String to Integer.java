class Solution {
    public int myAtoi(String str) {
        char sign = '+';
        long val = 0;
        int signFlag = 0;
        int numFlag = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') {
                if (numFlag == 1)   break;
                if (signFlag == 1) break;
                else    continue;
            }
            else if (ch == '.') break;
            else if (ch == '-' || ch == '+') {
                ++signFlag;
                if (numFlag == 1)   break;
                if (signFlag == 2)
                    break;
                sign = ch;
            }
            else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') break;
            else {
                int num = Integer.parseInt(String.valueOf(ch));
                if (num >=0 && num <= 9)
                    val = val * 10 + num;
                numFlag = 1;
            }
            if (val > Integer.MAX_VALUE) {
                if (sign == '-')
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
        }

        if (sign == '-')
            val = -1 * val;

        return (int)val;
    }
}
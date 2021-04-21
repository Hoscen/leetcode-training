package cn.hoscen.demo.leetcode.toLowerCase;

/**
 * Description:709. 转换成小写字母
 * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 * <p>
 * <p>
 * Created by Hoscen on 2021/3/27 23:31 with IntelliJ IDEA.
 */
public class Solution {

    /**
     * 1、Java api
     */
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.toLowerCase();
    }

    /**
     * 方法2：ASCII码
     * 思路：
     * 通过 ASCII 码表操作字符串即可。
     * a-z：97-122
     * A-Z：65-90
     * 0-9：48-57
     */
    public String toLowerCase2(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 方法3：位运算
     * 思路：
     * 用位运算的技巧：
     * <p>
     * 大写变小写、小写变大写：字符 ^= 32;
     * 大写变小写、小写变小写：字符 |= 32;
     * 大写变大写、小写变大写：字符 &= -33;
     * SCII码表中大写的A是65，小写的a是97，它们的差是32
     * 65 | 32 转为二进制（按8位来算）可以得到 0100 0001 | 0010 0000 = 0110 0001 = 97 = a
     */
    public String toLowerCase3(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0, len = chars.length; i < len; i++) {
            chars[i] |= 32;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("abcAdsDC")); // abcadsdc
        System.out.println(solution.toLowerCase2("abcAdsDC")); // abcadsdc
        System.out.println(solution.toLowerCase3("abcAdsDC")); // abcadsdc
    }
}

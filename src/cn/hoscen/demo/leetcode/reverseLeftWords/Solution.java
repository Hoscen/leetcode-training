package cn.hoscen.demo.leetcode.reverseLeftWords;

/**
 * Description:
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * Created by Hoscen on 2021/3/27 15:48 with IntelliJ IDEA.
 */
public class Solution {

    /**
     * 1、字符串切片 我们最容易想到的解决方案
     */
    public String reverseLeftWords(String s, int n) {
        validParam(s, n);
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * 2、列表遍历拼接
     */
    public String reverseLeftWords2(String s, int n) {
        validParam(s, n);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n, len = s.length(); i < len; i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**
     * 3、字符串遍历拼接
     */
    public String reverseLeftWords3(String s, int n) {
        validParam(s, n);
        String str = "";
        for (int i = n, len = s.length(); i < len; i++) {
            str += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            str += s.charAt(i);
        }
        return str;
    }

    private void validParam(String s, int n) {
        // 限制 1 <= k < s.length <= 10000
        if (s == null || n < 1 || n >= s.length() || n > 10000) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverseLeftWords("abcdefg", 2));
        System.out.println(solution.reverseLeftWords("lrloseumgh", 6));

        System.out.println(solution.reverseLeftWords2("abcdefg", 2));
        System.out.println(solution.reverseLeftWords2("lrloseumgh", 6));

        System.out.println(solution.reverseLeftWords3("abcdefg", 2));
        System.out.println(solution.reverseLeftWords3("lrloseumgh", 6));

    }
}

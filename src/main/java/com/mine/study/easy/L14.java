package com.mine.study.easy;

/**
 * <h6>最长公共前缀</h6>
 *
 * <p>编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。</p>
 *
 * <pre>
 * Input: ["flower","flow","flight"]；Output: "fl"
 * Input: ["dog","racecar","car"]；Output: ""；Explanation: 输入不存在公共前缀。
 * </pre>
 */
public class L14 {

    public String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length == 0)) {
            return "";
        }
        for (int i = 0, length = strs[0].length(); i < length; i++) {
            char currentChar = strs[0].charAt(i);
            for (int j = 1, len = strs.length; j < len; j++) {         // 比较每个字符串相应位置上的值
                if ((strs[j].length() == i) || (currentChar != strs[j].charAt(i))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

package com.mine.study.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * #### 13. 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符:`I`，`V`，`X`，`L`，`C`，`D`和`M`。
 * <p>
 * ```
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ```
 * <p>
 * 例如， 罗马数字 2 写做`II`，即为两个并列的 1。12 写做XII，即为`X`+`II`。 27 写做`XXVII`, 即为`XX`+`V`+`II`。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做`IIII`，而是`IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为`IX`。这个特殊的规则只适用于以下六种情况：
 * <p>
 * - `I`可以放在`V`(5) 和`X`(10) 的左边，来表示 4 和 9。
 * - `X`可以放在`L`(50) 和`C`(100) 的左边，来表示 40 和90。
 * - `C`可以放在`D`(500) 和`M`(1000) 的左边，来表示400 和900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 * <p>
 * **示例1:**
 * <p>
 * ```
 * 输入:"III"
 * 输出: 3
 * ```
 * <p>
 * **示例2:**
 * <p>
 * ```
 * 输入:"IV"
 * 输出: 4
 * ```
 * <p>
 * **示例3:**
 * <p>
 * ```
 * 输入:"IX"
 * 输出: 9
 * ```
 * <p>
 * **示例4:**
 * <p>
 * ```
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * ```
 * <p>
 * **示例5:**
 * <p>
 * ```
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * ```
 */
public class L13 {
    // 解法1：使用Map
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = 0;
        int preNum = map.get(s.charAt(0));
        for (int i = 1, length = s.length(); i < length; i++) {
            int num = map.get(s.charAt(i));
            if (preNum < num) { // 左边的数字小于右边的数字
                ret = -preNum;
            } else { // 左边的数字大于等于右边的数字
                ret += preNum;
            }
            preNum = num;
        }
        return ret;
    }

    // 解法2
    public int romanToInt2(String s) {
        int ret = 0;
        int preNum = getValue(s.charAt(0));

        for (int i = 1, length = s.length(); i < length; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) { // 左边的数字小于右边的数字
                ret = -preNum;
            } else { // 左边的数字大于等于右边的数字
                ret += preNum;
            }
            preNum = num;
        }
        return ret;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

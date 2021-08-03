package com.shuzijun.leetcode.editor.cn;

/**
 * <p>给你一个只包含 <code>'('</code> 和 <code>')'</code> 的字符串，找出最长有效（格式正确且连续）括号子串的长度。</p>
 *
 * <p> </p>
 *
 * <div class="original__bRMd">
 * <div>
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = "(()"
 * <strong>输出：</strong>2
 * <strong>解释：</strong>最长有效括号子串是 "()"
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = ")()())"
 * <strong>输出：</strong>4
 * <strong>解释：</strong>最长有效括号子串是 "()()"
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>s = ""
 * <strong>输出：</strong>0
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 <= s.length <= 3 * 10<sup>4</sup></code></li>
 * <li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li>
 * </ul>
 * </div>
 * </div>
 * <div><div>Related Topics</div><div><li>栈</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 1391</li><li>👎 0</li></div>
 */

public class Q32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Q32LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(()"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int maxLen = 0;
            int len = 0;
            int stack = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack = stack + 1;
                } else {
                    if (stack < 1) {
                        if (len > maxLen) {
                            maxLen = len;
                        }
                        if (len > maxLen) {
                            maxLen = len;
                        }
                        stack = 0;
                        len = 0;
                    } else {
                        stack = stack - 1;
                        len = len + 2;
                        if (len > maxLen && stack == 0) {
                            maxLen = len;
                        }
                    }
                }
            }
                if (len > maxLen && stack == 0) {
                maxLen = len;
            }
            stack = 0;
            len = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ')') {
                    stack = stack + 1;
                } else {
                    if (stack < 1) {
                        if (len > maxLen) {
                            maxLen = len;
                        }
                        if (len > maxLen) {
                            maxLen = len;
                        }
                        stack = 0;
                        len = 0;
                    } else {
                        stack = stack - 1;
                        len = len + 2;
                        if (len > maxLen && stack == 0) {
                            maxLen = len;
                        }
                    }
                }
            }
            if (len > maxLen && stack == 0) {
                maxLen = len;
            }

            return maxLen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
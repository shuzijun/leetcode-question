package com.shuzijun.leetcode.editor.cn;

/**
 * <p>给定两个以字符串形式表示的非负整数&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>，返回&nbsp;<code>num1</code>&nbsp;和&nbsp;<code>num2</code>&nbsp;的乘积，它们的乘积也表示为字符串形式。</p>
 *
 * <p><strong>注意：</strong>不能使用任何内置的 BigInteger 库或直接将输入转换为整数。</p>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>示例 1:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> num1 = "2", num2 = "3"
 * <strong>输出:</strong> "6"</pre>
 *
 * <p><strong>示例&nbsp;2:</strong></p>
 *
 * <pre>
 * <strong>输入:</strong> num1 = "123", num2 = "456"
 * <strong>输出:</strong> "56088"</pre>
 *
 * <p>&nbsp;</p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 &lt;= num1.length, num2.length &lt;= 200</code></li>
 * <li><code>num1</code>&nbsp;和 <code>num2</code>&nbsp;只能由数字组成。</li>
 * <li><code>num1</code>&nbsp;和 <code>num2</code>&nbsp;都不包含任何前导零，除了数字0本身。</li>
 * </ul>
 *
 * <div><div>Related Topics</div><div><li>数学</li><li>字符串</li><li>模拟</li></div></div><br><div><li>👍 950</li><li>👎 0</li></div>
 */
public class Q43MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new Q43MultiplyStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String ans = "0";
            int m = num1.length(), n = num2.length();
            for (int i = n - 1; i >= 0; i--) {
                StringBuffer curr = new StringBuffer();
                int add = 0;
                for (int j = n - 1; j > i; j--) {
                    curr.append(0);
                }
                int y = num2.charAt(i) - '0';
                for (int j = m - 1; j >= 0; j--) {
                    int x = num1.charAt(j) - '0';
                    int product = x * y + add;
                    curr.append(product % 10);
                    add = product / 10;
                }
                if (add != 0) {
                    curr.append(add % 10);
                }
                ans = add(ans, curr.reverse().toString());
            }
            return ans;
        }

        public String add(String num1, String num2) {
            int l1 = num1.length() - 1, l2 = num2.length() - 1, add = 0;
            StringBuilder ans = new StringBuilder();
            while (l1 >= 0 || l2 >= 0 || add != 0) {
                int x = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
                int y = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
                int result = x + y + add;
                ans.append(result % 10);
                add = result / 10;
                l1--;
                l2--;
            }
            ans.reverse();
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
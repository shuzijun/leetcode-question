package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

/**
 * <p>实现获取 <strong>下一个排列</strong> 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。</p>
 *
 * <p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。</p>
 *
 * <p>必须<strong><a href="https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95" target="_blank"> 原地 </a></strong>修改，只允许使用额外常数空间。</p>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,2,3]
 * <strong>输出：</strong>[1,3,2]
 * </pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [3,2,1]
 * <strong>输出：</strong>[1,2,3]
 * </pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1,1,5]
 * <strong>输出：</strong>[1,5,1]
 * </pre>
 *
 * <p><strong>示例 4：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [1]
 * <strong>输出：</strong>[1]
 * </pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>1 <= nums.length <= 100</code></li>
 * <li><code>0 <= nums[i] <= 100</code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>双指针</li></div></div><br><div><li>👍 1247</li><li>👎 0</li></div>
 */

public class Q31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Q31NextPermutation().new Solution();
        int[] nums = new int[]{2,3,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // [4,5,2,6,3,1]
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
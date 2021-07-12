package com.shuzijun.leetcode.editor.cn;

import java.util.Arrays;

/**
 * <p>给定一个按照升序排列的整数数组 <code>nums</code>，和一个目标值 <code>target</code>。找出给定目标值在数组中的开始位置和结束位置。</p>
 *
 * <p>如果数组中不存在目标值 <code>target</code>，返回 <code>[-1, -1]</code>。</p>
 *
 * <p><strong>进阶：</strong></p>
 *
 * <ul>
 * <li>你可以设计并实现时间复杂度为 <code>O(log n)</code> 的算法解决此问题吗？</li>
 * </ul>
 *
 * <p> </p>
 *
 * <p><strong>示例 1：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<code>5,7,7,8,8,10]</code>, target = 8
 * <strong>输出：</strong>[3,4]</pre>
 *
 * <p><strong>示例 2：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [<code>5,7,7,8,8,10]</code>, target = 6
 * <strong>输出：</strong>[-1,-1]</pre>
 *
 * <p><strong>示例 3：</strong></p>
 *
 * <pre>
 * <strong>输入：</strong>nums = [], target = 0
 * <strong>输出：</strong>[-1,-1]</pre>
 *
 * <p> </p>
 *
 * <p><strong>提示：</strong></p>
 *
 * <ul>
 * <li><code>0 <= nums.length <= 10<sup>5</sup></code></li>
 * <li><code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code></li>
 * <li><code>nums</code> 是一个非递减数组</li>
 * <li><code>-10<sup>9</sup> <= target <= 10<sup>9</sup></code></li>
 * </ul>
 * <div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 1098</li><li>👎 0</li></div>
 */

public class Q34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Q34FindFirstAndLastPositionOfElementInSortedArray.Solution solution = new Q34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 6;
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;

            if (len == 0 || target < nums[0] || target > nums[len - 1]) {
                return new int[]{-1, -1};
            }
            if (len == 1) {
                if (nums[0] == target) {
                    return new int[]{0, 0};
                } else {
                    return new int[]{-1, -1};
                }
            }
            return binarySearch(nums, 0, len - 1, target);
        }

        private int[] binarySearch(int[] nums, int start, int end, int target) {
            int binary = (start + end + 1) / 2;
            if (nums[binary] == target) {
                int[] ans = {binary, binary};
                while ((ans[0] - 1) >= start) {
                    if (nums[ans[0] - 1] == target) {
                        ans[0] = ans[0] - 1;
                    } else {
                        break;
                    }
                }
                while ((ans[1] + 1) <= end) {
                    if (nums[ans[1] + 1] == target) {
                        ans[1] = ans[1] + 1;
                    } else {
                        break;
                    }
                }
                return ans;
            } else if (nums[binary] > target && (binary - 1) >= start) {
                return binarySearch(nums, start, binary - 1, target);
            } else if (nums[binary] < target && (binary + 1) <= end) {
                return binarySearch(nums, binary, end, target);
            } else {
                return new int[]{-1, -1};
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
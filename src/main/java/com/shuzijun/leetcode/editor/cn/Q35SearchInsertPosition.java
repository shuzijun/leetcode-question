package com.shuzijun.leetcode.editor.cn;
/**
<p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。</p>

<p>你可以假设数组中无重复元素。</p>

<p><strong>示例 1:</strong></p>

<pre><strong>输入:</strong> [1,3,5,6], 5
<strong>输出:</strong> 2
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre><strong>输入:</strong> [1,3,5,6], 2
<strong>输出:</strong> 1
</pre>

<p><strong>示例 3:</strong></p>

<pre><strong>输入:</strong> [1,3,5,6], 7
<strong>输出:</strong> 4
</pre>

<p><strong>示例 4:</strong></p>

<pre><strong>输入:</strong> [1,3,5,6], 0
<strong>输出:</strong> 0
</pre>
<div><div>Related Topics</div><div><li>数组</li><li>二分查找</li></div></div><br><div><li>👍 963</li><li>👎 0</li></div>
*/
  
public class Q35SearchInsertPosition{
  public static void main(String[] args) {
       Solution solution = new Q35SearchInsertPosition().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public int searchInsert(int[] nums, int target) {
          int len = nums.length;

          if (len == 0 || target < nums[0]) {
              return 0;
          } else if (target > nums[len - 1]) {
              return len;
          }
          return binarySearch(nums, 0, len - 1, target);
      }

      private int binarySearch(int[] nums, int start, int end, int target) {
          int binary = (start + end + 1) / 2;
          if (nums[binary] == target) {
              return binary;
          } else if (nums[binary] > target && (binary - 1) >= start) {
              if (nums[binary - 1] < target) {
                  return binary;
              } else if (nums[binary - 1] == target) {
                  return binary - 1;
              }
              return binarySearch(nums, start, binary - 1, target);
          } else if (nums[binary] < target && (binary + 1) <= end) {
              if (nums[binary + 1] >= target) {
                  return binary + 1;
              }
              return binarySearch(nums, binary, end, target);
          } else {
              return binary;
          }
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}
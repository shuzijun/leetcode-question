//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
//
// You are given a target value to search. If found in the array return its index, otherwise return -1. 
//
// You may assume no duplicate exists in the array. 
//
// Your algorithm's runtime complexity must be in the order of O(log n). 
//
// Example 1: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1 
//

package com.shuzijun.leetcode.editor.en;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution.search(nums, 0));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length <= 0) return -1;
            if (nums.length == 1 && nums[0] == target) return 0;
            int s = 0;
            int e = nums.length - 1;
            while (s <= e) {
                int m = (s + e) / 2;
                if (nums[m] == target) {
                    return m;
                }
                if (nums[m] < nums[e]) {
                    if (nums[m] < target && nums[e] >= target) {
                        s = m + 1;
                    } else {
                        e = m - 1;
                    }
                } else {
                    if (nums[s] <= target && nums[m] > target) {
                        e = m - 1;
                    } else {
                        s = m + 1;

                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

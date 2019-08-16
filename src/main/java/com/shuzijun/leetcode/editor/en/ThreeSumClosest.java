//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution. 
//
// Example: 
//
// 
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// 
//

package com.shuzijun.leetcode.editor.en;

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
         Solution solution = new ThreeSumClosest().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int retunrn = nums[0] + nums[1] + nums[2];
        int derta = Math.abs(retunrn - target);

        for (int i = 0, j = nums.length; i <= j - 3; i++) {
           /* if (nums[i] >= target) {
                return Math.abs(nums[i] + nums[i + 1] + nums[i + 2] - target) > derta ? retunrn : nums[i] + nums[i + 1] + nums[i + 2];
            }*/
            int s = i + 1;
            int e = j - 1;
            while (s < e) {
                int temp = nums[i] + nums[s] + nums[e];
                if (temp > target) {
                    e--;
                } else if (temp < target) {
                    s++;
                } else {
                    return target;
                }
                if (Math.abs(temp - target) < derta) {
                    retunrn = temp;
                    derta = Math.abs(temp - target);
                }
            }

        }

        return retunrn;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

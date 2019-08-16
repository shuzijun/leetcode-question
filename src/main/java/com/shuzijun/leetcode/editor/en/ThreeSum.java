//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. 
//
// Note: 
//
// The solution set must not contain duplicate triplets. 
//
// Example: 
//
// 
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
//

package com.shuzijun.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> returnList = new ArrayList<List<Integer>>();

            for (int i = 0, j = nums.length; i < j; i++) {
                if (nums[i] > 0) {
                    return returnList;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target = 0 - nums[i];
                int s = i + 1, e = j - 1;
                while (s < e) {
                    if (nums[s] + nums[e] < target) {
                        s++;
                    } else if (nums[s] + nums[e] > target) {
                        e--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[s], nums[e]);
                        returnList.add(list);
                        while (s < e) {
                            if (nums[s] == nums[s + 1]) {
                                s++;
                            } else {
                                break;
                            }
                        }
                        while (s < e) {
                            if (nums[e] == nums[e - 1]) {
                                e--;
                            } else {
                                break;
                            }
                        }
                        s++;
                        e--;

                    }
                }
            }

            return returnList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

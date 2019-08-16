//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
//

package com.shuzijun.leetcode.editor.en;

import com.shuzijun.leetcode.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carrying = 0;
            ListNode returnListNode = null;
            ListNode thisListNode = null;
            while (l1 != null || l2 != null || carrying != 0) {
                int val1 = 0;
                int val2 = 0;
                if (l1 != null) {
                    val1 = l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    val2 = l2.val;
                    l2 = l2.next;
                }
                int val = val1 + val2 + carrying;
                if (returnListNode == null) {
                    returnListNode = new ListNode(val % 10);
                    thisListNode = returnListNode;
                } else {
                    ListNode nextListNode = new ListNode(val % 10);
                    thisListNode.next = nextListNode;
                    thisListNode = nextListNode;

                }
                carrying = val / 10;

            }
            return returnListNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

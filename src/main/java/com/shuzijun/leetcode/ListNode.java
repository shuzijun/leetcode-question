package com.shuzijun.leetcode;

/**

 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(val);
        if (next != null) {
            sb.append("->").append(next);
        }
        return sb.toString();
    }
}

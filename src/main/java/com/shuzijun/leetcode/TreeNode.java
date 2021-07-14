package com.shuzijun.leetcode;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/10, 水, 18:07
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

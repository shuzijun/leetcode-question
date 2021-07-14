package com.shuzijun.leetcode;

import java.util.List;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/11, Thu, 1:21
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, List<Node> _children) {
        this.val = _val;
        this.children = _children;
    }
}

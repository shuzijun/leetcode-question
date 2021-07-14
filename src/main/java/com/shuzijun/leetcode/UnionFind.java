package com.shuzijun.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/14, Sun, 14:56
 */
public class UnionFind {
    private int[] roots;

    protected UnionFind(int n) {
        this.roots = IntStream.range(0, n).toArray();
    }

    protected int[] getRoots() {
        return this.roots;
    }

    protected void union(int p, int q) {
        this.roots[this.findRoot(p)] = this.findRoot(q);
    }

    protected void union(int... p) {
        for (int i = 1; i < p.length; i++) {
            this.union(p[i], p[0]);
        }
    }

    protected int findRoot(int i) {
        int root = i;
        while (root != this.roots[root]) {
            root = this.roots[root];
        }
        int t;
        while (i != this.roots[root]) {
            t = this.roots[i];
            this.roots[i] = root;
            i = t;
        }
        return root;
    }

    protected boolean isConnected(int p, int q) {
        return this.findRoot(p) == this.findRoot(q);
    }

    protected int getCount() {
        Set<Integer> rootSet = new HashSet<>();
        Arrays.stream(this.roots).forEach(root -> rootSet.add(this.findRoot(root)));
        return rootSet.size();
    }
}

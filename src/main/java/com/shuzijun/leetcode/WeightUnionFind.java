package com.shuzijun.leetcode;

import java.util.stream.IntStream;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/14, Sun, 14:55
 */
public class WeightUnionFind {

    private int[] parent;

    /**
     * 指向的父结点的权值
     */
    private double[] weight;


    public WeightUnionFind(int n) {
        this.parent = IntStream.range(0, n).toArray();
        this.weight = new double[n];
        IntStream.range(0, n).forEach(i -> this.weight[i] = 1.0d);
    }

    public void union(int x, int y, double value) {
        int rootX = this.find(x);
        int rootY = this.find(y);
        if (rootX == rootY) {
            return;
        }

        this.parent[rootX] = rootY;
        // 关系式的推导请见「参考代码」下方的示意图
        this.weight[rootX] = this.weight[y] * value / this.weight[x];
    }

    /**
     * 路径压缩
     *
     * @param x
     * @return 根结点的 id
     */
    public int find(int x) {
        if (x != this.parent[x]) {
            int origin = this.parent[x];
            this.parent[x] = this.find(this.parent[x]);
            this.weight[x] *= this.weight[origin];
        }
        return this.parent[x];
    }

    public double isConnected(int x, int y) {
        int rootX = this.find(x);
        int rootY = this.find(y);
        if (rootX == rootY) {
            return this.weight[x] / this.weight[y];
        } else {
            return -1.0d;
        }
    }
}

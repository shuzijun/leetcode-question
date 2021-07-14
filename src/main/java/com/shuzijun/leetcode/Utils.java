package com.shuzijun.leetcode;


import com.alibaba.fastjson.JSONArray;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : CAOMU
 * @version : 1.0
 * @since : 2021/02/10, 水, 18:06
 */
public class Utils {
    public static TreeNode arrayToTreeNode(String s) {
        List<Integer> array = Arrays.stream(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")).split(",")).map(i ->
                i.equals("null") ? null : Integer.valueOf(i)
        ).collect(Collectors.toList());
        return list2TreeNode(array);
    }

    public static TreeNode list2TreeNode(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.size(); i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array.get(i) != null) {
                    node.left = new TreeNode(array.get(i));
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array.get(i) != null) {
                    node.right = new TreeNode(array.get(i));
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static int[] stringToArray(String s) {
        return Arrays.stream(s.substring(
                s.indexOf("[") + 1, s.lastIndexOf("]")).split(",")).mapToInt(Integer::valueOf).toArray();
    }

    public static String[] stringToStringArray(String s) {
        return ((JSONArray) JSONArray.parse(s)).toArray(new String[]{});
    }

    public static int[][] stringTo2DArray(String s) {
        JSONArray[] arr = ((JSONArray) JSONArray.parse(s)).toArray(new JSONArray[]{});
        int[][] result = new int[arr.length][Arrays.stream(arr).mapToInt(JSONArray::size).max().orElse(0)];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Arrays.stream(arr[i].toArray()).mapToInt(o -> (int) o).toArray();
            System.out.println(Arrays.toString(result[i]));
        }
        return result;
    }

    public static List<List<String>> stringTo2DStringList(String s) {
        JSONArray[] arr = ((JSONArray) JSONArray.parse(s)).toArray(new JSONArray[]{});
        List<List<String>> result = new ArrayList<>();
        for (JSONArray objects : arr) {
            List<String> list = Arrays.stream(objects.toArray()).map(String::valueOf).collect(Collectors.toList());
            result.add(list);
            System.out.println(list);
        }
        return result;
    }
}

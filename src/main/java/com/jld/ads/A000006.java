package com.jld.ads;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 算法题：BFS
 */
public class A000006 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
    }

    public ArrayList<Integer> bfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
            list.add(temp.value);
        }
        return list;
    }
}

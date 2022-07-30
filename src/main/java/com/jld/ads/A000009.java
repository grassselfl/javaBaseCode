package com.jld.ads;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 算法题：DFS
 */
public class A000009 {

    static class TreeNode {
        int value = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.value = val;
        }
    }

    public ArrayList<Integer> Dfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            //先往栈中压入右节点，再压左节点，出栈就是先左节点后出右节点了(先序遍历推广)。
            if (tree.right != null) stack.push(tree.right);
            if (tree.left != null) stack.push(tree.left);
            list.add(tree.value);
        }
        return list;
    }

    public void DfsRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + "  ");
            DfsRecursive(root.left);
            DfsRecursive(root.right);
        }
    }


    public ArrayList<Integer> Bfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null) queue.offer(tree.left);
            if (tree.right != null) queue.offer(tree.right);
            list.add(tree.value);
        }
        return list;
    }

    //似乎比较复杂
    public void BfsRecursive(TreeNode root) {

    }

    //深度
    public int deep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }

}


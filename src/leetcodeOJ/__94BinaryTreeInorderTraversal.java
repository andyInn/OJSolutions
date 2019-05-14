package leetcodeOJ;

import java.util.*;

public class __94BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root) return list;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list){
        if(null == root) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    public List<Integer> inorderTraversal_Iteratively(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root) return list;

        Stack<TreeNode> treeStack = new Stack<>();
        Map<TreeNode, Boolean> treeMap= new HashMap<>();
        treeMap.put(root, false);
        treeStack.push(root);
        while(!treeStack.isEmpty()){
            TreeNode worker = treeStack.peek();
            while (null != worker.left && ((treeMap.containsKey(worker.left)
                    && false == treeMap.get(worker.left)) || !treeMap.containsKey(worker.left))) {
                treeMap.put(worker.left, false);
                treeStack.push(worker.left);
                worker = worker.left;
            }
            if(!treeMap.get(worker)){
                list.add(worker.val);//visit note
                treeMap.put(worker, true);
            }
            if(null!=worker.right && ((treeMap.containsKey(worker.right)
                    && false == treeMap.get(worker.right)) || !treeMap.containsKey(worker.right))){
                treeMap.put(worker.right, false);
                treeStack.push(worker.right);
            } else {
                treeStack.pop();
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal_suggested(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root.right=root2;
        root2.left=root3;
        List<Integer> list = new __94BinaryTreeInorderTraversal().inorderTraversal_Iteratively(root);
        System.out.println(list);
    }
}

package algorithm;

/**
 * Created by leochou on 2019/10/19.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class RebuildBinary {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // null handle
        if(pre == null || pre.length == 0)
            return null;

        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);

        if(pre.length == 1){
            return root;
        }
        // can not find?
        int index = indexOf(in, rootVal);
        int[] left = new int[index];
        int[] right = new int[in.length - index - 1];
        int[] left_in = new int[index];
        int[] right_in = new int[in.length - index - 1];
        System.arraycopy(in, 0, left_in, 0, index);
        System.arraycopy(in, index + 1, right_in, 0, in.length - index - 1);
        System.arraycopy(pre, 1, left, 0, index);
        System.arraycopy(pre, index + 1, right, 0, in.length - index - 1);
        root.left = reConstructBinaryTree(left, left_in);
        root.right = reConstructBinaryTree(right, right_in);
        return root;
    }

    public static int indexOf(int[] unsort, int target){
        for(int i = 0; i < unsort.length; i++) {
            if(unsort[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,3,5,6}, in = {4,2,1,5,3,6};
        reConstructBinaryTree(pre, in);
    }
}
package will.zhang.UsingTree.BinaryTreePreorderTraversal144;

import will.zhang.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiawei.zhang
 * @date: 2022/2/24
 */
public class Solution {

    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}

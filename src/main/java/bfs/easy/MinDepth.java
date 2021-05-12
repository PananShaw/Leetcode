package bfs.easy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.Queue;

@NoArgsConstructor
@AllArgsConstructor
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

/**
 * @author shaw
 * @describe 111.二叉树的最小深度
 * @date 2021/05/12 10:21
 */
public class MinDepth {

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        TreeNode node1 = new TreeNode(9);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20, node3, node4);
        System.out.println(minDepth.minDepth(new TreeNode(3, node1, node2)));
    }

    public int minDepth(TreeNode root) {
        //判空
        if (root == null) {
            return 0;
        }
        // 核⼼数据结构
        Queue<TreeNode> q = new ArrayDeque<>();
        // 将起点加⼊队列
        q.offer(root);
        // 记录扩散的步数
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 划重点：这⾥判断是否到达终点 */
                assert cur != null;
                if (cur.left == null && cur.right == null) {
                    return step;
                }
                /* 将 cur 的相邻节点加⼊队列 */
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 划重点：更新步数在这⾥
            step++;
        }
        return step;
    }
}

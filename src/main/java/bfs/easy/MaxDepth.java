package bfs.easy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
class Node {
    public int val;
    public List<Node> children;

    public Node(int value) {
        val = value;
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
 * @describe 559.N叉树的最大深度
 * @date 2021/05/12 10:04
 */
public class MaxDepth {
    public static void main(String[] args) {
        List<Node> nodeList = new ArrayList<>();
        //[1,null,3,2,4,null,5,6]
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        nodeList.add(node5);
        nodeList.add(node6);
        Node node2 = new Node(2);
        Node node3 = new Node(3, new ArrayList<>(nodeList));
        Node node4 = new Node(4);
        nodeList.clear();
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        Node root = new Node(1, nodeList);
        System.out.println(new MaxDepth().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        // 核⼼数据结构
        List<Node> prev = new ArrayList<>();
        List<Node> next = new ArrayList<>();
        // 将起点加⼊队列
        prev.add(root);
        // 记录扩散的步数
        int step = 0;
        while (!prev.isEmpty()) {
            /* 将当前队列中的所有节点向四周扩散 */
            for (Node cur : prev) {
                /* 将 cur 的相邻节点加⼊队列 */
                if (cur.children != null) {
                    next.addAll(cur.children);
                }
            }
            /* 划重点：更新步数在这⾥ */
            step++;
            prev.clear();
            if (next.isEmpty()) {
                break;
            }
            for (Node cur : next) {
                /* 将 cur 的相邻节点加⼊队列 */
                if (cur.children != null) {
                    prev.addAll(cur.children);
                }
            }
            next.clear();
            step++;
        }
        return step;
    }
}


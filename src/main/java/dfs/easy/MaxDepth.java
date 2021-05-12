package dfs.easy;

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
        nodeList.add(node3);
        nodeList.add(node2);
        nodeList.add(node4);
        Node root = new Node(1, nodeList);
        System.out.println(new MaxDepth().maxDepth(root));
    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children == null) {
            //叶子结点结束递归
            return 1;
        } else {
            //记录最大深度
            int max = 0;
            for (Node item : root.children) {
                //递归进入叶子节点，从最深处开始增加深度值，若大于最大深度值则替换最大深度值
                max = Math.max(maxDepth(item), max);
            }
            //每一层增加1深度
            return max + 1;
        }
    }
}


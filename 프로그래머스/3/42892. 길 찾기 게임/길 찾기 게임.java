import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int x, y, idx;
        Node left, right;

        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o1) {
            if (o1.y == this.y) {
                return this.x - o1.x;
            }
            return o1.y - this.y;
        }
    }

    static ArrayList<Integer> preorder = new ArrayList<>();
    static ArrayList<Integer> postorder = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int cnt = 1;
        for (int[] node : nodeinfo) {
            pq.offer(new Node(node[0], node[1], cnt++));
        }
        Node root = pq.peek();
        Node parent = pq.poll();
        while (!pq.isEmpty()) {
            Node recent = pq.poll();
            while (true) {
                if (parent.x < recent.x) {
                    if (parent.right == null) {
                        parent.right = recent;
                        break;
                    } else {
                        parent = parent.right;
                    }
                } else {
                    if (parent.left == null) {
                        parent.left = recent;
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
            }
            parent = root;
        }

        preOrder(root);
        postOrder(root);
        int[][] result = new int[2][nodeinfo.length];
        result[0] = preorder.stream().mapToInt(Integer::intValue).toArray();
        result[1] = postorder.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    void preOrder(Node root) {
        if (root == null) return;
        preorder.add(root.idx);
        preOrder(root.left);
        preOrder(root.right);
    }

    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postorder.add(root.idx);
    }
}
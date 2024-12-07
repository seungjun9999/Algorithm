import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char value;
        Node left, right;

        Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    static int n;
    static char root, left, right;
    static Node head = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            root = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);
            insertNode(head);
        }
        preO(head);
        sb.append("\n");
        inO(head);
        sb.append("\n");
        postO(head);
        System.out.print(sb);
    }

    static void insertNode(Node hd) {
        if (hd.value == root) { // 없으면 바로 추가
            hd.left = (left == '.' ? null : new Node(left, null, null));
            hd.right = (right == '.' ? null : new Node(right, null, null));
        } else {
            // 있으면 왼쪽 오른쪽
            if (hd.left != null) {
                insertNode(hd.left);
            }
            if (hd.right != null) {
                insertNode(hd.right);
            }
        }
    }

    static void preO(Node node) {
        if (node == null) {
            return;
        }
        sb.append(node.value);
        preO(node.left);
        preO(node.right);
    }

    static void inO(Node node) {
        if (node == null) {
            return;
        }
        inO(node.left);
        sb.append(node.value);
        inO(node.right);
    }

    static void postO(Node node) {
        if (node == null) {
            return;
        }
        postO(node.left);
        postO(node.right);
        sb.append(node.value);
    }
}
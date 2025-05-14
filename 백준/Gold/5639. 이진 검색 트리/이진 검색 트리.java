import java.io.*;

public class Main {
    static class Node {
        int root;
        Node left, right, prev;

        Node(int root, Node left, Node right, Node prev) {
            this.root = root;
            this.left = left;
            this.right = right;
            this.prev = prev;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = "";
        int n = Integer.parseInt(br.readLine());
        Node root = new Node(n, null, null, null);
        Node now = root;
        Node next;
        while ((num = br.readLine()) != null) {
            n = Integer.parseInt(num);
            next = new Node(n, null, null, null);
            if (n < now.root) {
                now.left = next;
                next.prev = now;
            } else {
                while (now.prev != null && now.prev.root < n) {
                    now = now.prev;
                    if (now.prev == null) break;
                }
                while (now.right != null) {
                    now = now.right;
                }
                now.right = next;
                next.prev = now;
            }
            now = next;
        }
        huwi(root);
        System.out.print(sb);

    }

    static private void huwi(Node now) {
        if (now.left != null) huwi(now.left);
        if (now.right != null) huwi(now.right);
        sb.append(now.root).append("\n");
    }
}
import java.util.*;

class Solution {
    static int n, miin = 10, flag = 0;
    static int[] weak, dist;
    static boolean[] visited;
    static ArrayDeque<Integer> que;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    static ArrayDeque<Integer> temp = new ArrayDeque<>();

    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;

        visited = new boolean[dist.length];

        for (int j : weak) {
            temp.offer(j);
        }
        for (int i = 0; i < weak.length; i++) {
            que = new ArrayDeque<>(temp);
            backt(0);
            if (flag == 1) {
                break;
            }
            if (!temp.isEmpty()) {
                temp.offer(temp.poll());
            }

        }
        return miin == 10 ? -1 : miin;
    }

    private void backt(int cnt) {
        if (flag == 1) {
            return;
        }
        if (que.isEmpty()) {
            miin = Math.min(miin, cnt);
            if (miin == 1) {
                flag = 1;
            }
            return;
        }
        if (cnt == dist.length) {
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] >= n) {
                flag = 1;
            }
            if (!visited[i]) {
                visited[i] = true;
                int first = 0;
                if (!que.isEmpty()) {
                    first = que.peek();
                }
                outQue(dist[i], first);
                backt(cnt + 1);
                addQue(first);
                visited[i] = false;
            }
        }
    }

    private void outQue(int s, int f) {
        if (f + s >= n) {
            while (!que.isEmpty() && ((que.peek() >= f && que.peek() < n) || que.peek() <= (f + s) % n)) {
                stack.push(que.poll());
            }
        } else {
            while (!que.isEmpty() && (f + s >= que.peek() && f <= que.peek())) {
                stack.push(que.poll());
            }
        }
    }

    private void addQue(int f) {
        while (!stack.isEmpty()) {
            if (stack.peek() == f) {
                que.addFirst(stack.pop());
                break;
            }
            que.addFirst(stack.pop());
        }
    }
}
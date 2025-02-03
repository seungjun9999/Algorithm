import java.util.*;

class Solution {
    static int[] dx = {0, 1, 2, 1, 0, -1, -2, -1};
    static int[] dy = {2, 1, 0, -1, -2, -1, 0, 1};
    static HashSet<String> line = new HashSet<>();
    static HashSet<String> hs = new HashSet<>();
    static int answer = 0;
    static int[] start = {0, 0}, now = {0, 0};

    public int solution(int[] arrows) {
        hs.add("0,0");
        for (int arrow : arrows) {
            if (arrow % 2 == 1) {
                int a = 2;
                while (a-- > 0) {
                    goLine(arrow);
                }
            } else {
                goLine(arrow);
            }

        }
        return answer;
    }

    static void goLine(int arrow) {
        now[0] = start[0] + dx[arrow];
        now[1] = start[1] + dy[arrow];
        if (!hs.contains(now[0] + "," + now[1])) {
            hs.add(now[0] + "," + now[1]);
        } else {
            if (!line.contains(start[0] + "," + start[1] + ":" + now[0] + "," + now[1]) && !line.contains("" + now[0] + "," + now[1] + ":" + start[0] + "," + start[1])) {
                answer++;
            }
        }
        line.add(start[0] + "," + start[1] + ":" + now[0] + "," + now[1]);
        line.add(now[0] + "," + now[1] + ":" + start[0] + "," + start[1]);
        start = now.clone();
    }
}
import java.io.*;
import java.util.*;

public class Main {
    static int n, result = 0;
    static int[][] num;
    static int[] start = new int[2];
    static int[] end = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        start = new int[]{n / 2 - 1, n / 2 - 1};
        end = new int[]{n / 2, n / 2};
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dev = new int[4];
        int maax = 0, dep = 0;
        for (int i = start[1]; i <= end[1]; i++) {
            dev[0] += num[start[0] - 1][i];
        }
        for (int i = start[1]; i <= end[1]; i++) {
            dev[1] += num[end[0] + 1][i];
        }
        for (int i = start[0]; i <= end[0]; i++) {
            dev[2] += num[i][start[1] - 1];
        }
        for (int i = start[0]; i <= end[0]; i++) {
            dev[3] += num[i][end[1] + 1];
        }
        for (int i = 0; i < 4; i++) {
            if (maax < dev[i]) {
                maax = dev[i];
                dep = i;
            }
        }
        
        while (true) {
            if (maax > 0) {
                maax = 0;
                if (dep == 0) {

                    result += dev[0];
                    dev[0] = 0;
                    if (start[0] > 0) {
                        start = new int[]{start[0] - 1, start[1]};

                        if (start[0] > 0) {
                            for (int i = start[1]; i <= end[1]; i++) {
                                dev[0] += num[start[0] - 1][i];
                            }
                        }

                        if (start[1] > 0) dev[2] += num[start[0]][start[1] - 1];
                        if (end[1] < n - 1) dev[3] += num[start[0]][end[1] + 1];
                    }

                    sb.append("U");

                } else if (dep == 1) {

                    result += dev[1];
                    dev[1] = 0;
                    if (end[0] < n - 1) {
                        end = new int[]{end[0] + 1, end[1]};
                        if (end[0] < n - 1) {
                            for (int i = start[1]; i <= end[1]; i++) {
                                dev[1] += num[end[0] + 1][i];
                            }
                        }
                        if (start[1] > 0) dev[2] += num[end[0]][start[1] - 1];
                        if (end[1] < n - 1) dev[3] += num[end[0]][end[1] + 1];
                    }

                    sb.append("D");

                } else if (dep == 2) {

                    result += dev[2];
                    dev[2] = 0;
                    if (start[1] > 0) {
                        start = new int[]{start[0], start[1] - 1};
                        if (start[1] > 0) {
                            for (int i = start[0]; i <= end[0]; i++) {
                                dev[2] += num[i][start[1] - 1];
                            }

                        }
                        if (start[0] > 0) dev[0] += num[start[0] - 1][start[1]];
                        if (end[0] < n - 1) dev[1] += num[end[0] + 1][start[1]];
                    }


                    sb.append("L");

                } else {

                    result += dev[3];
                    dev[3] = 0;
                    if (end[1] < n - 1) {
                        end = new int[]{end[0], end[1] + 1};

                        if (end[1] < n - 1) {
                            for (int i = start[0]; i <= end[0]; i++) {
                                dev[3] += num[i][end[1] + 1];
                            }
                        }

                        if (start[0] > 0) dev[0] += num[start[0] - 1][end[1]];
                        if (end[0] < n - 1) dev[1] += num[end[0] + 1][end[1]];
                    }


                    sb.append("R");
                }

                for (int i = 0; i < 4; i++) {
                    if (maax < dev[i]) {
                        maax = dev[i];
                        dep = i;
                    }
                }
            } else {
                break;
            }
        }


        System.out.println(result);
        System.out.print(sb);
    }
}
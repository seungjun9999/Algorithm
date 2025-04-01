import java.io.*;
import java.util.*;

public class Main {
    static int n, maax = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] num = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(num, 0);
        System.out.println(maax);
    }

    static private void dfs(int[][] map, int dep) {
        if (dep == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    maax = Math.max(map[i][j], maax);
                }
            }
            return;
        }
        int[][] umap = mapMove(0, map);
        int[][] dmap = mapMove(1, map);
        int[][] rmap = mapMove(2, map);
        int[][] lmap = mapMove(3, map);

        dfs(umap, dep + 1);
        dfs(dmap, dep + 1);
        dfs(rmap, dep + 1);
        dfs(lmap, dep + 1);
    }

    static private int[][] mapMove(int d, int[][] arr) {
        int[][] copy = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }
        if (d == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy[j][i] != 0) {
                        int move = 1;
                        int x = j;
                        while (move != 0) {
                            if (x - 1 >= 0) {
                                if (copy[x - 1][i] == 0) {
                                    copy[x - 1][i] = copy[x][i];
                                    copy[x][i] = 0;
                                    x -= 1;
                                } else if (copy[x - 1][i] == copy[x][i] && !visited[x - 1][i]) {
                                    copy[x - 1][i] *= 2;
                                    copy[x][i] = 0;
                                    visited[x - 1][i] = true;
                                    move = 0;
                                } else {
                                    move = 0;
                                }
                            } else {
                                move = 0;
                            }
                        }
                    }
                }
            }

        } else if (d == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (copy[j][i] != 0) {
                        int move = 1;
                        int x = j;
                        while (move != 0) {
                            if (x + 1 < n) {
                                if (copy[x + 1][i] == 0) {
                                    copy[x + 1][i] = copy[x][i];
                                    copy[x][i] = 0;
                                    x += 1;
                                } else if (copy[x + 1][i] == copy[x][i] && !visited[x + 1][i]) {
                                    copy[x + 1][i] *= 2;
                                    copy[x][i] = 0;
                                    visited[x + 1][i] = true;
                                    move = 0;
                                } else {
                                    move = 0;
                                }
                            } else {
                                move = 0;
                            }
                        }
                    }
                }
            }

        } else if (d == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (copy[i][j] != 0) {
                        int move = 1;
                        int y = j;
                        while (move != 0) {
                            if (y + 1 < n) {
                                if (copy[i][y + 1] == 0) {
                                    copy[i][y + 1] = copy[i][y];
                                    copy[i][y] = 0;
                                    y += 1;
                                } else if (copy[i][y + 1] == copy[i][y] && !visited[i][y + 1]) {
                                    copy[i][y + 1] *= 2;
                                    copy[i][y] = 0;
                                    visited[i][y+1] = true;
                                    move = 0;
                                } else {
                                    move = 0;
                                }
                            } else {
                                move = 0;
                            }
                        }
                    }
                }
            }

        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (copy[i][j] != 0) {
                        int move = 1;
                        int y = j;
                        while (move != 0) {
                            if (y - 1 >= 0) {
                                if (copy[i][y - 1] == 0) {
                                    copy[i][y - 1] = copy[i][y];
                                    copy[i][y] = 0;
                                    y -= 1;
                                } else if (copy[i][y - 1] == copy[i][y] && !visited[i][y - 1]) {
                                    copy[i][y - 1] *= 2;
                                    copy[i][y] = 0;
                                    visited[i][y - 1] = true;
                                    move = 0;
                                } else {
                                    move = 0;
                                }
                            } else {
                                move = 0;
                            }
                        }
                    }
                }
            }

        }


        return copy;
    }


}
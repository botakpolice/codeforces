import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken()); // scale in meters

        char[][] map = new char[h][w];
        int[] src = new int[2];
        int[] dest = new int[2];

        // Read the map and locate start (@) and destination ($)
        for (int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (line[j] == '@') {
                    src[0] = i;
                    src[1] = j;
                    line[j] = '.'; // treat start as traversable
                } else if (line[j] == '$') {
                    dest[0] = i;
                    dest[1] = j;
                    line[j] = '.'; // treat destination as traversable
                }
            }
            map[i] = line;
        }

        bfs(map, src, dest, s);
    }

    static void bfs(char[][] map, int[] src, int[] dest, long s) {
        int h = map.length;
        int w = map[0].length;
        boolean[][] visited = new boolean[h][w];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src[0], src[1]});
        visited[src[0]][src[1]] = true;

        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0], y = curr[1];

                if (x == dest[0] && y == dest[1]) {
                    System.out.println("Your destination will arrive in " + (steps * s) + " meters");
                    return;
                }

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w &&
                        map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true; // mark visited
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            steps++;
        }

        System.out.println("Destination unreachable.");
    }
}

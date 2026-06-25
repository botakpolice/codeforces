import java.io.*;
import java.util.*;
import java.math.BigInteger;


class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        BigInteger s = new BigInteger(st.nextToken());


        // each cell has a width of s
        // just bfs
        char[][] map = new char[h][w];
        int[] src = new int[]{-1,-1};
        int[] dest = new int[]{-1,-1};
        for (int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (line[j] == '@') {
                    src[0] = i;;
                    src[1] = j;
                }

                if (line[j] == '$') {
                    dest[0] = i;
                    dest[1] = j;
                }
            }
            map[i] = line;
        }


        int dist = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(src);
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1,0}, {1,0}};

        while(!q.isEmpty()) {

            int size = q.size();
            Queue<int[]> newQ = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();

                if (curr[0] == dest[0] && curr[1] == dest[1]) {

                    BigInteger d = s.multiply(new BigInteger(String.valueOf(dist)));
                    System.out.println(String.format("Your destination will arrive in %s meters", d));
                    return;
                }
                
                // mark as visited
                map[curr[0]][curr[1]] = '#';

                for (int[] dir : dirs) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    int[] next = new int[] {nextX , nextY};
                    if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
                        continue;
                    }

                    if (map[nextX][nextY] != '$' &&  map[nextX][nextY] != '.') {
                        continue;
                    }
                    newQ.add(next);
                }
            }
            q = newQ;
            dist++;
        }
    }
}
                


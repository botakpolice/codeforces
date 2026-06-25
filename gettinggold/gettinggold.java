import java.util.*;



class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        char[][] grid = new char[t[1]][t[0]];
        int r = -1, c = -1;
        for (int i = 0; i < t[1]; i++) {
            grid[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < t[0]; j++) {
                if (grid[i][j] == 'P') {
                    r = i;
                    c = j;
                }
            }
        }


        int res = dfs(r,c,grid);
        System.out.println(res);
        for (int i = 0; i < t[1]; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }


    }


    static int dfs(int r, int c, char[][] grid) {

        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != '#') {

            int goldCounts = 0;
            if (grid[r][c] == 'G') {
                goldCounts += 1;
            }

            int[][] dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
            for (int[] dir : dirs) {
                int dx = r + dir[0];
                int dy = c + dir[1];

                if (grid[dx][dy] == 'T') {
                    return goldCounts;
                }
            }

            grid[r][c] = '#';
            goldCounts += dfs(r - 1, c, grid);
            goldCounts += dfs(r + 1, c ,grid);
            goldCounts += dfs(r, c - 1, grid);
            goldCounts += dfs(r, c + 1, grid);

            return goldCounts;
        }

        return 0;
        
    }
}

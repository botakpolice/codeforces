import java.io.*;
import java.util.*;

public class stamina_and_tasks {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] tasks = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                tasks[i] = new int[]{c, p};
            }

            double res = 0.0;
            for (int i = n - 1; i >= 0; i--) {
                int[] task = tasks[i];
                double d = (1 - task[1] / 100.0);
                res = Math.max(res, res * d + task[0]);
            }

            System.out.println(res);
            
        }

    }
    static double solve(int i, int[][] tasks, double s) {

        if (i == tasks.length) {
            return 0.0;
        }

        double skip = solve(i + 1, tasks, s);
        double take = s * tasks[i][0] + solve(i + 1, tasks, s * (1 - tasks[i][1]/100.0));

        return Math.max(skip, take);

    }


}

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Integer> prods = new ArrayList<>();
        int N = (int) (1e5);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr < N) {
                prods.add(curr);
                q.add(curr * 10);
                q.add(curr * 10 + 1);
            }
        }

        boolean[] possible = new boolean[N + 1];
        possible[1] = true;
        for (int i = 1; i <= N; i++) {
            for (int p : prods) {
                if (i % p == 0) {
                    possible[i] |= possible[i/p];
                }
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (possible[n]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}

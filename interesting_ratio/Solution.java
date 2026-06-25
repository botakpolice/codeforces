import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = (int) (1e7 + 5);
        boolean[] isP = new boolean[N];
        Arrays.fill(isP, true);
        for (int i = 2; i < N; i++) {
            if (!isP[i]) {
                continue;
            }
            for (int j = 2; i * j < N; j++) {
                isP[j * i] = false;
            }
        }
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long res = 0;
            for (int i = 2; i <= n; i++) {
                if (isP[i]) {
                    res += n / i;
                }
            }

            System.out.println(res);
        }

    }
}

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            int[][] A = {
                {a1, a2},
                {a2, a1}
            };

            int[][] B = {
                {b1,b2},
                {b2,b1}
            };

            int res = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {

                    int suneet = 0;
                    int slavic = 0;
                    for (int r = 0; r < 2; r++) {
                        if (A[i][r] > B[j][r]) {
                            suneet++;
                        } else if (A[i][r] < B[j][r]) {
                            slavic++;
                        }
                    }

                    if (suneet > slavic) {
                        res++;
                    }
                }
            }

            System.out.println(res);

        }

    }
}

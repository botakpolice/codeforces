import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Triplet[] p = new Triplet[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                p[i] = new Triplet(a,b,c);
            }

            Arrays.sort(p, (x,y) -> x.a - y.a);
            for (int i = 0; i < n; i++) {
                if (p[i].a > k) {
                    break;
                }

                k = Math.max(k, p[i].c);
            }

            System.out.println(k);
        }

    }


    static class Triplet {
        int a,b,c;

        Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}

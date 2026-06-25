import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            int[] c = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            long tot = 0;
            for (int i = 0; i < n; i++) {
                tot += a[i];
            }

            long req = (tot + 2) / 3;

            if (solve(a,b,c,req).size() == 3) {
                List<Integer> ans = solve(a,b,c,req);
                System.out.println(1 + " " + ans.get(0) + " " + (ans.get(0) + 1) + " " + ans.get(1) + " " + (ans.get(1) + 1) + " " + n);
           } else if (solve(a,c,b,req).size() == 3) {

                List<Integer> ans = solve(a,c,b,req);
                System.out.println(1 + " " + ans.get(0) + " " + (ans.get(1) + 1) + " " + n + " " + (ans.get(0) + 1) + " " + ans.get(1));


            } else if (solve(b,a,c,req).size() == 3) {
                List<Integer> ans = solve(b,a,c,req);
                System.out.println((ans.get(0) + 1) + " " + ans.get(1) + " " + 1 + " " + ans.get(0) + " " + (ans.get(1) + 1) + " " + n);


            } else if (solve(b,c,a,req).size() == 3) {
                List<Integer> ans = solve(b,c,a,req);
                System.out.println((ans.get(1) + 1) + " " + n + " " + 1 + " " + ans.get(0) + " " + (ans.get(0) + 1) + " " + ans.get(1));



            } else if (solve(c,b,a,req).size() == 3) {
                List<Integer> ans = solve(c,b,a,req);

                System.out.println((ans.get(1) + 1) + " " + n + " " + (ans.get(0) + 1) + " " + ans.get(1) + " " + 1 + " " + ans.get(0));


            } else if (solve(c,a,b,req).size() == 3) {
                List<Integer> ans = solve(c,a,b,req);

                System.out.println((ans.get(0) + 1) + " " + ans.get(1) + " " + (ans.get(1) + 1) + " " + n + " " + 1 + " " + ans.get(0));


            } else {
                System.out.println(-1);
            }



        }
    }


    static List<Integer> solve(int[] a, int[] b, int[] c, long req) {

        long A = 0, B = 0, C = 0;
        int n = a.length;
        List<Integer> parts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            A += a[i];
            B += b[i];
            C += c[i];

            if (parts.size() == 0 && A >= req) {
                parts.add(i + 1);
                A = 0;
                B = 0;
                C = 0;
            } else if (parts.size() == 1 && B >= req) {
                parts.add(i + 1);
                A = 0;
                B = 0;
                C = 0;

            } else if (parts.size() == 2 && C >= req) {

                parts.add(i + 1);
                A = 0;
                B = 0;
                C = 0;

            }
        }

        return parts;
    }
}

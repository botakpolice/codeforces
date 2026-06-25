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
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            List<int[]> res = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                        swapped = true;
                        res.add(new int[] {1, j + 1});
                    }
                }

                if (swapped == false) {
                    break;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (b[j] > b[j + 1]) {
                        int temp = b[j];
                        b[j] = b[j + 1];
                        b[j + 1] = temp;
                        swapped = true;
                        res.add(new int[] {2, j + 1});
                    }
                }
                if (swapped == false) {
                    break;
                }
            }

            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) {
                    res.add(new int[]{3, i + 1});
                }
            }

            StringBuilder sb = new StringBuilder();
            System.out.println(res.size());
            if (res.size() > 0) {

                for (int[] p : res) {
                    sb.append(p[0] + " " + p[1] + "\n");
                }
                System.out.println(sb.toString().trim());

            }
        }

    }
}

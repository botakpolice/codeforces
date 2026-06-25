import java.io.*;
import java.util.*;

class Solution {

    static long mod = (long) (1e9 + 7);
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {

            String line = br.readLine();

            if (line == null) {
                break;
            }
            if (line.isEmpty()) {
                continue;
            }

            st = new StringTokenizer(line);

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] mat = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(mat[i], -1);
                mat[i][i] = n - 1;
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                mat[a][b] = 0;
                mat[b][a] = 0;
                mat[a][a]--;
                mat[b][b]--;

            }

            long[][] removed1 = new long[n-1][n-1];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    removed1[i-1][j-1] = mat[i][j];
                }
            }

            System.out.println(det(removed1));

        }

    }

    static long det(long[][] a) {
        int n = a.length;
        long det = 1;

        for (int i = 0; i < n; i++) {

            // find pivot
            int pivot = i;
            for (int j = i; j < n; j++) {
                if (a[j][i] != 0) {
                    pivot = j;
                    break;
                }
            }

            if (a[pivot][i] == 0) return 0;

            // swap
            if (i != pivot) {
                long[] tmp = a[i];
                a[i] = a[pivot];
                a[pivot] = tmp;
                det = -det;
            }

            // Bareiss elimination
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    a[j][k] = a[j][k] * a[i][i] - a[j][i] * a[i][k];
                    if (i > 0) {
                        a[j][k] /= a[i - 1][i - 1]; // exact division
                    }
                }
            }
        }

        return det * a[n - 1][n - 1];
    }

//    static double det(double[][] mat) {
//
//        int n = mat.length;
//        double d = 1.0;
//
//        for (int i = 0; i < n; i++) {
//
//            int pivot =i;
//            for (int j = i; j < n; j++) {
//                if (Math.abs(mat[j][i]) > 1e-12) {
//                    pivot = j;
//                    break;
//                }
//            }
//
//            if (Math.abs(mat[pivot][i]) < 1e-12) {
//                return 0;
//            }
//
//            if (i != pivot) {
//
//                double[] temp = mat[i];
//                mat[i] = mat[pivot];
//                mat[pivot] = temp;
//                d *= -1;
//            }
//
//            d *= mat[i][i];
//            for (int j = i + 1; j < n; j++) {
//                double factor = mat[j][i] / mat[i][i];
//                for (int k = i; k < n; k++) {
//                    mat[j][k] -= factor * mat[i][k];
//                }
//            }
//        }
//
//        return d;
//    }
//
}

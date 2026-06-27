import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int numSegments = n - k + 1;
            int numPairs = numSegments - 1;

            int[] a = new int[n];
            int min = 1;
            int max = n;
            for (int i = 0; i < numPairs; i++) {
                if (a[i] != 0) {
                    continue;
                }
                if (i % 2 == 0) {
                    int temp = i;
                    a[temp] = min++;
                    while (temp + k < n) {
                        a[temp + k] = min++;
                        temp += k;
                    }
                } else {
                    int temp = i;
                    a[temp] = max--;
                    while (temp + k < n) {
                        a[temp + k] = max--;
                        temp += k;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) {
                    a[i] = min++;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int x : a) {
                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());

        }
    }

}

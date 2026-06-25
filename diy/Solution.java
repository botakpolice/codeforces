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
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                if (a[i] == a[i + 1]) {
                    arr.add(a[i]);
                    i++;
                }
            }

            if (arr.size() < 4) {
                System.out.println("NO");
            } else {
                int m = arr.size();
                String ans = arr.get(0) + " " + arr.get(1) + " " + arr.get(0) + " " + arr.get(m - 1) + " " + arr.get(m - 2) + " " + arr.get(1) + " " + arr.get(m - 2) + " " + arr.get(m - 1);
                System.out.println("YES");
                System.out.println(ans);
            }
        }

    }
}

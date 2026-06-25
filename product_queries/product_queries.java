import java.io.*;
import java.util.*;

public class product_queries {

    // Greedy will fail if lets say we have 
    // lets say 48
    // we have 12, but no 4
    // but we have 8 and 6
    // this method incorrectly gives -1 instead of 2
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            boolean[] nums = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                nums[a[i]] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i == 1) {
                    if (!nums[i]) {
                        sb.append("-1").append(" ");
                    } else {
                        sb.append("1").append(" ");
                    }
                } else {
                    int cnt = 0;
                    int k = i;
                    List<Integer> divisors = getDivisors(k);
                    divisors.sort(Collections.reverseOrder());
                    // System.out.println(divisors);
                    for (int d : divisors) {
                        // System.out.println(d + ":" + nums[d]);
                        if (d <= n && nums[d]) {
                            while (k % d == 0) {
                                k /= d;
                                cnt++;
                            }
                            // System.out.println(k);
                        }
                    }
                    if (k == 1) {
                        sb.append(cnt).append(" ");
                    } else {
                        sb.append("-1").append(" ");
                    }
                } 
            }
            System.out.println(sb.toString().trim());
        }
    }

    static List<Integer> getDivisors(int n) {

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i != 1) {
                    divisors.add(i);
                    if (n / i != i) {
                        divisors.add(n / i);
                    }
                } else {
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}

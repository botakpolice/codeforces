import java.io.*;
import java.util.*;

public class odd_process {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            LinkedList<Long> even = new LinkedList<>();
            LinkedList<Long> odd = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                long x = Long.parseLong(st.nextToken());
                if (x % 2 == 0) {
                    even.add(x);
                } else {
                    odd.add(x);
                }
            }
            even.sort(null);
            odd.sort(null);
            StringBuilder sb = new StringBuilder();
            if (even.size() == 0) {

                for (int k = 1; k <= n; k++) {
                    if (k % 2 == 1) {
                        sb.append(odd.peekLast()).append(" ");
                    } else {
                        sb.append(0).append(" ");
                    }
                }
            } else if (odd.size() == 0) {

                for (int k = 1; k <= n; k++) {
                    sb.append(0).append(" ");
                }
            } else {
                long curr = odd.peekLast();
                long prev = -1;
                int even_over = -1;
                for (int k = 1; k <= n; k++) {
                    if (k == n) {
                        if (odd.size() % 2 == 1) {
                            sb.append(curr).append(" ");
                        } else {
                            sb.append(0).append(" ");
                        }
                    } else if (even_over == -1 || (k - even_over) % 2 == 1) {
                        sb.append(curr).append(" ");
                    } else {
                        sb.append(prev).append(" ");
                    }

                    if (!even.isEmpty()) {
                        prev = curr;
                        curr += even.peekLast();
                        even.pollLast();
                        if (even.isEmpty()) {
                            even_over = k;
                        }
                    }
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}

import java.io.*;
import java.util.*;

public class battle_of_arrays {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Long> a = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long> b = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i ++) {
                long x = Long.parseLong(st.nextToken());
                a.add(x);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                long y = Long.parseLong(st.nextToken());
                b.add(y);
            }

            boolean alice = true;
            while (!a.isEmpty() && !b.isEmpty()) {

                if (alice) {
                    long x = a.peek();
                    long y = b.poll();
                    if (y > x) {
                        b.add(y - x);
                    }
                } else {
                    long x = b.peek();
                    long y = a.poll();
                    if (y > x) {
                        a.add(y - x);
                    }
                }

                alice = !alice;
            }
            if (a.isEmpty()) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}

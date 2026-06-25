import java.io.*;
import java.util.*;

public class cyclists {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            LinkedList<Integer> q = new LinkedList<>();
            TreeSet<Integer> pq = new TreeSet<>((a,b) -> {
                if (arr[a] != arr[b]) return Integer.compare(arr[a], arr[b]);
                return Integer.compare(a, b);
            });
            for (int i = 1; i <= n; i++) {
                int c = Integer.parseInt(st.nextToken());
                arr[i] = c;
            }
            for (int i = 1; i <= k; i++) {
                pq.add(i);
            }

            for (int i = k + 1; i <= n; i++) {
                q.add(i);
            }

            int res = 0;
            while (m > 0) {
                if (pq.contains(p)) {
                    if (arr[p] <= m) {
                        m -= arr[p];
                        res++;
                        pq.remove(p);
                        q.addLast(p);
                        pq.add(q.removeFirst());

                    } else {
                        break;
                    }
                } else {
                    int c = pq.pollFirst();
                    if (arr[c] > m) {
                        break;
                    }

                    m -= arr[c];
                    q.addLast(c);
                    pq.add(q.removeFirst());
                }
            }


            System.out.println(res);
        }
    }
}


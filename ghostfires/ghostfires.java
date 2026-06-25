import java.io.*;
import java.util.*;

public class ghostfires {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> y.freq - x.freq);
            if (r > 0) {
                pq.add(new Pair(r, 'r'));
            }
            if (g > 0) {
                pq.add(new Pair(g, 'g'));
            }
            if (b > 0) {
                pq.add(new Pair(b, 'b'));
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {

                boolean found = false;
                List<Pair> skipped = new ArrayList<>();

                while (!pq.isEmpty()) {
                    Pair curr = pq.poll();
                    int len = sb.length();
                    if ((len > 0 && sb.charAt(len - 1) == curr.c) || (len > 2 && sb.charAt(len - 3) == curr.c)) {
                        skipped.add(curr);
                    } else {

                        sb.append(curr.c);
                        curr.freq--;
                        if (curr.freq > 0) {
                            pq.add(curr);
                        }
                        found = true;
                        break;
                    }
                }
                for (Pair p : skipped) {
                    pq.add(p);
                }

                if (!found) {
                    break;
                }
            }

            System.out.println(sb.toString());
        }
    }

    static class Pair {
        int freq;
        char c;
        Pair(int freq, char c) {
            this.freq = freq;
            this.c = c;
        }
    }
}

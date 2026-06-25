import java.io.*;
import java.util.*;

public class simons_and_posting_blogs {

    static int compare(List<Integer> a, List<Integer> b) {
        int m = Math.min(a.size(), b.size());
        for (int i = 0; i < m; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) - b.get(i);
            }
        }
        return a.size() - b.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());

            List<List<Integer>> blogs = new ArrayList<>();
            // preprocess
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());

                List<Integer> a = new ArrayList<>();
                for (int j = 0; j < l; j++) {
                    a.add(Integer.parseInt(st.nextToken()));
                }

                Collections.reverse(a);

                List<Integer> al = new ArrayList<>();
                HashSet<Integer> seen = new HashSet<>();
                for (int v : a) {
                    if (!seen.contains(v)) {
                        al.add(v);
                        seen.add(v);
                    }
                }

                blogs.add(al);
            }

            StringBuilder sb = new StringBuilder();
            HashSet<Integer> used = new HashSet<>();
            boolean[] done = new boolean[n];

            for (int step = 0; step < n; step++) {

                int id = - 1;

                for (int i = 0; i < n; i++) {
                    if (done[i]) {
                        continue;
                    }

                    if (id == -1 || compare(blogs.get(i), blogs.get(id)) < 0) {
                        id = i;
                    }
                }

                List<Integer> curr = blogs.get(id);

                for (int v : curr) {
                    if (!used.contains(v)) {
                        used.add(v);
                        sb.append(v).append(" ");
                    }
                }

                done[id] = true;
                for (int i = 0; i < n; i++) {
                    if (done[i]) {
                        continue;
                    }
                    List<Integer> next = new ArrayList<>();
                    for (int v : blogs.get(i)) {
                        if (!used.contains(v)) {
                            next.add(v);
                        }
                    }
                    blogs.set(i, next);
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}

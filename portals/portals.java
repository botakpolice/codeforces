import java.io.*;
import java.util.*;

public class portals {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> insidePortal = new ArrayList<>();
            List<Integer> outsidePortal = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                if (i >= a && i < b) {
                    insidePortal.add(x);
                } else {
                    outsidePortal.add(x);
                }
            }

            int m = insidePortal.size();
            int curr = insidePortal.get(0);
            int idx = 0;
            for (int i = 1; i < m; i++) {
                if (insidePortal.get(i) < curr) {
                    curr = insidePortal.get(i);
                    idx = i;
                }
            }

            List<Integer> rotatedPortal = new ArrayList<>();
            for (int i = idx; i < m; i++) {
                rotatedPortal.add(insidePortal.get(i));
            }

            for (int i = 0; i < idx; i++) {
                rotatedPortal.add(insidePortal.get(i));
            }

            int insertionIdx = 0;
            while (insertionIdx < outsidePortal.size() && outsidePortal.get(insertionIdx) < curr) {
                insertionIdx++;
            }
            outsidePortal.addAll(insertionIdx, rotatedPortal);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < outsidePortal.size(); i++) {
                sb.append(outsidePortal.get(i)).append(" ");
            }

            System.out.println(sb.toString().trim());

        }
    }
}

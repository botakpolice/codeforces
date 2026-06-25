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
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            HashSet<Integer> currentPositions = new HashSet<>();
            currentPositions.add(x);
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                String dir = st.nextToken();

                HashSet<Integer> nextPos = new HashSet<>();
                for (int curr : currentPositions) {
                    if (dir.equals("0") || dir.equals("?")) {
                        nextPos.add((curr + d) % n);
                    }

                    if (dir.equals("1") || dir.equals("?")) {
                        nextPos.add((curr - d + n) % n);
                    }
                }

                currentPositions = nextPos;                                
            }

            List<Integer> sortedList = new ArrayList<>(currentPositions);
            sortedList.sort(null);
            StringBuilder sb = new StringBuilder();
            for (int p : sortedList) {
                sb.append(p + 1).append(" ");
            }

            System.out.println(sortedList.size());
            System.out.println(sb.toString().trim());

        }
    }

}

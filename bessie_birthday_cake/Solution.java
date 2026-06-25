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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int res = x - 2;
            int[] chosen = new int[x];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < x; i++) {
                chosen[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(chosen);

            List<Integer> oddGaps = new ArrayList<>();
            List<Integer> evenGaps = new ArrayList<>();
            int totalTriangles = Math.max(0, x - 2);
            for (int i = 0; i < x; i++) {
                int nextIdx = (i + 1) % x;
                int vertexDiff;

                if (nextIdx == 0) {
                    vertexDiff = (n - chosen[i]) + chosen[0];
                } else {
                    vertexDiff = chosen[nextIdx] - chosen[i];
                }


                if (vertexDiff == 2) {
                    totalTriangles++;
                } else if (vertexDiff > 2) {
                    if (vertexDiff % 2 == 0) {
                        oddGaps.add(vertexDiff);
                    } else {
                        evenGaps.add(vertexDiff);
                    }
                }
            }

            Collections.sort(oddGaps);
            Collections.sort(evenGaps);

            for (int gap : oddGaps) {
                int needed = (gap - 1) / 2;
                if (y >= needed) {
                    y-= needed;
                    totalTriangles += (gap - 1);
                } else {
                    totalTriangles += (2 * y);
                    y = 0;
                    break;
                }
            }

            if (y > 0) {

                for (int gap : evenGaps) {
                    int needed = (gap / 2);
                    if (y >= needed) {
                        y -= needed;
                        totalTriangles += (gap - 1);
                    } else {
                        totalTriangles += (2 * y);
                        y = 0;
                        break;
                    }
                }


            }
            if (y > 0) {
                totalTriangles += (2 * y);
            }

            System.out.println(Math.min(n - 2, totalTriangles));

        }
    }

}

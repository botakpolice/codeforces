import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2) {
                if ((y1 - y2) % b == 0) {
                    System.out.println("Yes");
                    continue;
                } else {
                    System.out.println("No");
                    continue;
                }
            }

            if (y1 == y2) {
                if ((x1 - x2) % a == 0 ){
                    System.out.println("Yes");
                    continue;
                } else {
                    System.out.println("No");
                    continue;
                }
            }
            if ((x1- x2) % a == 0 || (y1 - y2) % b == 0) {
                System.out.println("Yes");
                continue;
            } else {
                System.out.println("No");
                continue;
            }

        }

    }
}

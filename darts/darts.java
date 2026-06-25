import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {

            int n = Integer.parseInt(sc.nextLine());
            int res = 0;
            int[] radii = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
            for (int i = 0; i < n; i++) {

                int[] d = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                double r = Math.sqrt(d[0]*d[0] + d[1]*d[1]);
                for (int j = 0; j < 10; j++) {
                    if (r <= radii[j]) {
                        res += 10 - j;
                        break;
                    }
                }

            }

            System.out.println(res);
        }
    }
}

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] l = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
        int t = l[0], s = l[1], n = l[2];

        int[] flips = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

        int cur = 0;
        int orientation = 0; // 0 = not flipped, 1 = flipped
        int timeSandInTop = 0;

        for (int f : flips) {
            int dt = f - cur;

            // If sand is currently in the top half, count this time
            if (orientation == 0) {
                timeSandInTop += dt;
            }

            // Flip changes orientation
            orientation ^= 1;

            cur = f;
        }

        // Final interval: cur → t
        int dt = t - cur;
        if (orientation == 0) {
            timeSandInTop += dt;
        }

        // Sand remaining in top
        int remaining = Math.max(0, s - timeSandInTop);

        System.out.println(remaining);
    }
}

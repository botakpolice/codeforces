import java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = t[0], f = t[1];

        long rotations = Math.round(f / (double) r);
        if (rotations % 2 == 0) {
            System.out.println("up");
        } else {
            System.out.println("down");
        }
    }
}

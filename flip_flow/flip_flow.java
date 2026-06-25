mport java.util.*;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] l = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int t = l[0], s = l[1], n = l[2];
        int[] flips = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sandUp = 0, sandDown = s;
        for (int i = 1; i < n; i++) {
            sandUp = Math.max(0, sandDown - (flips[i] - flips[i-1]));
            sandDown = s - sandUp;
        }

        int res = Math.max(0,sandDown - (t - flips[flips.length - 1]));

        System.out.println(res);
    }
}

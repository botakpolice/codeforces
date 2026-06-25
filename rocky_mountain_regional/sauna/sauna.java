import java.util.*;


class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            min = Math.max(min, arr[0]);
            max = Math.min(max, arr[1]);
                
        }

        if (min > max) {
            System.out.println("bad news");
        } else {
            System.out.println(String.format("%d %d", max - min + 1, min));
        }
    }
}

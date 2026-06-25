import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int g = t[0], n = t[1];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] p = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = p;
        }
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
        int cnt = 1, lastTime = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= lastTime) {
                cnt++;
                lastTime = arr[i][1];
            }
        }

        if (cnt >= g) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

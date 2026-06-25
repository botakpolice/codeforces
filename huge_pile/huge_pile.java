import java.io.*;
import java.util.*;

public class huge_pile {
    static int res;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0], k = arr[1];
            res = -1;
            HashSet<Integer> visited = new HashSet<>();
            dfs(n, k, visited, 0);
            System.out.println(res);

        }
    }

    static void dfs(int x, int k, HashSet<Integer> visited, int splits) {
        if (x == 0) {
            return;
        }

        if (visited.contains(x)) {
            return;
        }

        visited.add(x);
        if (x == k) {
            res = splits;
            return;
        }
        int left = x / 2;
        int right = x - left;
        dfs(left, k, visited, splits + 1);
        dfs(right, k, visited, splits + 1);
        
    }

}

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= t; i++) {
            int traces = Integer.parseInt(sc.nextLine());
            // b has a data dependency on a if it reads from a memory address that a writes to
            //
            HashMap<Integer,Integer> cores = new HashMap<>();
            int globalMax = 0;
            for (int j = 0; j < traces; j++) {
                int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int n = arr[0];
                int w = arr[n];
                int x = 0;
                for (int k = 1; k < n; k++) {
                    int c = arr[k];
                    x = Math.max(x, cores.getOrDefault(c, 0));
                }
                int finishtime = x + 1;
                cores.put(w, finishtime);

                globalMax = Math.max(globalMax, finishtime);
            }

            System.out.println(i + " " + globalMax);
        }
    }
}

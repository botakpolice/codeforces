import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], m = t[1];
        PriorityQueue<Integer> available = new PriorityQueue<>((a,b) -> a - b);

        int[][] arrivals = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] arrival = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrivals[i] = arrival;
        }

        Arrays.sort(arrivals, (a,b) -> a[0] - b[0]);
        int savings = 0;
        for (int[] arrival : arrivals) {
            int start = arrival[0], duration = arrival[1];
            while (available.size() > 0 && available.peek() + m < start) {
                available.poll();
            }

            if (available.size() > 0 && available.peek() <= start && start <= available.peek() + m) {
                savings++;
                available.poll();
            } 

            available.add(start + duration);
        }

        System.out.println(savings);


    }
}

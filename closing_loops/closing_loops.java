import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            PriorityQueue<Integer> red = new PriorityQueue<>((a,b) -> b - a);
            PriorityQueue<Integer> blue = new PriorityQueue<>((a,b) -> b - a);
            String[] segments = sc.nextLine().split(" ");
            for (String s : segments) {
                int l = Integer.parseInt(s.substring(0,s.length() - 1));
                char col = s.charAt(s.length() - 1);
                if (col == 'B') {
                    blue.add(l);
                } else {
                    red.add(l);
                }
            }

            int res = 0;
            while (!red.isEmpty() && !blue.isEmpty()) {
                int a = red.poll();
                int b = blue.poll();
                res += (a + b) - 2;
            }

            System.out.println(String.format("Case #%d: %d", i+1, res));


        }
    }
}

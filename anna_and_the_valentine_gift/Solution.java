import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            // 1 2007 800 1580
            // 1 2007 8 1580
            // Anna will first greedily reverse all nums which can be mod by 10
            // Sasha will then combine the next num which can be mod by 10 with the smallest number no moduloable
            // Then if no num is modulable by 10
            // if num's last digit is smaller than num's first digit, we reverse
            // 2007 8 15801
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            PriorityQueue<String> pq2 = new PriorityQueue<>();
            PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> {

                int x = 0;
                int y = 0;
                while (a % 10 == 0) {
                    a /= 10;
                    x++;
                }

                while (b % 10 == 0) {
                    b /= 10;
                    y++;
                }

                if (x - y == 0) {
                    return b - a;
                }
                return y - x;

            });
            for (int x : nums) {
                if (x % 10 == 0) {
                    pq1.add(x);
                } else {
                    pq2.add(String.valueOf(x));
                }
            }

            while (!pq1.isEmpty()) {
                int firstNum = pq1.poll();
                int reversedNum = reverse(firstNum);
                pq2.add(String.valueOf(reversedNum));
                if (!pq1.isEmpty()) {
                    int secondNum = pq1.poll();
                    String thirdNum = "";
                    if (!pq2.isEmpty()) {
                        thirdNum = pq2.poll();
                    }
                    String fourthNum = String.valueOf(secondNum) +thirdNum;
                    pq2.add(fourthNum);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!pq2.isEmpty()) {
                sb.append(pq2.poll());
            }

            int len = sb.toString().length();
            if (len - 1 >= m) {
                System.out.println("Sasha");
            } else {
                System.out.println("Anna");
            }
        }
    }

    static int reverse(int n) {

        int x = 0;
        while (n > 0) {
            x *= 10;
            x += n % 10;
            n /= 10;
        }

        return x;
    }
}

import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine());
            char trump = br.readLine().charAt(0);
            HashMap<Character,PriorityQueue<Integer>> map = new HashMap<>();
            map.put('C', new PriorityQueue<>());
            map.put('D', new PriorityQueue<>());
            map.put('H', new PriorityQueue<>());
            map.put('S', new PriorityQueue<>());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n * 2; i++) {
                String s = st.nextToken();
                int num = s.charAt(0) - '0';
                char suit = s.charAt(1);
                map.get(suit).add(num);
            }

            List<String[]> rounds = new ArrayList<>();
            for (char c : map.keySet()) {
                PriorityQueue<Integer> q = map.get(c);
                if (c == trump) {
                    continue;
                }
                while (q.size() >= 2) {
                    int firstNum = q.poll();
                    int secondNum = q.poll();
                    String[] p = new String[2];
                    p[0] = "" + firstNum + c;
                    p[1] = "" + secondNum + c;
                    rounds.add(p);
                }

                if (q.size() == 1 && map.get(trump).size() > 0) {

                    int firstNum = q.poll();
                    int secondNum = map.get(trump).poll();
                    String[] p = new String[2];
                    p[0] = "" + firstNum + c;
                    p[1] = "" + secondNum + trump;
                    rounds.add(p);

                }

            }

            PriorityQueue<Integer> q = map.get(trump);
            while (q.size() >= 2) {
                int firstNum = q.poll();
                int secondNum = q.poll();
                String[] p = new String[2];
                p[0] = "" + firstNum + trump;
                p[1] = "" + secondNum + trump;
                rounds.add(p);
            }

            if (rounds.size() != n) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String[] pair : rounds) {
                    System.out.println(pair[0] + " " + pair[1]);
                }
            }


        }
    }

}

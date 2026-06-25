import java.io.*;
import java.util.*;

public class robotic_rush {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            TreeSet<Integer> b = new TreeSet<>();
            for (int i = 0; i < m; i++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            HashMap<Integer,List<Integer>> death_locations = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int robotPos = a.get(i);
                Integer lower = b.lower(robotPos);
                if (lower != null) {
                    int shift = lower - robotPos;
                    if (death_locations.get(shift) == null) {
                        death_locations.put(shift, new ArrayList<>());
                    }

                    death_locations.get(shift).add(i);
                }

                Integer upper = b.higher(robotPos);
                if (upper != null) {

                    int shift = upper - robotPos;
                    if (death_locations.get(shift) == null) {
                        death_locations.put(shift, new ArrayList<>());
                    }

                    death_locations.get(shift).add(i);
                }
            }

            String instructions = br.readLine();
            int shift = 0;
            int alive = n;
            HashSet<Integer> dead = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            for (char c : instructions.toCharArray()) {
                shift += c == 'L' ? -1 : 1;

                if (death_locations.containsKey(shift)) {
                    for (int i : death_locations.get(shift)) {
                        if (dead.contains(i)) {
                            continue;
                        }

                        dead.add(i);
                        alive--;
                    }

                    death_locations.get(shift).clear();
                }

                sb.append(alive).append(" ");
            }

            System.out.println(sb.toString().trim());



        }
    }
}

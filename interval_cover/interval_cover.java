import java.util.*;


class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            double[] interval = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double l = interval[0], r = interval[1];
            int n = Integer.parseInt(sc.nextLine());
            List<double[]> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                double[] p = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
                intervals.add(new double[] {p[0], p[1], (double) i});
            }

            intervals.sort((a,b) -> Double.compare(a[0], b[0]) == 0 ? Double.compare(b[1], a[1]) : Double.compare(a[0],  b[0]));
            int i = 0;
            int m = intervals.size();
            List<Integer> indices = new ArrayList<>();
            boolean possible = true;
            while (l < r || indices.size() == 0) {
                double bestReach = l;
                int bestInterval = - 1;
                while (i < m && intervals.get(i)[0] <= l) {
                    if (intervals.get(i)[1] >= bestReach) {
                        bestInterval = (int) intervals.get(i)[2];
                        bestReach = intervals.get(i)[1];
                    }
                    i++;
                }
                if (bestInterval == -1) {
                    System.out.println("impossible");
                    possible = false;
                    break;
                } else {
                    indices.add(bestInterval);
                    l = bestReach;
                }
            }
            if (possible) {
                System.out.println(indices.size());
                for (int j = 0; j < indices.size(); j++) {
                    System.out.print(indices.get(j));
                    if (j != indices.size() - 1) {
                        System.out.print(" ");
                    } else {
                        System.out.print("\n");
                    }
                }

            }


        }
    }
}

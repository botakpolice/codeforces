import java.util.Scanner;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
   
        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], m = t[1], x = t[2], y = t[3];

        Node[][] g = new Node[n][n];
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = edge[0] - 1;
            int end = edge[1] - 1;
            int cost = edge[2];
            Node v = new Node();
            v.cost = cost;
            
            if (edge[3] == 1) {
                v.shamans = 1;
            }
            if (edge[3] == 2) {
                v.titans = 1;
            }
            g[start][end] = v;
            g[end][start] = v;
        }

        Node start = new Node();
        start.village = x - 1;

        Node[] c = new Node[n];
        for (int i = 0; i < n; i++) {
            c[i] = new Node();
            c[i].cost = Integer.MAX_VALUE;
            c[i].shamans = Integer.MAX_VALUE;
            c[i].titans = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(start);
        while (!q.isEmpty()) {
            Node curr = q.poll();
        
            int i = curr.village, currentCost = curr.cost, currentTitans = curr.titans, currentShamans = curr.shamans;


            if (curr.compareTo(c[i]) >= 0) continue; // already have a better path
            c[i] = curr;
            if (i == y - 1) {
                System.out.println(String.format("%d %d %d", currentCost, currentShamans, currentTitans));
                return;
            }

            for (int j = 0; j < n; j++) {
                if (g[i][j] != null) {

                    Node nextNode = new Node();
                    nextNode.village = j;
                    nextNode.cost = currentCost + g[i][j].cost;
                    nextNode.titans = currentTitans + g[i][j].titans;
                    nextNode.shamans = currentShamans + g[i][j].shamans;

                    if (nextNode.compareTo(c[j]) < 0) {
                        q.add(nextNode);
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");


    }

    static class Node implements Comparable<Node> {
        int village;
        int cost;
        int shamans;
        int titans;

        @Override
        public int compareTo(Node other) {
            if (this.titans != other.titans) {
                return this.titans - other.titans;
            }
            if (this.shamans != other.shamans) {
                return this.shamans - other.shamans;
            }

            return this.cost - other.cost;
        }
    }
}

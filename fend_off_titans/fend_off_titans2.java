import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

    static class Edge {
        int u, v;
        int cost;
        int shamans;
        int titans;

        Edge(int u, int v, int cost, int shamans, int titans) {
            this.u = u;
            this.v = v;
            this.cost = cost;
            this.shamans = shamans;
            this.titans = titans;
        }
    }

    static class Node implements Comparable<Node> {
        int village;
        long cost;
        int shamans;
        int titans;

        @Override
        public int compareTo(Node other) {
            if (this.titans != other.titans) {
                return this.titans - other.titans;
            } else if (this.shamans != other.shamans) {
                return this.shamans - other.shamans;
            } 

            return Long.compare(this.cost, other.cost);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] t = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = t[0], m = t[1], x = t[2], y = t[3];
        HashMap<Integer,List<Edge>> graph = new HashMap<>(); 
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Edge e1 = new Edge(edge[0] - 1, edge[1] - 1, edge[2], edge[3] == 1 ? 1 : 0, edge[3] == 2 ? 1 : 0);
            
            Edge e2 = new Edge(edge[1] - 1, edge[0] - 1, edge[2], edge[3] == 1 ? 1 : 0, edge[3] == 2 ? 1 : 0);
 

            List<Edge> a = graph.getOrDefault(edge[0] - 1, new ArrayList<>());
            List<Edge> b = graph.getOrDefault(edge[1] - 1, new ArrayList<>());

            a.add(e1);
            b.add(e2);

            graph.put(edge[0] - 1, a);
            graph.put(edge[1] - 1, b);

        }        

        Node[] dist = new Node[n];
        for (int i = 0; i < n; i++) {
            dist[i] = new Node();
            dist[i].village = i;
            dist[i].cost = Integer.MAX_VALUE;
            dist[i].titans = Integer.MAX_VALUE;
            dist[i].shamans = Integer.MAX_VALUE;
        }
        
        Node start = new Node();
        start.village = x - 1;
        start.cost = 0;
        start.titans = 0;
        start.shamans = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(start);

        while(!pq.isEmpty()) {

            Node curr = pq.poll();
            int u = curr.village;
            if (curr.compareTo(dist[u]) > 0) {
                continue;
            }
            if (graph.get(u) != null) {

                for (Edge neighbour : graph.get(u)) {
                    Node next = new Node();
                    next.village = neighbour.v;
                    next.cost = curr.cost + neighbour.cost;
                    next.titans = curr.titans + neighbour.titans;
                    next.shamans = curr.shamans + neighbour.shamans;

                    if (next.compareTo(dist[neighbour.v]) < 0) {
                        dist[neighbour.v] = next;
                        pq.add(next);
                    }
                }
            }
            
        }

        if (dist[y - 1].cost == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            Node res = dist[y - 1];
            System.out.println(String.format("%d %d %d", res.cost, res.shamans, res.titans));
        }

    }
}

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // read current ingredients
        st = new StringTokenizer(br.readLine());
        int[] currentIngredients = new int[n];
        for (int i = 0; i < n; i++) {
            currentIngredients[i] = Integer.parseInt(st.nextToken());
        }

        // read genres
        List<HashSet<Integer>> genres = new ArrayList<>();
        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            genres.add(set);
        }

        // read dependencies
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }

        // compute all ingredients reachable with DFS
        HashSet<Integer> allIngredients = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int ingredient : currentIngredients) {
            if (!visited.contains(ingredient)) {
                dfs(ingredient, map, visited, allIngredients);
            }
        }

        // check max ingredients
        if (allIngredients.size() > m) {
            System.out.println("disaster");
            return;
        }

        // check if any genre contains all ingredients
        for (HashSet<Integer> recipe : genres) {
            if (recipe.containsAll(allIngredients)) {
                System.out.println("masterpiece");
                return;
            }
        }

        System.out.println("disaster");
    }

    static void dfs(int ingredient, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> res) {
        if (!visited.add(ingredient)) return; // add returns false if already visited
        res.add(ingredient);
        List<Integer> neighbours = map.get(ingredient);
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                dfs(neighbour, map, visited, res);
            }
        }
    }
}

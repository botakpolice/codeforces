import java.io.*;
import java.util.*;


class Solution {

    public static void main(String[] args) throws IOException {

        // n g d m
        // n : total number of ingredients thus far
        // g : number of distinct sandwich genres
        // d : number of ingredient dependencies
        // m : max number of total ingredients

        // 2 2 4 3
        // 1 4 :--> the unique ids of the ingredients already on sandwich
        // 3 2 4 6 : 3 ingredients : unique ids 2 4 6
        // 4 1 2 4 6 : 4 ingredients : unique ids 1 2 4 6

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] currentIngredients = new int[n];
        for (int i = 0; i < n; i++) {
            currentIngredients[i] = Integer.parseInt(st.nextToken());
        }
        List<HashSet<Integer>> genres = new ArrayList<>();
        for (int i = 0; i < g; i++) {
            HashSet<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            genres.add(set);
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(from, k -> new ArrayList<>());
            map.get(from).add(to);
        }

        HashSet<Integer> allIngredients = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int ingredient : currentIngredients) {

            if (!visited.contains(ingredient)) {
                dfs(ingredient, map, visited, allIngredients);
            }
        }
        if (allIngredients.size() > m) {
            System.out.println("disaster");
            return;
        } else {
            for (int i = 0; i < g; i++) {
                HashSet<Integer> recipe = genres.get(i);
                boolean isSubset = true;
                for (int ing : allIngredients) {
                    if (!recipe.contains(ing)) {
                        isSubset = false;
                        break;
                    }
                }
                if (isSubset) {
                    System.out.println("masterpiece");
                    return;
                }
            }

            System.out.println("disaster");

        }
    }

    static void dfs(int ingredient, HashMap<Integer,List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> res) {
        if (visited.contains(ingredient)) {
            return;
        }

        visited.add(ingredient);
        res.add(ingredient);
        List<Integer> neighbours = map.get(ingredient);
        if (neighbours != null) {
            for (int neighbour : neighbours) {
                dfs(neighbour, map, visited, res);
            }
        }


    }
}

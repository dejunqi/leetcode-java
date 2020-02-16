package leetcode.leetcode0721;

import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> map = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (List<String> list : accounts) {
            String name = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                map.put(email, name);
                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                if (i > 1) {
                    String prevEmail = list.get(i - 1);
                    graph.get(prevEmail).add(email);
                    graph.get(email).add(prevEmail);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        for (String email : map.keySet()) {
            List<String> can = new ArrayList<>();
            helper(graph, visited, can, email);
            System.out.println(can);

            if (can.size() > 1) {
                Collections.sort(can);
                can.add(0, map.get(email));
                res.add(can);
            }

        }
        return res;
    }

    private void helper(Map<String, Set<String>> graph, Set<String> visited, List<String> can, String cur) {

        if (!visited.contains(cur)) {
            visited.add(cur);
            can.add(cur);
            for (String e : graph.get(cur)) {
                helper(graph, visited, can, e);
            }
        }
    }

    public void test() {
        String[][] testcase = { {"John", "johnsmith@mail.com", "john00@mail.com"},
                                {"John", "johnnybravo@mail.com"},
                                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                                {"Mary", "mary@mail.com"}};
        List<List<String>> accounts = new ArrayList<>();
        for (String[] row : testcase) {
            accounts.add(new ArrayList<>(Arrays.asList(row)));
        }
        List<List<String>> res = this.accountsMerge(accounts);
    }
}

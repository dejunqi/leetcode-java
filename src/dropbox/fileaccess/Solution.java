package dropbox.fileaccess;

import java.util.*;

public class Solution {

    public boolean hasAccess(String dir, String[][] folders, Set<String> accessible) {
        if (accessible.contains(dir)) {
            return true;
        }
        Map<String, List<String>> graph = new HashMap<>();
        String root = "";
        for (String[] pair : folders) {
            String parent = pair[1], child = pair[0];
            if (parent.equals("")) {
                root = child;
                continue;
            }
            if (!graph.containsKey(parent)) {
                graph.put(parent, new ArrayList<>());
            }
            graph.get(parent).add(child);
        }

        for (String v : graph.keySet()) {
            System.out.println(v);
        }

        return hasAccessAux(dir, root, graph, accessible, false);
    }

    // It is a tree, we do not need to worry about loop in the graph
    // so that we do not need to record visited node
    private boolean hasAccessAux(String target, String curDir, Map<String, List<String>> graph,
                                 Set<String> accessible, boolean canAccess) {

        if (curDir.equals(target) || graph.get(curDir) == null) {
            return canAccess;
        }

        boolean canAccessSubfolder = false;
        if (accessible.contains(curDir)) {
            canAccessSubfolder = true;
        }

        for (String subdir : graph.get(curDir)) {
            if (hasAccessAux(target, subdir, graph, accessible, canAccessSubfolder)) {
                return true;
            }
        }

        return false;
    }

    public void test() {
        String[][] folders = {{"A", ""}, {"B", "A"}, {"C", "B"}, {"D", "B"}, {"E", "A"}, {"F", "E"}};
        Set<String> accessible = new HashSet<>(Arrays.asList("C", "E"));
        System.out.println(hasAccess("E", folders, accessible));
    }
}

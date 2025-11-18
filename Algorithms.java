import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Algorithms {
    
    private TreeNode starterNode;
    private ArrayList<TreeNode> path;
    private int extensions, totalCost;
    
    public Algorithms(TreeNode node) {
        this.starterNode = node;
    }

    public void numberofExtensions() {
        System.out.println("Number of extensions: " + extensions);
    }
    
    private class AComparator implements Comparator<TreeNode> {
        Heuristic h = new Heuristic();
        
        public int compare(TreeNode a, TreeNode b) {
            return (a.getCost() + h.heuristic(a)) - (b.getCost() + h.heuristic(b));
        }
    }
    
    private class UComparator implements Comparator<TreeNode> {
        public int compare(TreeNode a, TreeNode b) {
            return a.getCost() - b.getCost();
        }
    }

    public ArrayList<TreeNode> getPath(TreeNode starter, TreeNode finisher) {
        path = new ArrayList<>();
        TreeNode tmp = finisher;
        
        while (!(tmp.equals(starter))) {
            path.add(tmp);
            tmp =tmp.getParent();
        }
        path.add(starter);
        return path;
    }
    
    public void printPath() {
        for (int i = path.size() - 2; i >= 0; i--) {
            path.get(i).printMatrix();
            System.out.println();
        }
    }

    public void printTotalCost() {
        System.out.println("Total Cost of path: " + totalCost);
    }
    
    public boolean Asearch() {      // A*
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(new AComparator());
        Set<TreeNode> visited = new HashSet<>();
        queue.add(starterNode);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            extensions ++;

            if (current.isTarget()) {
                path = getPath(starterNode, current);
                totalCost = path.size() - 1;
                printPath();
                return true;
            }

            visited.add(current);
            ArrayList<TreeNode> successors = current.successor();
            for (TreeNode successor : successors) {
                if (!visited.contains(successor)) {
                    queue.add(successor);
                }
            }
        }
        return false;
    }
    
    public boolean Usearch() {      // UCS
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(new UComparator());
        Set<TreeNode> visited = new HashSet<>();
        queue.add(starterNode);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            extensions ++;

            if (current.isTarget()) {
                path = getPath(starterNode, current);
                totalCost = path.size() -1;
                printPath();
                return true;
            }

            visited.add(current);
            ArrayList<TreeNode> successors = current.successor();

            for (TreeNode successor : successors) {
                if (!visited.contains(successor)) {
                    queue.add(successor);
                    visited.add(successor);
                }
            }
        }
        return false;
    }
    
}
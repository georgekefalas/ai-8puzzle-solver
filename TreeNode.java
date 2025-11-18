import java.util.ArrayList;
import java.util.Arrays;

public class TreeNode {

    private int[][] state;
    private ArrayList<TreeNode> children;
    private TreeNode parent;
    private int rowzero;
    private int colzero;
    private int cost;
    private boolean visited;

    public TreeNode(int[][] state) {
        this.state = new int[3][3];
        for (int i = 0; i < 3; i++)
            this.state[i] = Arrays.copyOf(state[i], state[i].length);
        this.children= new ArrayList<>();
        this.parent= null;
        this.cost = 0;
        this.visited = false;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (state[i][j] == 0) {
                    this.rowzero=i;
                    this.colzero=j;
                    break;
                }
            }
        }
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int getRowZero() {
        return rowzero;
    }

    public int getColZero() {
        return colzero;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int i) {
        this.cost = i;
    }

    public TreeNode getParent() {
        return parent;
    }

    public int[][] getTable() {
        return state;
    }

    public void addChild(TreeNode child) {
        child.setParent(this);
        child.cost = this.cost + 1;
        this.children.add(child);
    }

    public TreeNode createChild(int a, int b) {
        int[][] childState = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                childState[i][j] = state[i][j];
                
        childState[rowzero][colzero] = childState[a][b];
        int cost = state[a][b];
        childState[a][b] = 0;
        TreeNode child = new TreeNode(childState);
        child.setCost(cost);
        addChild(child);

        return child;    
    }

    public ArrayList<TreeNode> successor() {
        ArrayList<TreeNode> lst = new ArrayList<>();
        int row = getRowZero();
        int col = getColZero();

        if (row > 0) {  //Up
            lst.add(createChild(row - 1, col));
        }
        if (row < 2) {  //Down
            lst.add(createChild(row + 1, col));
        }
        if (col > 0) {  //Left
            lst.add(createChild(row, col - 1));
        }
        if (col < 2) {  //Right
            lst.add(createChild(row, col + 1));
        }
        if (row > 0 && col > 0) {   //Up left
            lst.add(createChild(row - 1, col - 1));
        }
        if (row > 0 && col < 2) {   //Up right
            lst.add(createChild(row - 1, col + 1));
        }
        if (row < 2 && col > 0) {   //Down left
            lst.add(createChild(row + 1, col - 1));
        }
        if (row < 2 && col < 2) {   //Down right
            lst.add(createChild(row + 1, col + 1));
        }

        return lst;    
    }

    public boolean areSame(TreeNode node) {
        int[][] matrix1 = this.getTable();
        int[][] matrix2= node.getTable();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isTarget() {
        int[][] goal = { {6, 5, 4}, {7, 0, 3}, {8, 1, 2} };     // target state
        TreeNode targetNode = new TreeNode(goal);
        return this.areSame(targetNode);
    }

    public void printMatrix() {
        for (int i = 0; i <= 2; i++) {    
            for (int j = 0; j <= 2; j++) {
                System.out.print(state[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TreeNode treeNode = (TreeNode) obj;
        return Arrays.deepEquals(state, treeNode.state);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(state);
    }
}
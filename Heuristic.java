public class Heuristic {
    
    public Heuristic() {}
    
    public int heuristic(TreeNode node) {
        int[][] target = { {6, 5, 4}, {7, 0, 3}, {8, 1, 2} };   // target state
        int res = 0;
        int[][] state = node.getTable();
        
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                int value = state[i][j];
                if (value != 0) {
                    int targetRow = getRow(target, value);
                    int targetCol = getCol(target, value);

                    int dx = Math.abs(i - targetRow);
                    int dy = Math.abs(j - targetCol);

                    // Chebyshev distance
                    res += Math.max(dx, dy);

                }
            }
        }
        return res;
    }

    private int getRow(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == value) return i;
            }
        }
        return -1;
    }

    private int getCol(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == value) return j;
            }
        }
        return -1;
    }
}
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Table table = new Table();
        table.fill_table();
        TreeNode initialNode = new TreeNode(table.getTable());
        Algorithms algo = new Algorithms (initialNode);
        Scanner scanner =new Scanner(System.in);
        int option;

        while (true) {      // Algorithm selection
            System.out.println("UCS - 1");
            System.out.println("A* - 2");
            System.out.println("Which do you prefer? ");
            option = scanner.nextInt();

            if (option == 1 || option == 2) {
                break;
            } else {
                System.out.println("Invalid Number! Please enter 1 or 2.");
            }
        }

        if (option == 1) {          // solution with UCS algorithm
            System.out.println("Initial State:");
            initialNode.printMatrix();
            System.out.println();

            if (algo.Usearch()) {
                System.out.println("Solution found!");
                algo.numberofExtensions();
                algo.printTotalCost();
            } else {
                System.out.println("No solution found!");
            }

        } else if (option == 2) {           // solution with A* algorithm
            System.out.println("Initial State:");
            initialNode.printMatrix();
            System.out.println();

            if (algo.Asearch()) {
                System.out.println("Solution found!");
                algo.numberofExtensions();
                algo.printTotalCost();
            } else {
                System.out.println("No solution found!");
            }
        }
    }
}
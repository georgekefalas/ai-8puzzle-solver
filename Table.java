import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {

    int[][] table;

    public Table() {
        this.table = new int[3][3];
    }

    public void fill_table() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                while (true) {
                    try {
                        System.out.printf("Give number for position (%d, %d): ", i + 1, j + 1);
                        table[i][j] = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid number.");
                    }
                }
            }
        }
    }

    public void print_table() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int[][] getTable() {
        return table;
    }
}
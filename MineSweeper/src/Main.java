import java.util.Scanner;

public class Main {

    public static void isInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid value please enter an integer number");
            input.next();
        }
    }

    public static boolean isCheck(int row, int col) {
        if (row < 2 || col < 2) {

            System.out.println("please enter 2x2 value or bigger!!");
            return false;
        }
        return true;
    }


    public static boolean isMineCheck() {
        return false;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int row = 0;
        int column = 0;

        do {
            System.out.println("Enter row: ");
            isInt(input);
            row = input.nextInt();
            System.out.println("Enter column: ");
            isInt(input);
            column = input.nextInt();

        } while (!isCheck(row, column));

        String[][] arr = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                arr[i][j] = "_";


            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }


    }


}
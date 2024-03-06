import java.sql.SQLOutput;
import java.util.Scanner;

public class MineSweeper {

    // Method to check if the input is an integer
    public static void isInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a valid integer number!!\t: ");
            input.next();
        }
    }

    // Method to check if the row and column values are valid
    public boolean isCheck(int row, int col) {
        if (row < 2 || col < 2) {
            System.out.println("Please enter dimensions of at least 2x2 for the game board!!\n");
            return false;
        }
        return true;
    }

    // Method to count the number of neighboring mines
    public int neighborMineCount(String[][] arr, int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ((i >= 0 && i < arr.length) && (j >= 0 && j < arr[0].length)) {
                    if (arr[i][j].equals("*")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    // Method to start the game
    public void startGame() {

        Scanner input = new Scanner(System.in);

        int row = 0;
        int col = 0;

        // Prompt the user to enter the row and column values until they are valid
        do {
            System.out.print("Please enter the number of rows \t\t: ");
            isInt(input);

            row = input.nextInt();
            System.out.print("Please enter the number of columns \t\t: ");
            isInt(input);

            col = input.nextInt();
            System.out.println("=====================================");
        } while (!isCheck(row, col));

        String[][] mineArray = new String[row][col];

        int elementNum = (row * col);

        int mineNumber = elementNum / 4 ; // Calculate the number of mines
        


        int moveCount = elementNum - mineNumber; // Calculate the number of moves

        // Generate random mine locations
        int mineRow, mineCol;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mineArray[i][j] = "-";
            }
        }

        for (int i = 0; i < mineNumber; i++) {


            mineRow = (int) (Math.random() * row);
            mineCol = (int) (Math.random() * col);



            if(mineArray[mineRow][mineCol].equals("*")){
                i--;
            } else {
                mineArray[mineRow][mineCol] = "*";
            }

        }

        // Display mine locations
        System.out.println("\nMines Locations");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mineArray[i][j] + " ");
            }
            System.out.println();
        }

        int userRow, userCol;
        do {
            int temp = 0;

            // Prompt the user to enter the destination row and column
            do {
                System.out.print("Please enter the destination row\t: ");
                isInt(input);
                userRow = input.nextInt();

                System.out.print("Please enter the destination column\t: ");
                isInt(input);
                userCol = input.nextInt();
                System.out.println("=====================================");

                // Check if the user input is valid
                if (!((userRow < row && userRow >= 0) && (userCol >= 0 && userCol < col))) {
                    System.out.println("Invalid destination. Please try again!!");
                }
            } while (!((userRow < row && userRow >= 0) && (userCol >= 0 && userCol < col)));

            // Check if the user has hit a mine
            if (mineArray[userRow][userCol].equals("*")) {
                System.out.println("GAME OVER !!!");
                break;
            }

            // Calculate the number of neighboring mines
            temp = neighborMineCount(mineArray, userRow, userCol);

            // Decrement the move count if the user hasn't hit a mine
            if (mineArray[userRow][userCol].equals("-")) {
                moveCount--;
            }

            String mineCount = String.valueOf(temp);

            mineArray[userRow][userCol] = mineCount;

            // Display the current state of the game
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mineArray[i][j].equals("*")) {
                        System.out.print("- ");
                    } else {
                        System.out.print(mineArray[i][j] + " ");
                    }
                }
                System.out.println();
            }

            // Check if the player has won the game
            if (moveCount == 0) {
                System.out.println("You have emerged victorious! Congratulations! \uD83C\uDF89");
                break;
            }

        } while (!mineArray[userRow][userCol].equals("*"));
    }
}

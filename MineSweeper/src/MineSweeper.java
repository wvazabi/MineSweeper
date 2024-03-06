import java.util.Scanner;

public class MineSweeper {

    // Method to check if the input is an integer
    public static void isInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Invalid value please enter an integer number");
            input.next();
        }
    }

    // Method to check if the row and column values are valid
    public boolean isCheck(int row, int col) {
        if (row < 2 || col < 2) {
            System.out.println("Please enter a value of 2x2 or bigger!!");
            return false;
        }
        return true;
    }

    // Method to calculate the number of mines based on the total number of elements
    public int mineNumber(int element) {
        return element / 4;
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
            System.out.print("Enter row: ");
            isInt(input);
            row = input.nextInt();
            System.out.print("Enter col: ");
            isInt(input);
            col = input.nextInt();
            System.out.println("===========================");

        } while (!isCheck(row, col));

        String[][] arr = new String[row][col];
        String[][] mineArray = new String[row][col];

        int elementNum = (row * col);
        int mineNumber = mineNumber(elementNum); // Calculate the number of mines

        int moveCount = elementNum - mineNumber; // Calculate the number of moves

        // Generate random mine locations
        int mineRow, mineCol;
        for (int i = 0; i < mineNumber; i++) {
            mineRow = (int) (Math.random() * row);
            mineCol = (int) (Math.random() * col);
            mineArray[mineRow][mineCol] = "*";
        }

        // Display mine locations
        System.out.println("\nMines Locations");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mineArray[i][j] == null) {
                    mineArray[i][j] = "-";
                }
                System.out.print(mineArray[i][j] + " ");
            }
            System.out.println();
        }

        int userRow, userCol;
        do {
            int temp = 0;

            // Prompt the user to enter the destination row and column
            do {
                System.out.print("Enter destination row : ");
                isInt(input);
                userRow = input.nextInt();

                System.out.print("Enter destination col : ");
                isInt(input);
                userCol = input.nextInt();
                System.out.println("===========================");

                // Check if the user input is valid
                if (!((userRow < row && userRow >= 0) && (userCol >= 0 && userCol < col))) {
                    System.out.println("Please try again!!");
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
                System.out.println("Congratulations YOU WIN !!!");
                break;
            }

        } while (!mineArray[userRow][userCol].equals("*"));
    }
}
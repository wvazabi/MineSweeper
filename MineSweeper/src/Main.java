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


    public static int mineNumber(int element) {

        return element / 4;
    }

    public static int neighborMineCount(String[][] arr, int row, int col) {
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


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int row = 0;
        int col = 0;

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

        // Mine Count
        int mineNumber = mineNumber(elementNum);

        int moveCount = elementNum - mineNumber;

        //System.out.println("mine num = " + mineNumber);

        int mineRow, mineCol;

        for (int i = 0; i < mineNumber; i++) {
            mineRow = (int) (Math.random() * row);
            mineCol = (int) (Math.random() * col);
            mineArray[mineRow][mineCol] = "*";
        }

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

        // User input
        int userRow, userCol;

        do {
            int temp = 0;

            do {
                System.out.print("Enter destination row : ");
                isInt(input);
                userRow = input.nextInt();

                System.out.print("Enter destination col : ");
                isInt(input);
                userCol = input.nextInt();
                System.out.println("===========================");

                if (!((userRow < row && userRow >= 0) && (userCol >= 0 && userCol < col))) {
                    System.out.println("Please try again!!");
                }
            } while(!((userRow < row && userRow >= 0) && (userCol >= 0 && userCol < col)));

            if(mineArray[userRow][userCol].equals("*")) {
                System.out.println("GAME OVER !!!");
                break;
            }

            temp = neighborMineCount(mineArray,userRow,userCol);
           // System.out.println(temp);

            String mineCount = String.valueOf(temp);
            mineArray[userRow][userCol] = mineCount;

            //Mine control




            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if(mineArray[i][j].equals("*")){
                        System.out.print("- ");
                    } else{
                        System.out.print(mineArray[i][j] + " ");
                    }

                }
                System.out.println();

            }

            moveCount--;



            if(moveCount == 0) {
                System.out.println("Congratulations YOU WIN !!!");
                break;
            }


        } while (!mineArray[userRow][userCol].equals("*"));


//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//
//                arr[i][j] = "_";
//
//
//            }
//        }
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//
//        }


    }


}
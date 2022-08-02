import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    public static void run(int row, int col) {
        int NumberOfMines = (NumberOfMines(row, col));

        int[][] array = new int[row][col];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isMine(NumberOfMines)) {
                    array[i][j] = 10;
                    NumberOfMines--;
                } else {
                    array[i][j] = 11;
                }
            }
        }
        System.out.println("==============");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" # ");
            }
            System.out.println();
        }
        System.out.println("==============");

        while (choice(array, row, col)) ;
    }

    public static int NumberOfMines(int row, int col) {
        return row * col / 4;
    }

    public static boolean isMine(int NumberOfMines) {
        if (NumberOfMines == 0) {
            return false;
        }
        Random random = new Random();

        int a = (random.nextInt(2));
        if (a == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean choice(int array[][], int row, int col) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Satır Sayısı Giriniz: ");
        int choiceRow = scanner.nextInt();

        System.out.print("Sütun Sayısı Giriniz: ");
        int choiceCol = scanner.nextInt();

        if (!(choiceRow < array.length)) {
            System.out.println("Seçtiğiniz Satır Sayısı Oyundaki Satır Sayısından Fazla Olamaz!");
            return choice(array, row, col);
        }

        if (!(choiceCol < array[0].length)) {
            System.out.println("Seçtiğiniz Sütun Sayısı Oyundaki Satır Sayısından Fazla Olamaz!");
            return choice(array, row, col);
        }
        if (array[choiceRow][choiceCol] == 10) {
            System.out.println("Patladınız!");
            return false;
        }
        board(array, choiceRow, choiceCol);
        if (isWin(array)) {
            System.out.println("Tebrikler Kazandınız");
            return false;
        }
        return true;
    }


    static void board(int[][] array, int choiceRow, int choiceCol) {

        array[choiceRow][choiceCol] = checkArea(array, choiceRow, choiceCol);
        System.out.println("==============");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 10 && array[i][j] != 11) {
                    System.out.print(" " + array[i][j] + " ");
                } else {
                    System.out.print(" # ");
                }

            }
            System.out.println();
        }
        System.out.println("==============");


    }

    static int checkArea(int[][] array, int choiceRow, int choiceCol) {
        int count = 0;
        if (choiceCol == 0 && choiceRow == 0 && array[choiceRow][choiceCol] != 10) {
            // 0 a 0 Durumu
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol + 1] == 10) {
                count++;
            }
        } else if (choiceCol > 0 && choiceCol < array[choiceRow].length - 1 && choiceRow == 0 && array[choiceRow][choiceCol] != 10) {
            // 0 a üst durumu
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol - 1] == 10) {
                count++;
            }
        } else if (choiceCol == array[choiceRow].length - 1 && choiceRow == 0 && array[choiceRow][choiceCol] != 10) {
            // 0 a Sağ Üst Durumu
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
        } else if (choiceCol == array[choiceRow].length - 1 && choiceRow != 0 && choiceRow != array.length - 1 && array[choiceRow][choiceCol] != 10) {
            // sağa yapışık durum
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
        } else if (choiceCol == array[choiceRow].length - 1 && choiceRow == array.length - 1 && array[choiceRow][choiceCol] != 10) {
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
        } else if (choiceRow == array.length - 1 && choiceCol != 0 && choiceCol != array[choiceRow].length) {
            //en alt orta durumu
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
        } else if (choiceRow == array.length - 1 && choiceCol == 0) {
            //sol alt durumu
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol + 1] == 10) {
                count++;
            }
        } else if (choiceRow != 0 && choiceRow != array.length - 1 && choiceCol == 0) {
            //sola yapışık durumu
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
        } else {
            // ortada olan durum
            if (array[choiceRow + 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow + 1][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow][choiceCol - 1] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol + 1] == 10) {
                count++;
            }
            if (array[choiceRow - 1][choiceCol - 1] == 10) {
                count++;
            }
        }

        return count;
    }

    static boolean isWin(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((array[i][j] == 11) ) {
                    return false;
                }
            }
        }
        return true;
    }
}

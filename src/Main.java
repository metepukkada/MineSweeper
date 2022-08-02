import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz!");

        System.out.print("Satır Sayısı Giriniz: ");
        int x = scan.nextInt();
        System.out.print("Sütun Sayısı Giriniz: ");
        int y = scan.nextInt();

        MineSweeper mineSweeper = new MineSweeper();
        MineSweeper.run(x,y);


    }
}

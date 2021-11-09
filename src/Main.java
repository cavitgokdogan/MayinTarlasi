import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row, col;
        System.out.println("Mayın tarlasına hoş geldiniz!!!");

        System.out.print("Lütfen oynamak istediğiniz boyutları giriniz:\n");

        System.out.print("Satır: ");
        row = input.nextInt();
        System.out.print("Sütun: ");
        col = input.nextInt();

        MayinTarlasi mayin = new MayinTarlasi(row, col);
        mayin.run();
    }
}
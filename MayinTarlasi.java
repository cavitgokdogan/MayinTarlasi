import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber, colNumber, size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    MayinTarlasi(int rowNumber, int colNumber){
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.size = rowNumber * colNumber;
        this.map = new int[rowNumber][colNumber];
        this.board = new int[rowNumber][colNumber];
    }

    public void run(){
        int row, col, success = 0;
        prepareGame();
        print(map);
        System.out.println("Oyun başladı");
        while (game){
            print(board);

            System.out.print("Satır: ");
            row = input.nextInt();

            System.out.print("Sütun: ");
            col = input.nextInt();

            if (row < 0 || row >= rowNumber - 1){
                System.out.println("Geçersiz koordinat!!!");
                continue;
            }
            if (col < 0 || row >= colNumber - 1){
                System.out.println("Geçersiz koordinat!!!");
                continue;
            }

            if (map[row][col] != -1){
                checkMine(row, col);
                success++;
                if (success == (size - (size / 4))){
                    System.out.println("Oyun başarıyla tamamlandı!!!");
                    break;
                }
            }
            else{
                game = false;
                System.out.println("Game Over!!");
            }
        }
    }

    public void checkMine(int sat, int sut){
        if (map[sat][sut] == 0){
            if ((sat < rowNumber - 1) && (map[sat + 1][sut] == -1)){
                board[sat][sut]++;
            }
            if ((sat > 0) && (map[sat - 1][sut] == -1)){
                board[sat][sut]++;
            }
            if ((sut < colNumber - 1) && (map[sat][sut + 1] == -1)){
                board[sat][sut]++;
            }
            if ((sut > 0) && (map[sat][sut - 1] == -1)){
                board[sat][sut]++;
            }

            if (board[sat][sut] == 0){
                board[sat][sut] = -2;
            }

        }
    }

    public void prepareGame(){
        int randRow, randCol, count = 0;
        while(count != (size / 4)){
            randRow = rand.nextInt(rowNumber);
            randCol = rand.nextInt(colNumber);

            if (map[randRow][randCol] != -1){
                map[randRow][randCol] = -1;
                count++;
            }
        }
    }

    public void print(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] >= 0){
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
package packfull;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Matrix {
   public int length;
   public double[][] matrix;

    public Matrix() {
        length = counter() + 1;
        matrix = new double[length][length];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                matrix[i][j] = 0;
                matrix[j][i] = 0;
            }

    }

    public void read() {

        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while (sc.hasNext()) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                matrix[a][b] = c;
                matrix[b][a] = c;

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void write() {

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int counter() {
        Integer ans = -1;

        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while (sc.hasNext()) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if (a > ans)
                    ans = a;
                if (b > ans)
                    ans = b;

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ans;

    }
}
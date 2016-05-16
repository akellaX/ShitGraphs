import packfull.Matrix;

import java.util.Vector;

public class Main {

    public static void func(int k, int[][] matrix, int[] arr, int[] path) {


        for (int s = arr.length - 2; s >= 0; s--) {

            if (matrix[k][s] != 0) {
                if (matrix[k][s] + arr[k] < arr[s]) {
                    arr[s] = matrix[k][s] + arr[k];
                    path[s] = k;

                }
                if (matrix[k][s] + arr[s] < arr[k]) {
                    arr[k] = matrix[k][s] + arr[s];
                    path[k] = s;
                }


                matrix[k][s] = 0;
                matrix[s][k] = 0;
                System.out.println("s=" + s + "k=" + k);


                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print(matrix[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();

                }

                for (int i = 0; i < arr.length; i++)
                    System.out.print(arr[i] + " ");
                System.out.println();


                func(s, matrix, arr, path);


            }


        }
    }


    public static void main(String[] args) {
        Matrix temp = new Matrix();
        temp.read();
        int a = temp.length;
        temp.write();
        int[] arr = new int[temp.length];
        int[] path = new int[temp.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100;
            path[i] = -1;
        }

        for (int i = a - 2; i >= 0; i--) {
            if (temp.matrix[i][a - 1] != 0) {
                {
                    arr[i] = temp.matrix[i][a - 1];
                    path[i]=temp.length-1;

                }

            }

        }
        for (int i = a - 2; i >= 0; i--) {
            if (temp.matrix[i][a - 1] != 0) {
                {
                    func(i, temp.matrix, arr, path);

                }

            }

        }


        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.print("0->");
        int k=0;

        do
        {
            if(path[k]>=0)
            {System.out.print(path[k]);
            System.out.print("->");}
            k=path[k];

        } while(k>=0);
        System.out.println();

        System.out.print("Sum="+arr[0]);




        }
    }





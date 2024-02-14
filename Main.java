import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Let's start by taking the inputs of X, Y, and Z shift registers;
        int[] X = new int[19];
        int[] Y = new int[22];
        int[] Z = new int[23];

//        int[] X = {1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0};
//        int[] Y = {0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1};
//        int[] Z = {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1};

        System.out.println("Enter the values of X shift registers");
        for (int i = 0; i < X.length; i++) {
            System.out.println("Index[" + i + "]");
            X[i] = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Enter the values of Y shift registers");
        for (int i = 0; i < Y.length; i++) {
            System.out.println("Index[" + i + "]");
            Y[i] = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.println("Enter the values of Z shift registers");
        for (int i = 0; i < Z.length; i++) {
            System.out.println("Index[" + i + "]");
            Z[i] = scanner.nextInt();
        }
        scanner.nextLine();

        //Next let's start the permutation
        System.out.println("Enter the number of permutation:");
        int n = scanner.nextInt();

        int counter = 0;
        while (counter != n) {

            //Calculate the majority bit amongst x[8], y[10], z[10]
            int maj = 0;
            if (X[8] + Y[10] + Z[10] > 1) {
                maj = 1;
            } else {
                maj = 0;
            }

            //Then performing the necessary operations
            if (X[8] == maj) {
                int xTemp = X[13] ^ X[16] ^ X[17] ^ X[18];
                X[X.length - 1] = 0;
                //The idea here declaring the final index value as zero and swapping the value next to
                //zero till zero is at x[0]
                for (int i = X.length - 1; i > 0; i--) {
                    int temp = X[i];
                    X[i] = X[i - 1];
                    X[i - 1] = temp;
                }
                //Assigning the value of XOR operation to x[0]
                X[0] = xTemp;
            }
            if (Y[8] == maj) {
                int yTemp = Y[20] + Y[21];
                Y[Y.length - 1] = 0;
                for (int i = Y.length - 1; i > 0; i--) {
                    int temp = Y[i];
                    Y[i] = Y[i - 1];
                    Y[i - 1] = temp;
                }
                Y[0] = yTemp;
            }
            if (Z[10] == maj) {
                int zTemp = Z[7] ^ Z[20] ^ Z[21] ^ Z[22];
                Z[Z.length - 1] = 0;
                for (int i = Z.length - 1; i > 0; i--) {
                    int temp = Z[i];
                    Z[i] = Z[i - 1];
                    Z[i - 1] = temp;
                }
                Z[0] = zTemp;
            }
            //Calculating the bit that will go to the key stream
            int keyBit = X[X.length - 1] ^ Y[Y.length - 1] ^ Z[Z.length - 1];
            System.out.print(keyBit);
            counter++;
        }
    }
}


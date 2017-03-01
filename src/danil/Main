public class Main {

    public static void main(String[] args) {

        fibonacci(15);

    }
    static int[] fibonacci(int n) {
        int[] F = new int[n];
        int k = n - 1;
        F[0] = 0;
        F[1] = 1;
        System.out.println(F[1]);
        for (int i = 2; i <= k; i++) {
            int i2 = i - 2;
            int i1 = i - 1;
            F[i] = F[i1] + F[i2];
            System.out.println(F[i]);
        }
        return F;
    }

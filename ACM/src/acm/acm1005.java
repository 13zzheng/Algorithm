package acm;

import java.util.Scanner;

public class acm1005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int n = sc.nextInt();
            if (a == 0 && b == 0 && n == 0) {
                break;
            }
            int f = 1;
            int s = 1;
            for (int i = 2; i < n%49; i++) {
                int temp = f;
                f = (a * f + b * s) % 7;
                s = temp;
            }
            System.out.println(f);

        }
    }
}

package Baekjoon.CLASS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for (int i = 3; i >= 1; i--) {
            String num = br.readLine();
            if ('F' != num.charAt(0) && 'B' != num.charAt(0)) {
                result = Integer.parseInt(num) + i;
            }
        }
        if (result % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (result % 3 == 0) {
            System.out.println("Fizz");
        } else if (result % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(result);
        }
    }
}

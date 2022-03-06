package first;

import java.util.Scanner;

public class hw1 {

    /*
    Fizz-buzz:
    если число делится на 3 – fizz, на 5 - buzz, на 3 и 5 – fizzbuzz
     */
    public static void FizzBuzz(int x)
    {
        if (x%3==0 || x%5==0)
        {
            if (x%3==0 && x%5==0) {
                System.out.println("Fizz-Buzz.");}
            else if(x%3== 0) {
                System.out.println("Fizz.");}
            else {
                System.out.println("Buzz.");}
        }
        else {
            System.out.println("Number indivisible by 3 or 5.");}
    }

    /*
      Вычисление числа Фибоначчи n
      ряд начинается с 0
    */
    public static int FibonacciValue(int n)
    {
        if(n == 0) { //0 элемент
            return 0;
        } else if (n <= 2) { //1 и 2 элемент
            return 1;}
        else { //2 и дальше
            return (FibonacciValue(n-1) + FibonacciValue(n-2));
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter value to perform fizz-buzz problem:");
        FizzBuzz(scan.nextInt());
        System.out.println("Enter value to find a value of Fibonacci sequence:");
        int n = scan.nextInt();
        System.out.println(n + "-th value of Fibonacci sequence: " + FibonacciValue(n));

        scan.close();
    }
}

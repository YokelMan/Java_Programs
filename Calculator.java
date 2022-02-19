/*A program to make a calculator with infinite inputs, taking input from the console and exiting when a particular
* number is entered.*/

import java.util.Scanner;

public class Calculator {

    static void calculate() {
        Scanner sc = new Scanner(System.in);
        char operation;
        double sum, product, num, quotient;
        boolean wantToContinue = true;
        while(wantToContinue) {
            sum = 0;
            product = 1;
            System.out.println("Enter which operation you want to perform: (+/-), *, /");
            operation = sc.next().charAt(0);
            switch(operation) {
                case '+':
                case '-':
                    System.out.println("Enter a sequence of numbers for the operation, put negative numbers for subtraction; enter 0 to exit.");
                    do {
                        num = sc.nextDouble();
                        sum += num;
                    } while(num != 0d);
                    System.out.println("The result of your addition/subtraction is: " + sum);
                    break;
                case '*':
                    System.out.println("Enter a sequence of numbers to be multiplied; enter 1 to exit.");
                    do {
                        num = sc.nextDouble();
                        product *= num;
                    } while(num != 1d);
                    System.out.println("The result of your multiplication is: " + product);
                    
                    break;
                case '/':
                    System.out.println("Enter your dividend: ");
                    quotient = sc.nextDouble();
                    System.out.println("Now enter your divisor, enter 1 to exit and enter multiple divisors for repeated " +
                            "division: ");
                    do {
                        num = sc.nextDouble();
                        quotient /= num;
                    } while(num != 1);
                    System.out.println("The result of your division is: " + quotient);
                    break;
                default:
                    System.out.println("Invalid input!");
            }
            System.out.println("\nDo you want to continue: True or False");
            wantToContinue = sc.nextBoolean();
        }
        System.out.println("Program terminated successfully.");
        sc.close();
    }
}

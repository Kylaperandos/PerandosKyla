/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package activity1.pkg2.perandos;

import java.util.Scanner;

/**
 *
 * @author Kyla
 */
public class ACTIVITY12PERANDOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a positive integer to check if it's a prime number: ");
            int number = scanner.nextInt();
            
            if (number <= 1) {
                System.out.println("Please enter a positive integer greater than 1.");
            } else {
                boolean isPrime = checkPrime(number);
                
                if (isPrime) {
                    System.out.println(number + " is a prime number.");
                } else {
                    System.out.println(number + " is not a prime number.");
                }
            }
        }
    }

    private static boolean checkPrime(int number) {
        if (number == 2) {
            return true; // 2 is a prime number
        }

        if (number % 2 == 0 || number == 1) {
            return false; // Any even number (except 2) and 1 are not prime
        }

        int divisor = 3;

        // Use a do-while loop to check divisibility by odd numbers from 3 to the square root of the number
        do {
            if (number % divisor == 0) {
                return false; // If the number is divisible, it's not prime
            }
            divisor += 2; // Move to the next odd divisor
        } while (divisor <= Math.sqrt(number));

        return true; // If no divisor is found, the number is prime
    }
}

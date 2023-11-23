/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package activity.pkg1.pkg3.perandos;

import java.util.Scanner;

/**
 *
 * @author Kyla
 */
public class ACTIVITY13PERANDOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter an integer to generate its multiplication table: ");
            int number = scanner.nextInt();
            
            System.out.println("Multiplication Table for " + number + ":");
            
            // Use a for loop to iterate through numbers from 1 to 10
            for (int i = 1; i <= 10; i++) {
                int product = number * i;
                System.out.println(number + " x " + i + " = " + product);
            }
        }
    }
}

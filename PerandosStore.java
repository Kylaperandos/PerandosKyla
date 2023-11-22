/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perandos.store;

import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class PerandosStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        String customerName = JOptionPane.showInputDialog("Welcome to the FOODTrove - Explore, Click, Savor!\nEnter your name:");

        if (customerName == null || customerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid name. Exiting.");
            return;
        }

        int choice = 0;
        do {
            String[] options = {"What's Available", "Exit"};
            choice = JOptionPane.showOptionDialog(
                    null,
                    "Hello, " + customerName + "! Explore our food express with big discount.",
                    "FOODTrove",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                viewAvailableFoodItems();
            }

        } while (choice == 0);

        JOptionPane.showMessageDialog(null, "Thank you for choosing FOODTrove! A feast for your senses, delivered to your door!");
    }

    public static void viewAvailableFoodItems() {
        String[] foodItems = {
            "Hawaian Delight Pizza - ₱290",
            "BFF Shake Shake Fries - ₱124",
            "Coke Float - ₱55",
            "BigMac Burger - ₱97",
            "Ala King - ₱89"
        };

        String selectedItems = "";
        double totalCost = 0.0;

        while (true) {
            String foodChoice = (String) JOptionPane.showInputDialog(
                    null,
                    "Available food items:",
                    "FOODTrove",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    foodItems,
                    foodItems[0]
            );

            if (foodChoice == null) {
                break;
            }

            double itemPrice = 0.0;

            if (foodChoice.contains("Hawaian Delight Pizza")) {
                itemPrice = 290.0;
            } else if (foodChoice.contains("BFF Shake Shake Fries")) {
                itemPrice = 124.0;
            } else if (foodChoice.contains("Coke Float")) {
                itemPrice = 55.0;
            } else if (foodChoice.contains("BigMac Burger")) {
                itemPrice = 97.0;
            } else if (foodChoice.contains("Ala King")) {
                itemPrice = 89.0;
            }

            totalCost += itemPrice;
            selectedItems += foodChoice + " - ₱" + itemPrice + "\n";
        }

        if (!selectedItems.isEmpty()) {
            // Calculate a discount of 10% if the total cost is more than ₱300
            double discount = totalCost > 300 ? 0.10 : 0.0;
            double discountedTotal = totalCost - (totalCost * discount);

            String message = "You've selected the following food items:\n" + selectedItems
                    + "Total Cost: ₱" + totalCost + "\n"
                    + "Discounted Total Cost: ₱" + discountedTotal;

            JOptionPane.showMessageDialog(null, message);

            // Process payment
            processPayment(discountedTotal);
        }
    }

    public static void processPayment(double totalAmount) {
        
        // Get cash input from the customer
        String cashInput = JOptionPane.showInputDialog(null, "Please enter the amount in cash:");

        if (cashInput == null || cashInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input. Exiting.");
            return;
        }

        try {
            double cashAmount = Double.parseDouble(cashInput);

            if (cashAmount < totalAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient cash. Exiting.");
                return;
            }

            double change = cashAmount - totalAmount;

            String paymentMessage = "Payment successful!\n"
                    + "Total Amount: ₱" + totalAmount + "\n"
                    + "Cash Received: ₱" + cashAmount + "\n"
                    + "Change: ₱" + change;

            JOptionPane.showMessageDialog(null, paymentMessage);

            // Simulate a conversation with the seller
            JOptionPane.showMessageDialog(null, "Seller: Thank you, and enjoy your meal!");

            // You can add more interactions between the customer and seller here
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Exiting.");
        }
    }
}
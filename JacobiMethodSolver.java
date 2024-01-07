import javax.swing.JOptionPane;

public class JacobiMethodSolver {
    public static void main(String[] args) {
        while (true) {
            // Get user input for the system of linear equations
            int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of variables in the system (or enter 0 to exit):"));

            if (n == 0) {
                // Exit the program if the user enters 0
                JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            double[][] coefficients = new double[n][n];
            double[] constants = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    String inputValue = JOptionPane.showInputDialog("Enter the coefficient for x" + (j + 1) + " in equation " + (i + 1) + ":");
                    if (inputValue == null) {
                        // Cancel the operation if the user presses cancel
                        JOptionPane.showMessageDialog(null, "Operation canceled. Please enter the number of variables again.", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                    coefficients[i][j] = Double.parseDouble(inputValue);
                }
                String inputValue = JOptionPane.showInputDialog("Enter the constant term in equation " + (i + 1) + ":");
                if (inputValue == null) {
                    // Cancel the operation if the user presses cancel
                    JOptionPane.showMessageDialog(null, "Operation canceled. Please enter the number of variables again.", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                constants[i] = Double.parseDouble(inputValue);
            }

            // Get user input for the initial guess
            double[] initialGuess = new double[n];
            for (int i = 0; i < n; i++) {
                String inputValue = JOptionPane.showInputDialog("Enter the initial guess for x" + (i + 1) + ":");
                if (inputValue == null) {
                    // Cancel the operation if the user presses cancel
                    JOptionPane.showMessageDialog(null, "Operation canceled. Please enter the number of variables again.", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                initialGuess[i] = Double.parseDouble(inputValue);
            }

            // Check if the operation was canceled
            if (initialGuess.length < n) {
                continue;
            }

            // Get user input for the maximum number of iterations
            String maxIterationsInput = JOptionPane.showInputDialog("Enter the maximum number of iterations:");
            if (maxIterationsInput == null) {
                // Cancel the operation if the user presses cancel
                JOptionPane.showMessageDialog(null, "Operation canceled. Please enter the number of variables again.", "Cancel", JOptionPane.INFORMATION_MESSAGE);
                continue;
            }
            int maxIterations = Integer.parseInt(maxIterationsInput);

            // Solve the system using the Jacobi method
            double[] solution = jacobiMethod(coefficients, constants, initialGuess, maxIterations);

            // Display the solution using JOptionPane
            StringBuilder resultMessage = new StringBuilder("Solution:\n");
            for (int i = 0; i < n; i++) {
                resultMessage.append("x").append(i + 1).append(" = ").append(solution[i]).append("\n");
            }

            JOptionPane.showMessageDialog(
                    null,
                    resultMessage.toString(),
                    "Jacobi Method Solution",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Ask the user if they want to continue or exit
            int option = JOptionPane.showOptionDialog(
                    null,
                    "Do you want to continue or exit?",
                    "Continue or Exit",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Continue", "Exit"},
                    "Continue"
            );

            if (option == JOptionPane.NO_OPTION) {
                // Exit the program if the user chooses to exit
                JOptionPane.showMessageDialog(null, "Exiting the program. Goodbye!", "Exit", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }

    private static double[] jacobiMethod(double[][] coefficients, double[] constants,
                                         double[] initialGuess, int maxIterations) {
        int n = constants.length;
        double[] currentSolution = initialGuess.clone();
        double[] nextSolution = new double[n];

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            for (int i = 0; i < n; i++) {
                double sum = constants[i];
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= coefficients[i][j] * currentSolution[j];
                    }
                }
                nextSolution[i] = sum / coefficients[i][i];
            }

            currentSolution = nextSolution.clone();
        }

        return currentSolution;
    }
}

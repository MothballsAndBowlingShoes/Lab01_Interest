///////////////////////////////////////////////////////////
/// Lab01_Interest
///
/// CIS-023, Freeman Lo
///
/// Created by Atticus Young on 07/02/2025
///
///////////////////////////////////////////////////////////

import javax.swing.*;

public class Main {
    private final static double INTEREST_RATE = 4.25;               // The interest rate used to calculate Compound Interest.
    private final static int TIMES_COMPOUNDED_PER_YEAR = 12;        // The number of times that Interest is Compounded per a Year.
    private final static int NUMBER_OF_YEARS = 1;                   // The number of years it is calculating for.

    private static final int NUMBER_OF_DECIMAL_PLACES = 2;          // The number of Decimal Places to round too when converting to currency format.
    private static final int DECIMAL_BASE = 10;                     // The base of the Decimal for rounding.

    private static final int COMPOUNDING_BASE = 1;                  // The base value used in the compound calculation.
    private static final int PERCENTAGE_CONVERSION_FACTOR = 100;    // The conversion factor used to convert a percentage to a decimal for use in the formula.


    public static void main(String[] args) {
        JFrame mainWindow = new JFrame(); // The main window used by the Application.

        // The declaration of all the UI Elements.
        JLabel principalLabel = new JLabel("Principal:");
        JTextField principalInput = new JTextField();
        JLabel compoundInterestLabel = new JLabel("Compound Interest:");
        JTextField compoundInterestResult = new JTextField();
        JButton calculateButton = new JButton("Calculate");

        // Sets the bounds for all UI elements.
        principalLabel.setBounds(150, 50, 220, 50);
        principalInput.setBounds(150, 100, 220, 50);
        compoundInterestLabel.setBounds(150, 150, 220, 50);
        compoundInterestResult.setBounds(150, 200, 220, 50);
        calculateButton.setBounds(150, 300, 220, 75);

        // Adds all the UI Elements to the MainWindow element.
        mainWindow.add(principalLabel);
        mainWindow.add(principalInput);
        mainWindow.add(compoundInterestLabel);
        mainWindow.add(compoundInterestResult);
        mainWindow.add(calculateButton);


        mainWindow.setSize(500, 400); // Sets the size of the user window.


        compoundInterestResult.setEditable(false); // Makes it where the window that displays the result is not editable.

        mainWindow.setLayout(null); // Sets the layout manager to null.

        mainWindow.setVisible(true); // Makes the window visible.

        // Code that handles when the button is clicked
        calculateButton.addActionListener(_ -> {
            // If the Principal Input box has nothing in it, display the error message; Otherwise calculate and display the proper result.
            if (principalInput.getText().isEmpty()) {
                compoundInterestResult.setText("Please input a proper number.");
            } else {
                compoundInterestResult.setText(formatInterest(principalInput));

            }
        });
    }

    private static String formatInterest(JTextField principalInput) {
        // Gets the input text and parses it as a double.
        String principalText = principalInput.getText();
        double principal = Double.parseDouble(principalText);

        // Calculates the interest and rounds it.
        double interest = calculateInterest(principal);
        double roundedInterest = roundDecimal(interest);

        // Formats the result with a dollar sign and updates the text field.
        return "$" + roundedInterest;
    }

    // The formula used to calculate interest. Equivalent too f(x) = P*(1+r/n)^(nt).
    private static double calculateInterest(double principal) {
        return principal * Math.pow(
                (COMPOUNDING_BASE + (INTEREST_RATE/ PERCENTAGE_CONVERSION_FACTOR) / TIMES_COMPOUNDED_PER_YEAR),
                NUMBER_OF_YEARS * TIMES_COMPOUNDED_PER_YEAR);
    }

    // The formula used to round numbers. Equivalent too f(x) = round(x * DECIMAL_BASE^NUMBER_OF_DECIMAL_PLACES) / DECIMAL_BASE^NUMBER_OF_DECIMAL_PLACES.
    private static double roundDecimal(double decimalToRound) {
        return Math.round(decimalToRound * Math.pow(DECIMAL_BASE, NUMBER_OF_DECIMAL_PLACES))/Math.pow(DECIMAL_BASE, NUMBER_OF_DECIMAL_PLACES);
    }
}
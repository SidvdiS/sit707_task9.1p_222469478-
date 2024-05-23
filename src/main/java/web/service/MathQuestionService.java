package web.service;

public class MathQuestionService {

    public static Double q1Addition(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 + num2;
        } catch (NumberFormatException e) {
            // Log the error if necessary
            System.err.println("Invalid number format: " + e.getMessage());
            return null;
        }
    }

    // Similarly implement q2Subtraction and q3Multiplication
    public static Double q2Subtraction(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 - num2;
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            return null;
        }
    }

    public static Double q3Multiplication(String number1, String number2) {
        try {
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            return num1 * num2;
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + e.getMessage());
            return null;
        }
    }
}

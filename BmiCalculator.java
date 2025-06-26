import java.util.Scanner;

public class BmiCalculator {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
boolean keepRunning = true;

System.out.println("=== Welcome to the BMI Calculator ===\n");

while (keepRunning) {
double weight = getValidInput(scanner, "Enter your weight in kilograms: ");
double height = getValidInput(scanner, "Enter your height in meters: ");

double bmi = calculateBmi(weight, height);
System.out.printf("Your BMI is: %.2f\n", bmi);
displayBmiCategory(bmi);

System.out.print("\nWould you like to calculate again? (yes/no): ");
String response = scanner.next().toLowerCase();
keepRunning = response.equals("yes");
System.out.println();
}

System.out.println("Thank you for using the BMI Calculator. Stay healthy!");
scanner.close();
}

public static double getValidInput(Scanner scanner, String prompt) {
double value = -1;
while (value <= 0) {
System.out.print(prompt);
if (scanner.hasNextDouble()) {
value = scanner.nextDouble();
if (value <= 0) {
System.out.println("Value must be greater than zero. Please try again.");
}
} else {
System.out.println("Invalid input. Please enter a numeric value.");
scanner.next(); // clear invalid input
}
}
return value;
}

public static double calculateBmi(double weight, double height) {
return weight / (height * height);
}

public static void displayBmiCategory(double bmi) {
if (bmi < 18.5) {
System.out.println("Category: Underweight");
System.out.println("Tip: Consider a balanced diet and consult a healthcare provider.");
} else if (bmi < 25) {
System.out.println("Category: Normal weight");
System.out.println("Tip: Keep up the healthy habits!");
} else if (bmi < 30) {
System.out.println("Category: Overweight");
System.out.println("Tip: A bit more physical activity might help.");
} else {
System.out.println("Category: Obese");
System.out.println("Tip: It might be wise to consult a medical professional.");
}
}
}

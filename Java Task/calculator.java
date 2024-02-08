import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();
            int totalMarks = 0;
            for (int i = 1; i <= numSubjects; i++) {
                int marks;
                do {
                    System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                    marks = scanner.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid input! Marks should be between 0 and 100. Please try again.");
                    }
                } while (marks < 0 || marks > 100);
                totalMarks += marks;
            }
            double averagePercentage = (double) totalMarks / numSubjects;
            char grade = calculateGrade(averagePercentage);
            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");
            System.out.println("Grade: " + grade);
            if (grade == 'A') {
                System.out.println("Excellent work! Keep it up!");
            } else if (grade == 'B') {
                System.out.println("Well done! You're doing great!");
            } else if (grade == 'C') {
                System.out.println("Good job! Your performance is satisfactory.");
            } else if (grade == 'D') {
                System.out.println("Aim to do better next time. You can improve!");
            } else if (grade == 'E') {
                System.out.println("You need to work harder to improve.");
            } else {
                System.out.println("Opportunity to aim higher next time. More practice is needed.");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: Please enter valid input. " + e.getMessage());
        }
    }
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 75) {
            return 'B';
        } else if (averagePercentage >= 65) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else {
            return 'F';
        }
    }
}

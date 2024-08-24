import java.util.Scanner;

public class StudentgradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Number of Subjects
        int numSubjects;
        System.out.println("Enter the number of subjects");
        numSubjects = scanner.nextInt();

        //Array to store marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        //Input marks for each subject
        for (int i = 0; i< numSubjects; i++) 
        {
            System.out.println("Enter marks for Subject" + (i+1) + "(out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        //Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        //Calculate grade
        char grade;
        if(averagePercentage >=90) {
            grade='A';
        } else if (averagePercentage >=80) {
            grade='B';
        } else if (averagePercentage >=70) {
            grade='C';
        } else if (averagePercentage >=60 ) {
            grade= 'D';
        } else if (averagePercentage >=50 ) {
            grade ='E';
        } else {
            grade ='F';
        }

        //Display results
        System.out.println("\n--- Results ----" );
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade : " + grade);

        scanner.close();
    }
}

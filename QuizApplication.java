import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    private static final int TIME_LIMIT_PER_QUESTION = 10; // in seconds
    private static final int TOTAL_QUESTIONS = 5;
    private static int currentQuestion = 0;
    private static int score = 0;

    private static String[] questions = {
        "Which animal is known as the 'Ship of the Desert'?",
        "How many days are there in a week?",
        "How many hours are there in a day?",
        "Rainbow consists of how many colours?",
        "How many minutes are there in an hour?"
    };

    private static String[][] options = {
        {"A. Dog", "B. Cat", "C. Camel", "D. Tiger"},
        {"A. 2 days", "B. 8 days", "C. 7 days", "D. 4 days"},
        {"A. 20 hours", "B. 14 hours", "C. 10 hours", "D. 24 hours"},
        {"A. 5 Colours", "B. 7 Colours", "C. 11 Colours", "D. 8 Colours"},
        {"A. 60 Minutes", "B. 10 Minutes", "C. 5 Minutes", "D. 12 Minutes"}
    };

    private static char[] answers = {'C', 'C', 'D', 'B', 'A'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (currentQuestion = 0; currentQuestion < TOTAL_QUESTIONS; currentQuestion++) {
            startQuestion(scanner);
        }
        endQuiz();
    }

    private static void startQuestion(Scanner scanner) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up for question " + (currentQuestion + 1));
                nextQuestion();
                timer.cancel();
            }
        };

        // Schedule the timer to execute after TIME_LIMIT_PER_QUESTION seconds
        timer.schedule(task, TIME_LIMIT_PER_QUESTION * 1000);

        displayQuestion();

        long startTime = System.currentTimeMillis();
        char userAnswer = ' ';
        boolean answered = false;

        while (System.currentTimeMillis() - startTime < TIME_LIMIT_PER_QUESTION * 1000) {
            if (scanner.hasNext()) {
                userAnswer = scanner.next().toUpperCase().charAt(0);
                answered = true;
                break;
            }
        }

        timer.cancel();

        if (!answered) {
            System.out.println("No answer given in time.");
        } else if (userAnswer == answers[currentQuestion]) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
    }

    private static void displayQuestion() {
        System.out.println("Question " + (currentQuestion + 1) + ": " + questions[currentQuestion]);
        for (String option : options[currentQuestion]) {
            System.out.println(option);
        }
        System.out.print("Your answer: ");
    }

    private static void nextQuestion() {
        System.out.println("Moving to next question...");
    }

    private static void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + TOTAL_QUESTIONS);
    }
}


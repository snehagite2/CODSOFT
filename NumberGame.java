import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        int guess;
        n=1+(int)(100*Math.random());
        int i=0;
        System.out.println("WELCOME TO THE NUMBER GAME");
        System.out.println("GUESS THE CORRECT NUMBER TO WIN");
        while (i<=5) {
            guess = sc.nextInt();
            if(guess==n) {
                System.out.println("CONGRATULATIONS YOU GOT THE RIGHT CHOICE: "+n);
            }
            else if(guess>n) {
                System.out.println("HINT!!!!!!!\n THE NUMBER IS LOWER THAN YOUR CHOICE" + guess );
            }
            else {
                System.out.println("HINT!!!!!!!\n THE NUMBER IS GREATER THAN YOUR CHOICE" + guess);
            }
            i++;
            if (i==5) {
                System.out.println("YOU HAVE LOST ALL THE CHANCES \n"+  "THE CORRECT ANSWER IS :" +n);
            }
        }

    }    
}

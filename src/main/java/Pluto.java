import java.util.Scanner;

public class Pluto {
    public static void main(String[] args) {
        String greeting = "Hi! I am Pluto\n" + "What can I do for you today? \n\n";
        String goodbye = "Bye! Hope to see you again :)";
        System.out.println(greeting);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.equals("bye")) {
                System.out.println(goodbye);
                break;
            }

            System.out.println(input);
        }

        scanner.close();
    }
}

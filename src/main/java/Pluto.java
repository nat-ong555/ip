import java.util.Scanner;

public class Pluto {
    private Message message;

    public Pluto() {
        this.message = new Message();
    }

    public void run() {
        message.showWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            if (input.equals("bye")) {
                message.showGoodbyeMessage();
                break;
            }

            System.out.println(input);
        }

        scanner.close();
    }
    public static void main(String[] args) {
        new Pluto().run();
    }
}

package lambda.task2;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Command command1 = (str) -> System.out.println(str);
        Command command2 = System.out::println;
        Command command3 = new Command() {
            @Override
            public void doSomething(String str) {
                System.out.println(str);
            }
        };
        CommandClass command4 = new CommandClass();

        Scanner scanner = new Scanner(System.in);
        MainLoop:
        while (true) {
            System.out.print("Enter number of command name:\n" +
                    "1. Lambda function\n" +
                    "2. Method reference\n" +
                    "3. Anonymous class\n" +
                    "4. Object of command class\n");
            String commandName = scanner.next().toLowerCase();
            System.out.print("Now enter argument: ");
            switch (commandName) {
                case "1":
                case "lambda function":
                    command1.doSomething(scanner.next()); break;
                case "2":
                case "method reference":
                    command2.doSomething(scanner.next()); break;
                case "3":
                case "anonymous class":
                    command3.doSomething(scanner.next()); break;
                case "4":
                case "object of command class":
                    command4.doSomething(scanner.next()); break;
                default:
                    System.out.println("something wrong...");
            }
            while (true) {
                System.out.println("Do you want to continue?(y/n)");
                switch (scanner.next()) {
                    case "y":
                        continue MainLoop;
                    case "n":
                        break MainLoop;
                }
            }
        }
    }
}

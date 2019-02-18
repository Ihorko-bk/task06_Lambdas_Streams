package lambda.task2;

public class CommandClass implements Command {
    @Override
    public void doSomething(String str) {
        System.out.println(str);
    }
}

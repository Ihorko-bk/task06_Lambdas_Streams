package lambda.task1;

public class Main {
    public static void main(String[] args) {
        FuncInterface lambda1 = (i1, i2, i3) ->  Math.max(i1, Math.max(i2, i3));
        FuncInterface lambda2 = (i1, i2, i3) ->  (i1+i2+i3)/3;
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        System.out.println(lambda1.someMethod(i1, i2, i3));
        System.out.println(lambda2.someMethod(i1, i2, i3));
    }
}
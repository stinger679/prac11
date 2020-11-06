package task3;

public class TestEvaluate {
    public static void main(String[] args) {
        int result1 = new Equation(new Const(1, 2, 1), new Operations('-', '+')).evaluate(10);//x^2 - 2x + 1
        System.out.println(result1);
        int result2 = new Equation(new Const(2, 3), new Operations('-')).evaluate(5); //2x - 3
        System.out.println(result2);
    }
}
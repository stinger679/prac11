package task4;

public class Test {
    public static void main(String[] args) {
        //System.out.println(new Equation("1000000*x*x*x*x*x/(x-1)", 1, 0, 0).evaluate()); there is Division by zero
        System.out.println(new Equation("1000000*x*x*x*x*x/(x-1)", 2, 0, 0).evaluate());
        System.out.println(new Equation("1000000*x*x*x*x*x/(x-1)", 3, 0, 0).evaluate());
        System.out.println(new Equation("1000000*x*x*x*x*x/(x-1)", 4, 0, 0).evaluate());
        //System.out.println(new Equation("1000000*x*x*x*x*x/(x-1)", 4, 0, 0).evaluate()); there is Overflow

        System.out.println(new Equation("x*x + y*z - 15", 4, 2, 1).evaluate());
    }

}
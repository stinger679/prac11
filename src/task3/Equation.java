package task3;

public class Equation {
    Const c;
    Operations op;

    public Equation(Const c, Operations op)
    {
        this.c = c;
        this.op = op;
    }

    public int evaluate(int x)
    {
        int sum = 0;
        for(int i=c.arrOfConst.length-1; i>=0; i--)
            sum = calculate(sum, (int)(c.arrOfConst[i]*Math.pow(x, i)), op.operations[i]);
        return sum;
    }

    private int calculate(int a, int b, char c)
    {
        return switch (c)
                {
                    case '+'->a+b;
                    case '-'->a-b;
                    case '*'->a*b;
                    case '/'->a/b;
                    default -> b;
                };
    }
}
package task4;

import java.util.ArrayList;

public class Equation {
    private String equation;

    public Equation(String s, int x, int y, int z)
    {
        equation = s.replaceAll(" ", "");
        equation = equation.replace("x", Integer.toString(x));
        equation = equation.replace("y", Integer.toString(y));
        equation = equation.replace("z", Integer.toString(z));
        parse();
    }

    private void parse()
    {

        while(equation.indexOf('(') != -1){
            int open = equation.length();
            for(int i=0; i<equation.length(); i++)
            {
                if(equation.charAt(i)=='(')
                    open = i;
            }
            int close = open;
            for(int i=open; i<equation.length(); i++)
            {
                if(equation.charAt(i)==')'){
                    close = i;
                    break;
                }
            }
            String sub = equation.substring(open+1, close);
            String replace = Integer.toString(calculate(sub + " "));
            sub = "(" + sub + ")";
            equation = equation.replace(sub, replace);
        }
    }

    private String doSimple(String s)
    {
        while(s.indexOf('*')!=-1 || s.indexOf('/') != -1)
        {
            int j = 0;
            int num1 = 0;
            int num2 = 0;
            char operation = ' ';
            int i;
            int begin = 0;
            for(i=0; i<s.length(); i++){
                if(s.charAt(i)>=48 && s.charAt(i)<=57)
                    j++;
                else if(s.charAt(i)=='*' || s.charAt(i)=='/' ){
                    num1 = Integer.parseInt(s.substring(i-j, i));
                    operation = s.charAt(i);
                    begin = i-j;
                    j=0;
                    break;
                }
                else
                    j = 0;
            }
            int k;
            for(k=i+1; k<s.length(); k++){
                if(s.charAt(k)>=48 && s.charAt(k)<=57 || s.charAt(k)==45 && j == 0)
                    j++;
                else{
                    num2 = Integer.parseInt(s.substring(k-j, k));
                    break;
                }
            }
            int result = calculate(num1, num2, operation);
            if(num1>0 && num2>0 && result<0 || num1<0 && num2<0 && result<0){
                System.out.println("Overflow");
                System.exit(-1);
            }

            String sub = s.substring(begin, k);
            s = s.replace(sub, result+"");
        }
        return s;
    }

    private String correct(String s)
    {
        String sub = "";
        for(int i=0; i<s.length()-1; i++)
        {
            if(s.charAt(i)=='+' && s.charAt(i+1)=='-' || s.charAt(i)=='-' && s.charAt(i+1)=='+'){
                sub = s.substring(i, i+2);
                s = s.replace(sub, "-");
            }
            else if(s.charAt(i)=='-' && s.charAt(i+1)== '-' || s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                sub = s.substring(i, i+2);
                s = s.replace(sub, "+");
            }
        }
        return s;
    }

    private int calculate(String s)
    {
        s = doSimple(s);
        int j = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57)
                j++;
            else{
                arr.add(Integer.parseInt(s.substring(i-j, i)));
                op.append(s.charAt(i));
                j=0;
            }
        }
        int result = arr.get(0);
        for(int i=1; i<arr.size(); i++)
            result = calculate(result, arr.get(i), op.charAt(i-1));
        return result;
    }

    private int calculate(int a, int b, char c)
    {
        if(b==0 && c =='/'){
            System.out.println("Division by zero");
            System.exit(-1);
        }

        return switch (c)
                {
                    case '+'->a+b;
                    case '-'->a-b;
                    case '*'->a*b;
                    case '/'->a/b;
                    default -> b;
                };
    }

    public int evaluate()
    {
        int j = 0;
        equation = doSimple(equation + " ");
        equation = correct(equation);
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder op = new StringBuilder();
        for(int i=0; i<equation.length(); i++){
            if(equation.charAt(i)>=48 && equation.charAt(i)<=57)
                j++;
            else{
                arr.add(Integer.parseInt(equation.substring(i-j, i)));
                op.append(equation.charAt(i));
                j=0;
            }
        }
        int result = arr.get(0);
        for(int i=1; i<arr.size(); i++)
            result = calculate(result, arr.get(i), op.charAt(i-1));
        return result;
    }
}

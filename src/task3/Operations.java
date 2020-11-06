package task3;

public class Operations {
    char[] operations;

    public Operations(char... args)
    {
        int length = args.length+1;
        operations = new char[length];
        for(int i = length-2; i>=0; i--)
            operations[i] = args[length-2-i];
        operations[length-1] = '=';
    }
}
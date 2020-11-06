package task3;

public class Const {
    int[] arrOfConst;

    public Const(int... args)
    {
        arrOfConst = new int[args.length];
        for(int i= args.length-1; i>=0; i--)
            arrOfConst[i] = args[args.length-1-i];
    }
}
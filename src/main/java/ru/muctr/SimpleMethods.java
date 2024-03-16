package ru.muctr;

/**
 * @author Evgenia Skichko
 */
public class SimpleMethods {
    public static String getSomeString() {
        return "New string";
    }

    public int sum(int a, int b) throws ArithmeticException {
        return a+b;
    }

    public double sumDouble(double a, double b){
        return a+b;
    }

    public int division (int a, int b) throws ArithmeticException {return a/b;}

    public void printConsole(){
        System.out.print("Working");
    }

    public static void main(String[] args) {
        new SimpleMethods().division(5,0);
    }
}

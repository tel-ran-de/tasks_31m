package task1;

public class Main {
    public static void main(String[] args) {
        Class c = AnnotatedClass.class;
        RunTest.start(c);
        System.out.println();
        RunTest.start(c.getSimpleName());
    }
}
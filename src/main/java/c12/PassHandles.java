package c12;

public class PassHandles {
    static void f(PassHandles h) {
        System.out.println("h inside f():" + h);
    }

    public static void main(String[] args) {
        PassHandles passHandles = new PassHandles();
        System.out.println("p inside main():" + passHandles);
        f(passHandles);
    }
}

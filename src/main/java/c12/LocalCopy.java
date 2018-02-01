package c12;

class Myobject implements Cloneable {
    int i;

    public Myobject(int ii) {
        this.i = ii;
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("My object cant clone");
        }

        return o;
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }


}

public class LocalCopy {
    static Myobject g(Myobject obj) {
        obj.i++;
        return obj;
    }

    static Myobject f(Myobject v) {
        v = (Myobject) v.clone();
        v.i++;
        return v;
    }

    public static void main(String[] args) {
        Myobject a = new Myobject(11);
        Myobject b = g(a);
        System.out.println("a==b? " + (a == b));
        Myobject c = new Myobject(47);
        Myobject d = f(c);
        System.out.println("c==d? " + (c == d));
        System.out.println("c=" + c);
        System.out.println("d=" + d);

        String s1 = "abc";
        String s2 = "abc";
        String s3 = "sadfb;wih4trpowifdhsguino3i4ngoespiugnieurdfasdfasdfadsfwek;ghw;eiougdxhk;jgh;kaewlrjggiuewfdfsdfsdfdsfdsfddsdsfffffffffffsaferwgfggn";
        String s4 = "sadfb;wih4trpowifdhsguino3i4ngoespiugnieurdfasdfasdfadsfwek;ghw;eiougdxhk;jgh;kaewlrjggiuewfdfsdfsdfdsfdsfddsdsfffffffffffsaferwgfggn";
        String s5 = new String("abc");
        String s6 = new String("abc");
        System.out.println((s1 == s2));
        System.out.println((s3 == s4));
        System.out.println((s5 == s6));
    }
}

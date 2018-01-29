package c10;

import java.io.*;

class Blip3 implements Externalizable {
    int i;
    String s;    //	No	initialization

    int always = 11;

    public Blip3() {
        System.out.println("Blip3	Constructor");
        //	s,	i	not	initialized
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String	x,	int	a)");
        s = x;
        i = a;
    }

    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip3.writeExternal");
        //	You	must	do	this:
        out.writeObject(s);
        out.writeInt(i);
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        //	You	must	do	this:
        s = (String) in.readObject();
    }

    public static void main(String[] args) {
        System.out.println("Constructing	objects:");
        Blip3 b3 = new Blip3("A	String	", 47);
        b3.always = 13;
        System.out.println(b3.toString());
        try {
            ObjectOutputStream o =
                    new ObjectOutputStream(
                            new FileOutputStream("Blip3.out"));
            System.out.println("Saving	object:");
            o.writeObject(b3);
            o.close();
            //	Now	get	it	back:
            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream("Blip3.out"));
            System.out.println("Recovering	b3:");
            b3 = (Blip3) in.readObject();
            System.out.println(b3.toString());
            System.out.println(b3.always);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    ///:~
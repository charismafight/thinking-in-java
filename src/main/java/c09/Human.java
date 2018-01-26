package c09;

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

public class Human {
    public static void main(String[] args) {
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("sneeze exception");
        } catch (Annoyance a) {
            System.out.println("annoyance exception");
        }
    }
}



package c09;

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) throws Exception {
//        LostMessage lostMessage = new LostMessage();
//        try {
//            lostMessage.f();
//        } finally {
//            //当finally抛出异常时，会覆盖掉try中已经捕获到的异常，因为没有catch块
//            lostMessage.dispose();
//        }

        LostMessage lostMessage = new LostMessage();
        try {
            lostMessage.f();
        } catch (Exception e) {
            throw e;
        } finally {
            //当finally抛出异常时，会覆盖掉try中已经捕获到的异常，因为没有catch块
            lostMessage.dispose();
        }
    }
}

class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

package designpattern;

public class Command {
    public static void main(String[] args) {
        // r这个目标其实不是必须，最重要的就是invoker接受实现了Executable接口的东西，并可以通过run调用，而invoker本身实现了什么都是可以扩展的
        Object r = new Object();
        Executable executable = new Executer(r);
        Invoker invoker = new Invoker(executable);
        invoker.run();


        Thread thread = new Thread();
        thread.start();
    }
}

interface Executable {
    void exe();
}


class Executer implements Executable {
    private Object receiver;

    public Executer(Object receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exe() {

    }
}

class Invoker {
    Executable executable;

    public Invoker(Executable executable) {
        this.executable = executable;
    }

    public void run() {
        // do more
        executable.exe();
        // do more
    }
}
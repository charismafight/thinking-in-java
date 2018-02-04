package designpattern;


public class Decorate {
    public static void main(String[] args) {
        Iman man = new Shout(new Read(new Man()));
        man.show();
    }
}


interface Iman {
    void show();
}

class Man implements Iman {

    @Override
    public void show() {
        System.out.println("show man");
    }
}

abstract class Behavior implements Iman {
    private Iman m;

    public Behavior(Iman m) {
        this.m = m;
    }

    public void show() {
        m.show();
    }
}

class Read extends Behavior {
    // 关键实现,要求可以把一个实现了Iman接口的对象传进来统一调用它的show,达到装饰调用的效果
    public Read(Iman iman) {
        super(iman);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("show read");
    }
}

class Shout extends Behavior {
    public Shout(Iman iman) {
        super(iman);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("show shout");
    }
}
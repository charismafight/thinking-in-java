package designpattern;

public class Proxy {
    public static void main(String[] args) {
        Ticketmanager ticketmanager = new TicketProxy(new TicketmanagerImpl());
        ticketmanager.refund();
        ticketmanager.sell();
        ticketmanager.change();
    }
}

interface Ticketmanager {
    //买票去代理点买是一个典型的代理模式
    void sell();

    void change();

    void refund();
}

class TicketmanagerImpl implements Ticketmanager {

    @Override
    public void sell() {
        System.out.println("sell");
    }

    @Override
    public void change() {
        System.out.println("change");
    }

    @Override
    public void refund() {
        System.out.println("refund");
    }
}

class TicketProxy implements Ticketmanager {
    Ticketmanager ticketmanager;

    public TicketProxy(Ticketmanager t) {
        ticketmanager = t;
    }

    @Override
    public void sell() {
        ticketmanager.sell();
    }

    @Override
    public void change() {
        ticketmanager.change();
    }

    @Override
    public void refund() {
        ticketmanager.refund();
    }
}


package designpattern;

//Client可以调用的接口
interface Target {
    void request();
}

class Server {
    public void Serve() {
        System.out.println("this is server service");
    }
}

//这里比较关键，adapter本身是一个Server，但它实现Target来达到让Client调用Target但本质上运行的是Server里的serve方法
public class Adapter extends Server implements Target {
    Server server = new Server();

    @Override
    public void request() {
        server.Serve();
    }
}


class Client {
    public static void main(String[] args) {
        //客户端期望调用Server的Serve，但是接口不匹配
        Adapter adapter = new Adapter();
        adapter.request();
    }
}


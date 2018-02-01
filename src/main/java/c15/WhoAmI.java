package c15;

import java.net.InetAddress;

public class WhoAmI {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: WhoAmI MachineName");
            System.exit(1);
        }

        InetAddress address = InetAddress.getByName(args[0]);
        System.out.println(address);
    }
}

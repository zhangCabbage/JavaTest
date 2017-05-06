package zhang.algorithm.JavaTest.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by IntelliJ IDEA.
 * User: jiahua_MacPro
 * Date: 17/4/7
 * Time: 下午2:56
 * To change this template use File | Settings | File Templates.
 */
public class TCPClient {

    static class WriteToServer implements Runnable {
        private String name;

        public WriteToServer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                String address = "127.0.0.1";
                int port = 8888;
                byte[] data = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".getBytes();
                SocketChannel socketChannel = SocketChannel.open();
//                socketChannel.configureBlocking(false);
                if (!socketChannel.connect(new InetSocketAddress(address, port))) {
                    while (!socketChannel.finishConnect()) {
                        System.out.println(System.currentTimeMillis() + " " + this.name + " try connect!");
                    }
                }

                ByteBuffer writeBuf = ByteBuffer.wrap(data);
                System.out.println(System.currentTimeMillis() + " " + this.name + " connect success and try send!");
                socketChannel.write(writeBuf);
                System.out.println(System.currentTimeMillis() + " " + this.name + " send success !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread write1 = new Thread(new WriteToServer("[write 1]"));
        Thread write2 = new Thread(new WriteToServer("[write 2]"));

        write1.start();
        write2.start();
    }
}
